package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormAuthenticationPage extends BasePage {
    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"login\"]/button")
    private WebElement loginButton;
    @FindBy(id = "flash")
    private WebElement securityMessage;


    public FormAuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToFormAuthenticationPage() {
        navigateTo("https://the-internet.herokuapp.com/login");
    }
    public void enterUserNameAndPassword(String userName, String pass) {
        writeText(username, userName);
        writeText(password, pass);
    }

    public SecureAreaPage clickonLoginButton() {
        clickElement(loginButton);
        return new SecureAreaPage(driver);
    }

    public String getSecurityMessage() {
        return getText(securityMessage);
    }

}
