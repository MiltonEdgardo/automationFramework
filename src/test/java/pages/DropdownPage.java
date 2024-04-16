package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage extends BasePage {

    @FindBy(id = "dropdown")
    private WebElement dropdwonList;

    public DropdownPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectDropdwonoption(String option) {
        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectOptions() {
        return findDropdownElement()
                .getAllSelectedOptions().stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public Select findDropdownElement() {
        return new Select(dropdwonList);
    }
}
