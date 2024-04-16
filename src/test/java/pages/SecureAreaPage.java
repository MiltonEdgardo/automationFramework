package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage extends BasePage{

    @FindBy(id = "flash")
    private WebElement secureMessage;
    public SecureAreaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSecureText() {
        return getText(secureMessage).trim();
    }
}
