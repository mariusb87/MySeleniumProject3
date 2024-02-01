package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadTest {
    public static WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
/*
        WebElement consentButton = driver.findElement(By.xpath("//button[@aria-label='Consent']"));

        if (consentButton.isDisplayed()) {
            consentButton.click();
        }

 */
    }

    @Test
    public void uploadTest(){
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        fileUpload.sendKeys("C:\\Users\\Marius\\IdeaProjects\\MySeleniumProject3\\src\\test\\resources\\seleniumUpload.txt");

        WebElement uploadFile = driver.findElement(By.id("file-submit"));
        uploadFile.click();

        WebElement message = driver.findElement(By.xpath("//h3"));

        String expectedResult = "File Uploaded!";
        Assert.assertTrue(message.getText().contains(expectedResult));

}
    @AfterTest(alwaysRun = true)
    public void tearDown(){
        System.out.println("Inchide pagina");
        driver.quit();
    }

}