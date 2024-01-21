package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginNegativTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();
        //driver = new EdgeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        //2. click pe Form Authentication
        WebElement linkTextFormAuthentication = driver.findElement(By.linkText("Form Authentication"));
        linkTextFormAuthentication.click();

    }
    public void LoginMethod(String inputUsername, String inputPassword ){

        //3. click username & enter user : Marius
        WebElement userNameInput = driver.findElement(By.xpath("//input[@name='username']"));
        userNameInput.sendKeys(inputUsername);

        //4. click username & enter password : 123456789
        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        passwordInput.sendKeys(inputPassword);

        // 5. click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();

        //sleep(1000);

    }
    @Test(priority = 1)
    @Parameters({"Username","Password", "errorMessage"})
    public void negativTest(String username, String password, String errorMessage){

        LoginMethod(username,password);

        // 6. Expected result: Your username is invalid!
        WebElement subHeader = driver.findElement(By.id("flash"));
        String actualSubHeader = subHeader.getText();
        String expectedSubheader = errorMessage;
        Assert.assertTrue(actualSubHeader.contains(expectedSubheader));

        //sleep(1000);
    }

    /*
    @Test(priority = 2)
    @Parameters({"correctUsername","wrongPassword"})
    public void CorrectUsernameWrongPassword(String correctUsername, String wrongPassword){

        LoginMethod(correctUsername,wrongPassword);

        // 6. Expected result: Your username is invalid!
        WebElement subHeader = driver.findElement(By.id("flash"));
        String actualSubHeader = subHeader.getText();
        String expectedSubheader = "Your password is invalid!";
        Assert.assertTrue(actualSubHeader.contains(expectedSubheader));

        //sleep(1000);
    }
    @Test(priority = 3)
    @Parameters({"wrongUsername","wrongPassword"})
    public void WrongUsernameWrongPassword(String wrongUsername, String wrongPassword){

        LoginMethod(wrongUsername, wrongPassword);

        // 6. Expected result: Your username is invalid!
        WebElement subHeader = driver.findElement(By.id("flash"));
        String actualSubHeader = subHeader.getText();
        String expectedSubheader = "Your username is invalid!";
        Assert.assertTrue(actualSubHeader.contains(expectedSubheader));

        //sleep(1000);
    }


     */

    @AfterTest
    public void teadDown(){
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