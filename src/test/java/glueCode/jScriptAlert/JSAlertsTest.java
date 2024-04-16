package glueCode.jScriptAlert;

import glueCode.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.JSAlerts;
import pages.TheInternetHomePage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JSAlertsTest extends BaseTest {

    private String testAlertResult = "You successfully clicked an alert";
    private String textJSAlert= "I am a JS Alert";
    private String textJSConfirm= "I am a JS Confirm";
    private String testResultConfirmCancel = "You clicked: Cancel";
    private String testResultConfirmAccept = "You clicked: Ok";
    private String getTextJSPrompt = "I am a JS prompt";
    private String textPromptResult = "You entered: ";
    private String textPromptResulNull = "null";

    private String promptText = "This is a prompt bar";



    @Test
    public void alertTest() {
        //Navigate to home page and then on JS Alert link
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        JSAlerts jSAlertPage = theInternetHomePage.clickOnJavaScriptAlertsLink();

        //CLick on JS Alert button
        jSAlertPage.clickOnJSAlertButton();

        //Validate the Text alert
        Assert.assertEquals("The text alert is incorrect", textJSAlert, jSAlertPage.getTheAlertText());

        //Click on accept button alert
        jSAlertPage.clickOnAcceptButtonAlert();

        //Validate the text result
        Assert.assertEquals("The message result is incorrect", testAlertResult, jSAlertPage.getResultTextSection());
    }

    @Test
    public void jSConfirmTest() {
        //Navigate to home page and then on JS Confirm link
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        JSAlerts jSAlertPage = theInternetHomePage.clickOnJavaScriptAlertsLink();

        //CLick on JS Confirm button
        jSAlertPage.clickOnJSConfirmButton();

        //Validate the Text alert
        Assert.assertEquals("The text alert is incorrect", textJSConfirm, jSAlertPage.getTheAlertText());

        //CLick on Accept Alert button
        jSAlertPage.clickOnAcceptButtonAlert();

        //Validate the text result
        Assert.assertEquals("The message result is incorrect", testResultConfirmAccept, jSAlertPage.getResultTextSection());

        //CLick on JS Confirm button
        jSAlertPage.clickOnJSConfirmButton();

        //Validate the Text alert
        Assert.assertEquals("The text alert is incorrect", textJSConfirm, jSAlertPage.getTheAlertText());

        //CLick on Cancel Alert button
        jSAlertPage.clickOnCancelButtonAlert();

        //Validate the text result
        Assert.assertEquals("The message result is incorrect", testResultConfirmCancel, jSAlertPage.getResultTextSection());
    }

    @Test
    public void jsPromptTest() {
        //Navigate to home page and then on JS Confirm link
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        JSAlerts jSAlertPage = theInternetHomePage.clickOnJavaScriptAlertsLink();

        //CLick on JS Prompt button
        jSAlertPage.clickOnJSPromptButton();

        //Validate the Text alert
        Assert.assertEquals("The text alert is incorrect", getTextJSPrompt, jSAlertPage.getTheAlertText());

        //CLick on Cancel Alert button
        jSAlertPage.clickOnCancelButtonAlert();

        //Validate the text result
        Assert.assertEquals("The message result is incorrect", textPromptResult + textPromptResulNull, jSAlertPage.getResultTextSection());

        //CLick on JS Prompt button
        jSAlertPage.clickOnJSPromptButton();

        //CLick on Accept Alert button
        jSAlertPage.clickOnAcceptButtonAlert();

        //Validate the text result
        Assert.assertEquals("The message result is incorrect", textPromptResult.trim(), jSAlertPage.getResultTextSection());

        //CLick on JS Prompt button
        jSAlertPage.clickOnJSPromptButton();

        //Enter the String on prompt bar
        jSAlertPage.sendKeysOnPromptAlert(promptText);

        //CLick on Accept Alert button
        jSAlertPage.clickOnAcceptButtonAlert();

        //Validate the text result
        Assert.assertEquals("The message result is incorrect", textPromptResult + promptText, jSAlertPage.getResultTextSection());
    }
}