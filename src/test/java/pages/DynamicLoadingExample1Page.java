package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingExample1Page extends BasePage {

    @FindBy(xpath = "//*[@id=\"start\"]/button")
    WebElement startButton;
    @FindBy(xpath = "//*[@id=\"finish\"]/h4")
    WebElement textAfterLoading;
    public DynamicLoadingExample1Page(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String clickOnStartButtonAndGetTheTextLoaded() {
        clickElement(startButton);
        String getText = getText(textAfterLoading);

        return getText;
    }
}
