package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends BasePage {

    
    public ContextMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
