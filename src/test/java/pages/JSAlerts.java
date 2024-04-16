package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JSAlerts extends BasePage{
    @FindBy(xpath = "//button[text()=\"Click for JS Alert\"]")
    private WebElement jSAlertButton;
    @FindBy(xpath = "//button[text()=\"Click for JS Confirm\"]")
    private WebElement jSConfirmButton;
    @FindBy(xpath = "//button[text()=\"Click for JS Prompt\"]")
    private WebElement jSPromptButton;
    @FindBy(id = "result")
    private WebElement resultSection;

    public JSAlerts(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickOnJSAlertButton() {
        clickElement(jSAlertButton);
    }
    public void clickOnJSConfirmButton() {
        clickElement(jSConfirmButton);
    }
    public void clickOnJSPromptButton() {
        clickElement(jSPromptButton);
    }
    public void clickOnAcceptButtonAlert() {
        driver.switchTo().alert().accept();
    }
    public void clickOnCancelButtonAlert() {
        driver.switchTo().alert().dismiss();
    }
    public void sendKeysOnPromptAlert(String key) {
        driver.switchTo().alert().sendKeys(key);
    }
    public String getResultTextSection() {
        return getText(resultSection);
    }
    public String getTheAlertText() {
        return driver.switchTo().alert().getText();
    }


}
