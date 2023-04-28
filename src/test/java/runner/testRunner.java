package runner;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@CucumberOptions(
        glue = ("gluecode")
)
public class testRunner {
}
