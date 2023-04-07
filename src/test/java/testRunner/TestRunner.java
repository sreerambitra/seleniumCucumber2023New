package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
 		(
 				features=".//Features//Customer.feature",
 				glue="stepDefinitions",
 				dryRun=false,
 				plugin= {"pretty", "html:target/reports/2023cucumber-reports3.html"}		
		)

public class TestRunner {

}
