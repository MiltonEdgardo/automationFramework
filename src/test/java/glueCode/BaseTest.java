package glueCode;

import browserManager.ChromeDriverManager;
import browserManager.DriverManager;
import browserManager.DriverManagerFactory;
import browserManager.DriverType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static browserManager.DriverType.CHROME;
import static browserManager.DriverType.FIREFOX;

public class BaseTest {
    protected DriverType driverType = FIREFOX;

    protected static WebDriver driver;
    private DriverManager driverManager;
    @BeforeAll
    public void setUp() {
        System.out.println("Beginning to execute tests");

        driverManager = DriverManagerFactory.getManager(driverType);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @BeforeEach
    public void initHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterAll
    public void tearDown() {
        System.out.println("Finished the execution tests");
        driver.quit();
    }
}
