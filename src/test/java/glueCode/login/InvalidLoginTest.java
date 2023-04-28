package glueCode.login;

import glueCode.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginOrangePage;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InvalidLoginTest extends BaseTest {
    private String userName = "Administrador";
    private String password = "administrador123";
    private String TITLE_HOME_PAGE = "OrangeHRM";
    private String INVALID_TEXT = "Invalid credentials";

    @Test
    public void unhappyPathTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));

        LoginOrangePage loginOrangePage = new LoginOrangePage(driver);

        loginOrangePage.navigateToOrangePage();
        Assert.assertEquals(loginOrangePage.getTitle(), TITLE_HOME_PAGE);

        loginOrangePage.enterUserNameAndPassword(userName, password);
        loginOrangePage.clickInLoginButton();

        Assert.assertEquals(INVALID_TEXT, loginOrangePage.getInvalidLoginMessage());
    }
}
