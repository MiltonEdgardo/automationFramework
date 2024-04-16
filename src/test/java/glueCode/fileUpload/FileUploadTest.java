package glueCode.fileUpload;

import glueCode.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.FileUploadPage;
import pages.TheInternetHomePage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FileUploadTest extends BaseTest {

    private String file = "C:\\Users\\azrae\\Downloads\\Projects\\automationFrameworkInternet\\src\\test\\resources\\files\\SnakeArt.png";

    @Test
    public void uploadFileTest() {
        //Navigate to home page and then to File Upload link
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        FileUploadPage fileUploadPage = theInternetHomePage.clickOnFileUploadLink();

        //Upload file and click on submit button
        fileUploadPage.uploadFileByFileBar(file);

        //Validate the file's text uploaded
        Assert.assertEquals("Wrong file uploaded", "SnakeArt.png", fileUploadPage.getFileTextUploaded());
    }

    @Test
    public void dragAndDropUploadFileTest() {
        //Navigate to home page and then to File Upload link
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        FileUploadPage fileUploadPage = theInternetHomePage.clickOnFileUploadLink();

        //Upload file and click on submit button
        fileUploadPage.uploadFileByDragAndDrop(file);

        //Validate the file's text in the drag and drop area
        Assert.assertEquals("Wrong file uploaded", "SnakeArt.png", fileUploadPage.getTextFromDragAndDropArea());
    }
}
