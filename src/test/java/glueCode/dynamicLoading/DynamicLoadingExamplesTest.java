package glueCode.dynamicLoading;

import glueCode.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingExample2Page;
import pages.DynamicLoadingPage;
import pages.TheInternetHomePage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DynamicLoadingExamplesTest extends BaseTest {

    private String helloWorldText = "Hello World!";
    @Test
    public void loadingExample1Test() {
        //Navigate to home page and then to File Upload link
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        DynamicLoadingPage dynamicLoadingPage = theInternetHomePage.clickOnDynamicLoadingLink();
        DynamicLoadingExample1Page dynamicLoadingExample1Test = dynamicLoadingPage.clickOnExample1();

        //Click on start button and validate the text
        Assert.assertEquals(helloWorldText, dynamicLoadingExample1Test.clickOnStartButtonAndGetTheTextLoaded());
    }

    @Test
    public void loadingExample2Test() {
        //Navigate to home page and then to File Upload link
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        DynamicLoadingPage dynamicLoadingPage = theInternetHomePage.clickOnDynamicLoadingLink();
        DynamicLoadingExample2Page dynamicLoadingExample2Test = dynamicLoadingPage.clickOnExample2();

        //Click on start button and validate the text
        Assert.assertEquals(helloWorldText, dynamicLoadingExample2Test.clickOnStartButtonAndGetTheTextLoaded());
    }


}
