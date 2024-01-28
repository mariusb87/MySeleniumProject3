package com.demoqa;

import com.demoqa.pages.CheckBox;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {
    @Test
    public void checkAll(){
        CheckBox checkboxPage = new CheckBox(driver);
        checkboxPage.clickExpand();
        checkboxPage.selectAll();;

        sleep(2000);

        //Assert.assertTrue(checkboxPage.selected());
        Assert.assertTrue(checkboxPage.getSelectedResult().contains("home"));

    }
    @Test
    public void uncheckAll(){
        CheckBox checkboxPage = new CheckBox(driver);
        checkboxPage.clickExpand();

        checkboxPage.unselectAll();
        sleep(2000);
        Assert.assertFalse(checkboxPage.selected());

    }
}
