package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMOrangePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
    public WebElement employeeName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
    public WebElement employeeId;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[2]")
    public WebElement editUserButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[5]/div")
    public WebElement jobTitleResume;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
    public WebElement noRecordFoundIndication;

    public PIMOrangePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void writeEmployeeName(String name) {
        writeText(employeeName, name);
    }

    public void clickOnSearchButton() {
        clickElement(searchButton);
    }

    public String getNumberRecordsaFoundText() {
        return getText(noRecordFoundIndication);
    }

    public void writeEmployeeId(String id) {
        writeText(employeeId, id);
    }
    public void clickOnEditButton() {
        clickElement(editUserButton);
    }

    public String getJobTitleResume() {
        return getText(jobTitleResume);
    }
}
