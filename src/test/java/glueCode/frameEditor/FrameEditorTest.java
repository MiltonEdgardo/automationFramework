package glueCode.frameEditor;

import glueCode.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.FileUploadPage;
import pages.IFramePage;
import pages.TheInternetHomePage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FrameEditorTest extends BaseTest {

    private String firstText = "Hello ";
    private String secondText = "World!!";

    @Test
    public void getTextFromFrameEditorTest() {
        //Navigate to home page and then to File Upload link
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        IFramePage iFramePage = theInternetHomePage.clickOnIFrameLink();

        //Clear the text area from frame editor
        iFramePage.clearTheTextAreaFromFrameEditor();

        //Go to the iframe and set the text
        iFramePage.setTextInIFrameEditor(firstText);
        iFramePage.setIdentation();
        iFramePage.setTextInIFrameEditor(secondText);

        //Validate the set Text
        Assert.assertEquals(firstText + secondText, iFramePage.getTextFroTextEditorFrame());
    }
}
