package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

public class HoversPage extends BasePage {

    @FindBy(className = "figure")
    private WebElement figuresOptions;

    private By figureOption = By.className("figure");
    private By boxCaption = By.className("figcaption");
    public HoversPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public FigureCaption hoverOverFigure(int index) {
        WebElement figure = driver.findElements(figureOption).get(index);
        Actions hover = new Actions(driver);
        hover.moveToElement(figure).perform();

        return new FigureCaption(figure.findElement(boxCaption));
    }

    public class FigureCaption {

        private WebElement caption;
        @FindBy(tagName = "h5")
        private WebElement headerCaption;
        @FindBy(tagName = "a")
        private WebElement linkCaption;
        private String atribute = "href";

        public FigureCaption(WebElement element) {
            this.caption = element;
        }

        public boolean isCaptionDisplayed() {
            return caption.isDisplayed();
        }

        public String getTextFromCaption() {
            return getText(headerCaption);
        }

        public String getLinkText() {
            return getText(linkCaption);
        }
        public String getLinkUrl() {
            return getUrlLink(linkCaption, atribute);
        }
    }


}
