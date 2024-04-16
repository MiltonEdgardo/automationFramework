package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KeyPressesPage extends BasePage{

    @FindBy(id = "target")
    private WebElement inputBar;
    @FindBy(id = "result")
    private WebElement result;

    public KeyPressesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterAnyTextOrKey(String string) {
        writeText(inputBar, string);
    }

    public String getTextResult() {
        return getText(result);
    }
}
