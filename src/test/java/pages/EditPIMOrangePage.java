package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Iterator;
import java.util.List;

public class EditPIMOrangePage extends BasePage {


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[6]/a")
    public WebElement jobButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div")
    public WebElement jobRolesDropdown;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/button")
    public WebElement saveJobSectionButton;

    @FindBy(xpath = "//(//div[@class='oxd-select-wrapper'])[1]//*[text() = 'Account Assistant']")
    public WebElement optionFromDropdown;

    @FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[1]//div")
    List<WebElement> listDropdwonJobTitle;


    @FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[3]//div")
    List<WebElement> listDropdwonSubUnit;


    //$x("//label[text() = 'Job Title']/parent::*/following-sibling::*//span") //TODO xpath de todo los elementos de lista
    //(//div[@class='oxd-select-wrapper'])[1]//*[text() = 'Account Assistant'] //TODO xpath de cada elemento de la lista, en este caso "Account Asssitant"



    public EditPIMOrangePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnJobSection() {
        clickElement(jobButton);
    }

    public void dropdownList() {
        clickElement(jobRolesDropdown);
    }

    public void selectJobTitle() {
        iterateOptions(listDropdwonJobTitle, "Account Assistant");
    }

    public void selectSubUnit() {
        iterateOptions(listDropdwonSubUnit, "Engineering");
    }

    public void iterateOptions(List<WebElement> element, String string) {
        Iterator<WebElement> iterator = element.iterator();
        while(iterator.hasNext()) {
            WebElement webElement = iterator.next();
            if(webElement.getText().equals(string)) {
                webElement.click();
                break;
            }
        }

    }


    public void selectSaveButton() {
        clickElement(saveJobSectionButton);
    }
}
