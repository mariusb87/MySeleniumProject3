package com.demoqa;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class UploadDownloadTest {
    public static WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        WebElement consentButton = driver.findElement(By.xpath("//button[@aria-label='Consent']"));

        if (consentButton.isDisplayed()) {
            consentButton.click();
        }
    }
    @Test(priority = 1)
    public void downloadTest() {
        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

    }

    @Test(priority = 2)
    public void uploadTest() {

        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@id='uploadFile']"));
        chooseFileButton.sendKeys("C:\\Users\\Marius\\IdeaProjects\\MySeleniumProject3\\src\\test\\resources\\seleniumUpload.txt");

        WebElement actualResult = driver.findElement(By.xpath("//p[@id='uploadedFilePath']"));
        String expectedResult = "C:\\fakepath\\seleniumUpload.txt";
        Assert.assertTrue(actualResult.getText().contains(expectedResult));
    }



    @AfterTest(alwaysRun = true)
    public void tearDown(){
        System.out.println("Inchide pagina");
        driver.quit();
    }

}

