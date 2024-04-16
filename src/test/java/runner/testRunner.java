package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(JUnit4.class)
@CucumberOptions(
        //features = "src/test/java/features",
        glue = {"glueCode"}
        //snippets = CAMELCASE
)
public class testRunner {
}
