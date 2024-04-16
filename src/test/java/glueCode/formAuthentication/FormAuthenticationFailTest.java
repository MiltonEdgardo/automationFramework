package glueCode.formAuthentication;

import glueCode.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.FormAuthenticationPage;
import pages.TheInternetHomePage;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FormAuthenticationFailTest extends BaseTest {

    @ParameterizedTest(name = "{index}")
    @MethodSource("provideUsernameAndPassword")
    public void failLoginFormAuthentication(String username, String password, String expectedMessage) {

        //Go to home page and click on Form Authentication link
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        theInternetHomePage.navigateToTheInternetHomePage();
        FormAuthenticationPage formAuthenticationPage = theInternetHomePage.clickOnAuthenticationFormLink();

        //enter username and password and click on login button
        formAuthenticationPage.enterUserNameAndPassword(username, password);
        formAuthenticationPage.clickonLoginButton();

        //validate error alert message
        Assert.assertTrue(formAuthenticationPage.getSecurityMessage().contains(expectedMessage));
    }

    private static Stream<Arguments> provideUsernameAndPassword() {
        return Stream.of(
                Arguments.of("tomsmith", "SuperSecretPassword", "Your password is invalid!"),
                Arguments.of("Tomsmith", "SuperSecretPassword!", "Your username is invalid!")
        );
    }
}
