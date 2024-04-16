package glueCode.login;

import glueCode.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.TheInternetHomePage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TheInternetHomePageTest extends BaseTest {

    private String TITLE_HOME_PAGE = "Welcome to the-internet";

    @Test
    public void happyPathLogin() {
        //Instance of class and navigate to the url
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        theInternetHomePage.navigateToTheInternetHomePage();

        //Get the title and validate it
        theInternetHomePage.getTitleAndValidate(TITLE_HOME_PAGE);
    }


}
