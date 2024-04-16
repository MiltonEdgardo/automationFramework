package glueCode.dropdown;

import glueCode.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.DropdownPage;
import pages.TheInternetHomePage;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DropdownTest extends BaseTest {
    private int numberOfSelectedoption = 1;

    @ParameterizedTest
    @MethodSource("provideOptionsToSelect")
    public void dropdownListTest(String option) {
        //Go to home page and click on Dropdown link
        TheInternetHomePage theInternetHomePage = new TheInternetHomePage(driver);
        theInternetHomePage.navigateToTheInternetHomePage();
        DropdownPage dropdownPage = theInternetHomePage.clickOnDropdownLink();

        //Select the option form dropdown list
        dropdownPage.selectDropdwonoption(option);
        dropdownPage.getSelectOptions();

        //Validate the selection
        Assert.assertEquals(dropdownPage.getSelectOptions().size(), numberOfSelectedoption);
        Assert.assertTrue(dropdownPage.getSelectOptions().contains(option));
    }

    private static Stream<Arguments> provideOptionsToSelect() {
        return Stream.of(
                Arguments.of("Option 1"),
                Arguments.of("Option 2")
        );
    }
}
