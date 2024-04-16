package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends BasePage{
    @FindBy(xpath = "//a[contains(text(), 'Example 1')]")
    WebElement example1Link;
    @FindBy(xpath = "//a[contains(text(), 'Example 2')]")
    WebElement example2Link;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DynamicLoadingExample1Page clickOnExample1() {
        clickElement(example1Link);
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickOnExample2() {
        clickElement(example2Link);
        return new DynamicLoadingExample2Page(driver);
    }
}
