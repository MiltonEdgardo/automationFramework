package glueCode;

import browserManager.DriverManager;
import browserManager.DriverManagerFactory;
import browserManager.DriverType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static browserManager.DriverType.CHROME;
import static browserManager.DriverType.FIREFOX;

public class Hooks {

    protected DriverType driverType = FIREFOX;

    protected static WebDriver driver;
    private DriverManager driverManager;


    public void setUp() {
        System.out.println("Beginning the test execution");
        driverManager = DriverManagerFactory.getManager(driverType);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public void tearDown() {
        System.out.println("Finished the execution tests");
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
