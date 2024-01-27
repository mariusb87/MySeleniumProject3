package com.demoqa;

import com.demoqa.pages.Textbox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextboxTest extends BaseTest{
    @Test
    public void textBoxValidation(){

        Textbox textbox = new Textbox(driver);

        textbox.setTextInName("Marius");
        textbox.setTextInEmail("marius@qa.com");
        textbox.setTextInCurrentAddress("Cluj-Napoca, Romania");
        textbox.setTextInPermanentAddress("Gherla, Romania");

        textbox.clikSubmit();

        Assert.assertTrue(textbox.getOutputName().contains("Marius"));
        Assert.assertTrue(textbox.getOutputEmail().contains("marius@qa.com"));
        Assert.assertTrue(textbox.getOutputCurrentAdress().contains("Cluj-Napoca, Romania"));
        Assert.assertTrue(textbox.getOutputPermanentAddress().contains("Gherla, Romania"));

    }

}
