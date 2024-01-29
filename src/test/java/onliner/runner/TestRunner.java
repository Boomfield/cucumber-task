package onliner.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/onliner/features",
        glue = "onliner.steps",
        plugin = {"html:target/CucumberReport.html"}
                )
public class TestRunner extends AbstractTestNGCucumberTests {
}
