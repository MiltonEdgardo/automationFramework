package glueCode.PIMSectionTests;

import glueCode.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.EditPIMOrangePage;
import pages.LoggedHomeOrangePage;
import pages.LoginOrangePage;
import pages.PIMOrangePage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PIMSectionTest extends BaseTest {

    private String userName = "Ruby";
    private String jobTitle = "Account Assistant";

    @Test
    public void createAndAddDataUser() {
        //Buscar un usuario existente en la seccion PIM y editar el mismo agrendaole campos de "JobTitle" y validar dicha edicion.



        //Instance of the pages under test
        LoginOrangePage loginOrangePage = new LoginOrangePage(driver);
        LoggedHomeOrangePage loggedHomeOrangePage = new LoggedHomeOrangePage(driver);
        PIMOrangePage pimOrangePage = new PIMOrangePage(driver);
        EditPIMOrangePage editPIMOrangePage = new EditPIMOrangePage(driver);

        //navigate to the web site
        loginOrangePage.navigateToOrangePage();


        //login in the first page
        loginOrangePage.enterUserNameAndPassword(loginOrangePage.getUserName(), loginOrangePage.getPassword());
        loginOrangePage.clickInLoginButton();


        //going to the PIM section and validate
        loggedHomeOrangePage.clickOnPIMSection();
        Assert.assertEquals("PIM", loggedHomeOrangePage.returnPIMTitle());


        //search for a especific user and validate if exist
        pimOrangePage.writeEmployeeName(userName);
        pimOrangePage.clickOnSearchButton();

        //validate the number of element found
        //timeSleep();
        Assert.assertEquals("(1) Record Found", pimOrangePage.getNumberRecordsaFoundText());//expected:<[No] Records Found> but was:<[(40)] Records Found>


        //click on edith Button for user
        pimOrangePage.clickOnEditButton();

        //click on job section
        editPIMOrangePage.clickOnJobSection();

        //select one jobTitle and save
        editPIMOrangePage.dropdownList();
        editPIMOrangePage.selectJobTitle();
        editPIMOrangePage.selectSaveButton();

        //going to the PIM section and validate
        loggedHomeOrangePage.clickOnPIMSection();
        Assert.assertEquals("PIM", loggedHomeOrangePage.returnPIMTitle());

        //search for a especific user and validate if exist
        pimOrangePage.writeEmployeeName(userName);
        pimOrangePage.clickOnSearchButton();

        //validate the edith proceso
        Assert.assertEquals(jobTitle, pimOrangePage.getJobTitleResume());

    }

    private void timeSleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
