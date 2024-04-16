package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TheInternetHomePage extends BasePage{
    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    private WebElement titlePage;
    @FindBy(linkText = "Form Authentication")
    private WebElement formAuthenticationLink;
    @FindBy(linkText = "Dropdown")
    private WebElement dropdownLink;
    @FindBy(linkText = "Hovers")
    private WebElement hoversLink;
    @FindBy(linkText = "Key Presses")
    private WebElement keyPressesLink;
    @FindBy(linkText = "JavaScript Alerts")
    private WebElement javaScriptAlertsLink;
    @FindBy(linkText = "File Upload")
    private WebElement fileUploadLink;

    @FindBy(linkText = "Context Menu")
    private WebElement contextMenuLink;

    @FindBy(linkText = "WYSIWYG Editor")
    private WebElement iFrameLink;
    @FindBy(linkText = "Dynamic Loading")
    private WebElement dynamicLoadingLink;

    @FindBy(linkText = "Nested Frames")
    private WebElement nestedFramesLink;



    public TheInternetHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void getTitleAndValidate(String expectedResponse) {
        Assert.assertEquals(getText(titlePage), expectedResponse);
    }
    public void navigateToTheInternetHomePage() {
        navigateTo("https://the-internet.herokuapp.com/");
    }

    public FormAuthenticationPage clickOnAuthenticationFormLink() {
        clickElement(formAuthenticationLink);
        return new FormAuthenticationPage(driver);
    }

    public DropdownPage clickOnDropdownLink() {
        clickElement(dropdownLink);
        return new DropdownPage(driver);
    }

    public HoversPage clickOnHoversLink() {
        clickElement(hoversLink);
        return new HoversPage(driver);
    }

    public KeyPressesPage clickOnKeyPressesLink() {
        clickElement(keyPressesLink);
        return new KeyPressesPage(driver);
    }

    public JSAlerts clickOnJavaScriptAlertsLink() {
        clickElement(javaScriptAlertsLink);
        return new JSAlerts(driver);
    }

    public FileUploadPage clickOnFileUploadLink() {
        clickElement(fileUploadLink);
        return new FileUploadPage(driver);
    }

    public ContextMenuPage clickOnContextMenuLink() {
        clickElement(contextMenuLink);
        return new ContextMenuPage(driver);
    }

    public IFramePage clickOnIFrameLink() {
        clickElement(iFrameLink);
        return new IFramePage(driver);
    }

    public NestedFramePage clickOnNestedFrameLink() {

        clickElement(nestedFramesLink);
        return new NestedFramePage(driver);
    }

    public DynamicLoadingPage clickOnDynamicLoadingLink() {
        clickElement(dynamicLoadingLink);
        return new DynamicLoadingPage(driver);
    }




}
