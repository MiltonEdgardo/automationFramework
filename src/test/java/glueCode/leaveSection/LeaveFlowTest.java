package glueCode.leaveSection;

import glueCode.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoggedHomeOrangePage;
import pages.LoginOrangePage;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LeaveFlowTest extends BaseTest {
    private String TITLE_HOME_PAGE = "OrangeHRM";
    private String USER_LOGGED = "Paul Collings";

    @Test
    public void leaveFlow() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));

        LoginOrangePage loginOrangePage = new LoginOrangePage(driver);
        LoggedHomeOrangePage loggedHomeOrangePage = new LoggedHomeOrangePage(driver);

        loginOrangePage.navigateToOrangePage();
        Assert.assertEquals(loginOrangePage.getTitle(), TITLE_HOME_PAGE);

        loginOrangePage.enterUserNameAndPassword(loginOrangePage.getUserName(), loginOrangePage.getPassword());
        loginOrangePage.clickInLoginButton();

        Assert.assertTrue(loggedHomeOrangePage.checkIfDisplayedLoggedUserButton());

        loggedHomeOrangePage.clickOnLeaveButton();
        loggedHomeOrangePage.checkIfDisplayedDatePicker();
    }
}