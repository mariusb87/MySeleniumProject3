package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton {
    public static WebDriver driver;
    By radio1 = By.xpath("//label[@for='yesRadio']");
    By radio2 = By.xpath("//label[@for='impressiveRadio']");
    By radio3 = By.xpath("//label[@for='noRadio']']");
    By selectedResult = By.xpath("//span[@class='text-success']");

    public RadioButton(WebDriver driver){
        this.driver = driver;
    }

    public void clickRadio1(){
        try {
            if (!driver.findElement(radio1).isSelected()) {
                driver.findElement(radio1).click();
            }
        }catch(Exception e){
            System.out.println("'Yes' radiobutton is inactiv!");
        }
    }
    public void clickRadio2(){
        try {
            if (!driver.findElement(radio2).isSelected()) {
                driver.findElement(radio2).click();
            }
        }catch(Exception e){
            System.out.println("'Impressive' radiobutton is inactiv!");
        }
    }
    public void clickRadio3(){
        try {
            if (!driver.findElement(radio3).isSelected()) {
                driver.findElement(radio3).click();
            }
        }catch(Exception e){
            System.out.println("'No' radiobutton is inactiv!");
        }
    }

    public String getSelectedResult(){
        return driver.findElement(selectedResult).getText();
    }


}
