package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class KeyPressTest {
    public static WebDriver driver;

    @BeforeTest
    public void setUp(){
        // 1. deschide pagina Form Authentication
        //driver = new ChromeDriver();

        driver = new ChromeDriver();

        System.out.println("Deschide pagina");
        driver.get("https://the-internet.herokuapp.com/key_presses");
        driver.manage().window().maximize();
    }
@Test
    public void pressKey(){
        WebElement input = driver.findElement(By.id("target"));
        input.sendKeys(Keys.ARROW_UP);

        WebElement actualText = driver.findElement(By.id("result"));

        String expected = "You entered: UP";

        Assert.assertEquals(actualText.getText(),expected);

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
