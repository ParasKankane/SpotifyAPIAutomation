package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="./src/test/java/Features/SpotifyAuthorization.feature", glue = {"StepDefinition"},tags = "@Sanity",
				 plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
		)
public class TestRunner {
	
}
