package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
        glue = "stepDef",
        tags = "@Test1 or @Test2",
        plugin = {"pretty", "html:target/Report.html"}
)

public class RunTest {

}
