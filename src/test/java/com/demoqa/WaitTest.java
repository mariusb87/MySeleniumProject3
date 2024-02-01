package com.demoqa;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class WaitTest {
    public static WebDriver driver;

        @BeforeTest
        public void setUp(){
            driver = new ChromeDriver();
            driver.get("https://demoqa.com/alerts");
            driver.manage().window().maximize();

            WebElement consentButton = driver.findElement(By.xpath("//button[@aria-label='Consent']"));

            if (consentButton.isDisplayed()) {
                consentButton.click();
            }
        }
        @Test
        public void waitTest() {

            WebElement clickAlerts = driver.findElement(By.id("timerAlertButton"));
            clickAlerts.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

            //Wait for the alert to be displayed and store it in a variable
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            //Store the alert text in a variable
            String text = alert.getText();

            //Press the OK button
            alert.accept();

        }

    @Test
    public void confirmboxTest() {

        WebElement clickAlerts = driver.findElement(By.id("confirmButton"));
        clickAlerts.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        //Wait for the alert to be displayed
        wait.until(ExpectedConditions.alertIsPresent());

        //Store the alert in a variable
        Alert alert = driver.switchTo().alert();

        //Store the alert in a variable for reuse
        String text = alert.getText();

        //Press the Ok button
        alert.accept();

        WebElement confirmResult = driver.findElement(By.id("confirmResult"));

        String expectedResult1 = "You selected Ok";

        Assert.assertTrue(confirmResult.getText().contains(expectedResult1));

    }


    @AfterTest(alwaysRun = true)
    public void tearDown(){
        System.out.println("Inchide pagina");
        driver.quit();
    }

}

