package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogoutTest {
    public static WebDriver driver;

    @BeforeTest

    public void setUP(){
        // 1. deschide pagina Form Authentication
        driver = new ChromeDriver();

        System.out.println("Deschide pagina");
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test
    @Parameters({"Username","Password"})
    public void Logout(String username, String password){

        System.out.println("Asteapta 3 secunde");

        WebElement loginLink = driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[21]/a"));
        loginLink.click();

        // 2. click username & enter user : tomsmith
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);

        // 3. click password & enter: SuperSecretPassword
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        // 4. click login button
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

        // 5. click logout button
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i"));
        logoutButton.click();

        // 6. Expected result: You logged out of the secure area!
        WebElement subHeader = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String actualSubHeader = subHeader.getText();
        String expectedSubheader = "You logged out of the secure area!";
        Assert.assertTrue(actualSubHeader.contains(expectedSubheader));

    }
    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
