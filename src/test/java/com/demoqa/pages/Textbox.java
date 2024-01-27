package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Textbox {
    private WebDriver driver;

    private final By inputName = By.xpath("//input[@id='userName']");
    private final By inputEmail = By.xpath("//input[@id='userEmail']");
    private final By inputCurrentAdress = By.xpath("//textarea[@id='currentAddress']");
    private final By inputPermanentAddress = By.xpath("//textarea[@id='permanentAddress']");
    public By buttonSubmit = By.xpath("//button[@id='submit']");

    public final By outputName = By.xpath("//p[@id='name']");
    public final By outputEmail = By.xpath("//p[@id='email']");
    public final By outputCurrentAdress = By.xpath("//p[@id='currentAddress']");
    public final By outputPermanentAddress = By.xpath("//p[@id='permanentAddress']");

    public Textbox(WebDriver driver) {
        this.driver = driver;
    }

    public void setTextInName(String text){
        driver.findElement(inputName).sendKeys(text);
    }
    public void setTextInEmail(String text){
        driver.findElement(inputEmail).sendKeys(text);
    }
    public void setTextInCurrentAddress(String text){
        driver.findElement(inputCurrentAdress).sendKeys(text);
    }
    public void setTextInPermanentAddress(String text){
        driver.findElement(inputPermanentAddress).sendKeys(text);
    }

    public void clikSubmit(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement button = driver.findElement(buttonSubmit);
        js.executeScript("arguments[0].scrollIntoView();", button);
        driver.findElement(buttonSubmit).click();
    }

    public String getOutputName(){
        return driver.findElement(outputName).getText();
    }
    public String getOutputEmail(){
        return driver.findElement(outputEmail).getText();
    }
    public String getOutputCurrentAdress(){
        return driver.findElement(outputCurrentAdress).getText();
    }
    public String getOutputPermanentAddress(){
        return driver.findElement(outputPermanentAddress).getText();
    }


}
