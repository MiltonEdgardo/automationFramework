package glueCode.formAuthentication;

import glueCode.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.FormAuthenticationPage;
import pages.SecureAreaPage;
import pages.TheInternetHomePage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FormAuthenticationSuccesTest extends BaseTest {
    private String username = "tomsmith";
    private String password = "SuperSecretPassword!";
    private String SECURE_MESSAGE = "You logged into a secure area!";

    @Test
    public void succesLoginFormAuthentication() {
        //Go to home page and click on Form Authentication link
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        theInternetHomePage.navigateToTheInternetHomePage();
        FormAuthenticationPage formAuthenticationPage = theInternetHomePage.clickOnAuthenticationFormLink();

        //enter username and password and click on login button
        formAuthenticationPage.enterUserNameAndPassword(username, password);
        SecureAreaPage secureAreaPage = formAuthenticationPage.clickonLoginButton();

        //Validate secure web message
        Assert.assertTrue(secureAreaPage.getSecureText().contains(SECURE_MESSAGE));
    }
}
