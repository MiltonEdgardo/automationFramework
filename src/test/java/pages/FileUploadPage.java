package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage extends BasePage{

    @FindBy(id = "file-upload")
    private WebElement fileUploadBox;

    private By fileBox = By.id("file-upload");
    @FindBy(id = "file-submit")
    private WebElement fileSubmitButton;
    @FindBy(xpath = "//*[@id=\"content\"]/script[3]")
    private WebElement dragAnmdDropArea;
    @FindBy(id = "uploaded-files")
    private WebElement textFileUploaded;
    @FindBy(xpath = "//*[@id=\"drag-drop-upload\"]/div/div[1]/div/span")
    private WebElement textDragAndDropArea;



    public FileUploadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void uploadFileByFileBar(String absolutePath) {
        fileUploadBox.sendKeys(absolutePath);
        clickOnUploadButton();
    }

    public void clickOnUploadButton() {
        clickElement(fileSubmitButton);
    }

    public String getFileTextUploaded() {
        return getText(textFileUploaded);
    }

    public void uploadFileByDragAndDrop(String absolutePath) {
        dragAnmdDropArea.sendKeys(absolutePath);
        clickOnUploadButton();
    }

    public String getTextFromDragAndDropArea() {
        return getText(textDragAndDropArea);
    }

}
