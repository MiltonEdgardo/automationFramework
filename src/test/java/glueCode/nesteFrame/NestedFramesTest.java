package glueCode.nesteFrame;

import glueCode.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.IFramePage;
import pages.NestedFramePage;
import pages.TheInternetHomePage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NestedFramesTest extends BaseTest {
    protected String leftText;
    protected String bottomText;

    private String textFromLeftFrame = "LEFT";
    private String textFromBottomFrame = "BOTTOM";

    @Test
    public void getTextFromTwoFrames() {
        //Navigate to home page and then to File Upload link
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        NestedFramePage nestedFramePage = theInternetHomePage.clickOnNestedFrameLink();

        //get Text from left and bottom frames
        Assert.assertEquals(textFromLeftFrame,nestedFramePage.getTextFromLeftFrame());
        nestedFramePage.getTextFromBottomFrame(bottomText);

        //Validate the texts
        Assert.assertEquals(textFromLeftFrame, leftText);
        Assert.assertEquals(textFromBottomFrame, bottomText);

    }
}
