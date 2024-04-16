package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePage extends BasePage {

    @FindBy(id = "mce_0_ifr")
    private WebElement iFrame;
    @FindBy(xpath = "//*[@id=\"tinymce\"]/p")
    private WebElement textEditorIFrame;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div[1]/div[1]/div[2]/div/div[5]/button[2]")
    private WebElement idetantationButtonFromEditorFrame;

    public IFramePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clearTheTextAreaFromFrameEditor() {
        switchToFrame(iFrame);
        textEditorIFrame.clear();
        switchToMainFrame();
    }

    public void setTextInIFrameEditor(String text) {
        switchToFrame(iFrame);
        textEditorIFrame.sendKeys(text);
        switchToMainFrame();
    }

    public void switchToMainFrame() {
        driver.switchTo().parentFrame();
    }

    public void setIdentation() {
        clickElement(idetantationButtonFromEditorFrame);
    }

    public String getTextFroTextEditorFrame() {
        switchToFrame(iFrame);
        String textToGet = getText(textEditorIFrame);
        switchToMainFrame();

        return textToGet;
    }
}
