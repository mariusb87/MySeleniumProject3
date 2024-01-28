package com.demoqa;

import com.demoqa.pages.Textbox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextboxTest extends BaseTest{
    @Test
    public void textBoxValidation(){

        Textbox textboxPage = new Textbox(driver);

        textboxPage.setTextInName("Marius");
        textboxPage.setTextInEmail("marius@qa.com");
        textboxPage.setTextInCurrentAddress("Cluj-Napoca, Romania");
        textboxPage.setTextInPermanentAddress("Gherla, Romania");

        textboxPage.clikSubmit();

        Assert.assertTrue(textboxPage.getOutputName().contains("Marius"));
        Assert.assertTrue(textboxPage.getOutputEmail().contains("marius@qa.com"));
        Assert.assertTrue(textboxPage.getOutputCurrentAdress().contains("Cluj-Napoca, Romania"));
        Assert.assertTrue(textboxPage.getOutputPermanentAddress().contains("Gherla, Romania"));

    }

}
