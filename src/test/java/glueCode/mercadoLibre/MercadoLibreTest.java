package glueCode.mercadoLibre;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glueCode.Hooks;
import glueCode.TestContext;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MercadoLibrePage;

public class MercadoLibreTest {
    private TestContext testContext;
    private WebDriver driver = Hooks.getDriver();
    MercadoLibrePage mercadoLibrePage = new MercadoLibrePage(driver);

    @Given("a user that go to page")
    public void aUserThatGoTo() {
        driver.get("https://www.mercadolibre.com/");
    }

    @When("the user is in the home page and do click on the country (.*)")
    public void theUserIsInThHomePageAndDoClickOnThe(String string) {
        mercadoLibrePage.clickOnCountryLink();
    }

    @Then("should return the next title (.*)")
    public void shouldRedirectToTheSeccionPage(String title) {
        Assert.assertTrue("No page detected", driver.getTitle().equals(title));
    }
}
