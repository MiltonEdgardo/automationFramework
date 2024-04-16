package glueCode.hover;

import glueCode.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.HoversPage;
import pages.TheInternetHomePage;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HoversTest extends BaseTest {
    @ParameterizedTest
    @MethodSource("provideIndexAndExpectedCaptionFeature")
    public void hoverOnImagesTest(int indexImage, String expectedCaption,String expectedLinkCaption, String pathUrl) {
        //Navigate to home page and then on hovers link
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        theInternetHomePage.navigateToTheInternetHomePage();
        HoversPage hoversPage = theInternetHomePage.clickOnHoversLink();

        //Hover on the images in te page
        HoversPage.FigureCaption figureCaption = hoversPage.hoverOverFigure(indexImage);

        //Validate the caption is displayed
        Assert.assertTrue("Caption is not displayed", figureCaption.isCaptionDisplayed());

        //Validate the element's index with the image
        Assert.assertEquals("Caption title incorrect", expectedCaption, figureCaption.getTextFromCaption());

        //Validate the text link
        Assert.assertEquals("Caption link text is incorrect", expectedLinkCaption, figureCaption.getLinkText());

        //Validate the path for the url link
        Assert.assertTrue("Link incorrect", figureCaption.getLinkUrl().endsWith(pathUrl));
    }

    private static Stream<Arguments> provideIndexAndExpectedCaptionFeature() {
        return Stream.of(
                Arguments.of(0, "name: user1", "View profile", "/users/1"),
                Arguments.of(1, "name: user2", "View profile", "/users/2"),
                Arguments.of(2, "name: user3", "View profile", "/users/3")
        );
    }
}
