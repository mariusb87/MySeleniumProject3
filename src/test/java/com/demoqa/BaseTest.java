package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    @BeforeTest
    @Parameters({"browser","link"})
    public void setUp(String browser, String link){

        switch (browser){
            case "chrome": driver = new ChromeDriver();break;
            case "edge": driver = new EdgeDriver();break;
            case "firefox": driver = new FirefoxDriver();break;
            default: driver = new ChromeDriver();
        }

        driver.get(link);
        driver.manage().window().maximize();

    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){

        driver.quit();

    }

    public static void sleep(int miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
