package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
    private static WebDriver driver;

    private final By expandAll = By.xpath("//button[@title='Expand all']");
    private final By checkAll = By.xpath("//label[@for='tree-node-home']//span[@class='rct-checkbox']//*[name()='svg']");
    private final By selectedResult = By.xpath("//span[normalize-space()='home']");

    public CheckBox(WebDriver driver) {
        this.driver = driver;
    }

    public void clickExpand(){
        driver.findElement(expandAll).click();
    }

    public void selectAll(){

        WebElement checkbox = driver.findElement(checkAll);
        if(!checkbox.isSelected()){
            checkbox.click();
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement selectResult = driver.findElement(selectedResult);
        js.executeScript("arguments[0].scrollIntoView();", selectResult);
    }
    public void unselectAll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement unselectCheckbox = driver.findElement(checkAll);
        js.executeScript("arguments[0].scrollIntoView();", unselectCheckbox);

        WebElement checkbox = driver.findElement(checkAll);

            checkbox.click();

    }

    public boolean selected(){
        return driver.findElement(checkAll).isSelected();
    }
    public boolean displayed(){
        return driver.findElement(selectedResult).isDisplayed();
    }

    public String getSelectedResult(){
        return driver.findElement(selectedResult).getText();
    }

}
