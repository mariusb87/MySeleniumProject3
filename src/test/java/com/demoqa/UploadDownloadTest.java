package com.demoqa;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadDownloadTest {

    public static WebDriver driver;
    private static String downloadPath = "C:\\Users\\Marius\\Downloads\\";
    private static String uploadFilePath = "C:\\Users\\Marius\\IdeaProjects\\MySeleniumProject3\\src\\test\\resources\\seleniumUpload.txt";

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

    public void downloadTest() throws InterruptedException, IOException {
        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();



        Assert.assertTrue(isFileDownloaded(downloadPath, "sampleFile.jpeg"), "Failed to download Expected document");

    }

    @Test(priority = 2)
    public void uploadTest() {

        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@id='uploadFile']"));
        chooseFileButton.sendKeys(uploadFilePath);

        WebElement actualResult = driver.findElement(By.xpath("//p[@id='uploadedFilePath']"));
        String expectedResult = "C:\\fakepath\\seleniumUpload.txt";
        Assert.assertTrue(actualResult.getText().contains(expectedResult));
    }


    @AfterTest(alwaysRun = true)
    public void tearDown(){
        System.out.println("Inchide pagina");
        driver.quit();
    }

    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag=true;
        }

        return flag;
    }

}

