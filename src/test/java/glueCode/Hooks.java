package glueCode;

import browsermanager.DriverManager;
import browsermanager.DriverManagerFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static browsermanager.DriverType.CHROME;

public class Hooks {

    protected static WebDriver driver;
    private DriverManager driverManager;

    @Before
    public void setUp() {
        System.out.println("Comenzando a ejecutar tests");
        driverManager = DriverManagerFactory.getManager(CHROME);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        System.out.println("Termoinada la ejecucion de los tests");
        driverManager.quitDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
