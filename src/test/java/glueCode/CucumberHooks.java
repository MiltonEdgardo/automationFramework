package glueCode;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberHooks {

    private TestContext testContext;

    public CucumberHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp() {
        testContext.hooks.setUp();
    }

    @After
    public void tearDown() {
        testContext.hooks.tearDown();
    }
}
