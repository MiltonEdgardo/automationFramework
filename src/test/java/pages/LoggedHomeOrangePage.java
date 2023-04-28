package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedHomeOrangePage extends BasePage {
    @FindBy(xpath = "//*[@class=\"oxd-userdropdown-name\"]")
    private WebElement userLoggedButton;
    @FindBy(xpath = "//*[@class=\"oxd-input oxd-input--active oxd-input--error\"]")
    private WebElement calendarPicker;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/svg")
    private WebElement leaveButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav")
    private WebElement sidePanelFrame;
    @FindBy(xpath = "//*[@class=\"oxd-main-menu\"]")
    private WebElement sectionsSidePanelFrame;


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
    private WebElement pimSectionButton;

    @FindBy(xpath = "//*[@class=\"oxd-topbar-header-breadcrumb\"]")
    private WebElement pimTitleSection;


    public LoggedHomeOrangePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean checkIfDisplayedLoggedUserButton() {
        return isDislpayed(userLoggedButton);
    }
    public String getUserLoggedName() {
        return getText(userLoggedButton);
    }
    public void clickOnLeaveButton() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(sidePanelFrame);
        clickElement(leaveButton);
    }
    public boolean checkIfDisplayedDatePicker() {
        return isDislpayed(calendarPicker);
    }

    public void clickOnPIMSection() {
        clickElement(pimSectionButton);
    }

    public String returnPIMTitle() {
        return getText(pimTitleSection);
    }


}
