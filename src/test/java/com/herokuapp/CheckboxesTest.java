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

public class CheckboxesTest {
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
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();
    }

    @Test
    public void checkAll(){
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));

        if(!checkbox1.isSelected()){
            checkbox1.click();
        }

        sleep(2000);

        Assert.assertTrue(checkbox1.isSelected());

        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        checkbox2.click();

        if(!checkbox2.isSelected()){
            checkbox2.click();
        }

        sleep(2000);

        Assert.assertTrue(checkbox2.isSelected());

    }

    public void uncheckAll(){
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));

        if(checkbox1.isSelected()){
            checkbox1.click();
        }

        sleep(2000);

        Assert.assertFalse(checkbox1.isSelected());

        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        checkbox2.click();

        if(checkbox2.isSelected()){
            checkbox2.click();
        }

        sleep(2000);
        String checkbox2checked = checkbox1.getAttribute("checked");
        Assert.assertFalse(checkbox2.isSelected());

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
