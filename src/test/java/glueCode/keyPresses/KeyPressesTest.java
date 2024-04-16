package glueCode.keyPresses;

import glueCode.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.Keys;
import pages.KeyPressesPage;
import pages.TheInternetHomePage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class KeyPressesTest extends BaseTest {

    private String inputResult = "You entered: SPACE";

    @Test
    public void pressSpaceKey() {
        //Navigate from home page to the key presses section
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        theInternetHomePage.navigateToTheInternetHomePage();
        KeyPressesPage keyPressesPage = theInternetHomePage.clickOnKeyPressesLink();

        //Send SPACE key in the input bar
        keyPressesPage.enterAnyTextOrKey(String.valueOf(Keys.SPACE));

        //Validate the result
        Assert.assertEquals("Incorrect result", inputResult, keyPressesPage.getTextResult());
    }

}
