package com.demoqa;

import com.demoqa.pages.RadioButton;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadiobuttonTest extends BaseTest{

    @Test
    public void radioButtonValidation(){
        RadioButton radiobuttonPage = new RadioButton(driver);

        radiobuttonPage.clickRadio1();
        Assert.assertTrue(radiobuttonPage.getSelectedResult().contains("Yes"));

        radiobuttonPage.clickRadio2();
        Assert.assertTrue(radiobuttonPage.getSelectedResult().contains("Impressive"));

        radiobuttonPage.clickRadio3();
        Assert.assertTrue(radiobuttonPage.getSelectedResult().contains("No"));
    }

}
