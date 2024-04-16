package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramePage extends BasePage {

     @FindBy(xpath = "/html/frameset/frame[1]")
     private WebElement leftFrame;
    @FindBy(xpath = "/html/body")
    private WebElement textInFrame;
    @FindBy(xpath = "/html/frameset/frame[2]")
    private WebElement bottomFrame;

    public NestedFramePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void switchToMainFrame() {
        driver.switchTo().parentFrame();
    }

    public String getTextFromLeftFrame() {
        driver.switchTo().frame(leftFrame);
        driver.switchTo().frame(leftFrame);
        String leftText = getText(textInFrame);
        switchToMainFrame();
        switchToMainFrame();

        return leftText;
    }

    public String getTextFromBottomFrame(String bottomText) {
        driver.switchTo().frame(bottomFrame);
        bottomText = getText(textInFrame);
        switchToMainFrame();

        return bottomText;
    }
}
