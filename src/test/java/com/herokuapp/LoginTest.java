package com.herokuapp;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
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

public class LoginTest {
    public static WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser){
        // 1. deschide pagina Form Authentication
        //driver = new ChromeDriver();

        switch (browser){
            case "chrome": driver = new ChromeDriver();break;
            case "edge": driver = new EdgeDriver();break;
            case "firefox": driver = new FirefoxDriver();break;
            default: driver = new ChromeDriver();

        }

        System.out.println("Deschide pagina");
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test( priority = 1)
    @Parameters({"Username","Password"})
    public void login(String username, String password){

        System.out.println("Asteapta 3 secunde");
        sleep(2000);

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

        // 5. Expected result: Welcome to the Secure Area
        WebElement securedAreaSubheader = driver.findElement(By.className("subheader"));
        String subheaderContent = "Welcome to the Secure Area. When you are done click logout below.";

        Assert.assertTrue(securedAreaSubheader.isDisplayed());
        Assert.assertEquals(subheaderContent,securedAreaSubheader.getText());

        String secureURL = "https://the-internet.herokuapp.com/secure";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,secureURL);

        WebElement succesMessage = driver.findElement(By.id("flash"));
        String succesMessageContent = "You logged into a secure area!";
        Assert.assertTrue(succesMessage.getText().contains(succesMessageContent));


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