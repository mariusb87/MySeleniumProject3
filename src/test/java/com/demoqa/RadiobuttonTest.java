package com.demoqa;

import com.demoqa.pages.RadioButton;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadiobuttonTest extends BaseTest{

    @Test
    public void radioButtonValidation(){
        RadioButton radio = new RadioButton(driver);

        radio.clickRadio1();
        Assert.assertTrue(radio.getSelectedResult().contains("Yes"));

        radio.clickRadio2();
        Assert.assertTrue(radio.getSelectedResult().contains("Impressive"));

        radio.clickRadio3();
        Assert.assertTrue(radio.getSelectedResult().contains("No"));
    }

}
