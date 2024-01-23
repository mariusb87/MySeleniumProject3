package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownTest {
    public static WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser){
        // 1. deschide pagina Form Authentication
        switch (browser){
            case "chrome": driver = new ChromeDriver();break;
            case "edge": driver = new EdgeDriver();break;
            case "firefox": System.setProperty("webdriver.gecko.driver",
                    "src/test/resources/geckodriver-v0.34.0-win-aarch64/geckodriver.exe");
                    driver = new FirefoxDriver();
                break;
            default: driver = new ChromeDriver();
        }

        System.out.println("Deschide pagina");
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
    }

    @Test
    public void selectFromDropdown(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select dropdownElement = new Select(dropdown); // am facut elementul de tip select
        dropdownElement.selectByValue("1");
        sleep(2000);
        WebElement option1 = driver.findElement(By.xpath("//*[@value='1']"));
        Assert.assertTrue(option1.isSelected());

        dropdownElement.selectByVisibleText("Option 2");
        sleep(2000);
        WebElement option2 = driver.findElement(By.xpath("//*[@value='2']"));
        Assert.assertTrue(option2.isSelected());
    }

    public static void sleep(int miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterTest(alwaysRun = true)
    public void tearDown(){
        System.out.println("Inchide pagina");
        driver.quit();
    }
}
