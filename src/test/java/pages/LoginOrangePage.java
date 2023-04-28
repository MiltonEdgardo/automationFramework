package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrangePage extends BasePage{
    @FindBy(xpath = "//*[@name=\"username\"]")
    private WebElement usernameBar;
    @FindBy(xpath = "//*[@name=\"password\"]")
    private WebElement passwordBar;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[1]")
    private WebElement userName;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[2]")
    private WebElement password;
    @FindBy(xpath = "//*[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]")
    private WebElement invalidTextLogin;



    public LoginOrangePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUserNameAndPassword(String userName, String password) {
        writeText(this.usernameBar, userName);
        writeText(this.passwordBar, password);
    }
    public void clickInLoginButton() {
        clickElement(loginButton);
    }

    public void navigateToOrangePage() {
        navigateTo("https://opensource-demo.orangehrmlive.com/");
    }

    public String getUserName() {
        String[] getText = getText(userName).split(": ");
        return getText[1];
    }

    public String getPassword() {
        String[] getText = getText(password).split(": ");
        return getText[1];
    }

    public String getInvalidLoginMessage() {
        return getText(invalidTextLogin);
    }
}
