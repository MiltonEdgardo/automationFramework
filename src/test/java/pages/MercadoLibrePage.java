package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercadoLibrePage extends BasePage {

    @FindBy(id = "AR")
    WebElement countryHomePageLink;

    public MercadoLibrePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnCountryLink() {
        this.clickElement(countryHomePageLink);
    }

}
