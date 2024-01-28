package com.demoqa;

import com.demoqa.pages.CheckBox;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {
    @Test
    public void checkAll(){
        CheckBox checkbox = new CheckBox(driver);
        checkbox.clickExpand();
        checkbox.selectAll();;

        sleep(2000);

        //Assert.assertTrue(checkbox.selected());
        Assert.assertTrue(checkbox.getSelectedResult().contains("home"));

    }
    @Test
    public void uncheckAll(){
        CheckBox checkbox = new CheckBox(driver);
        checkbox.clickExpand();

        checkbox.unselectAll();
        sleep(2000);
        Assert.assertFalse(checkbox.selected());

    }
}
