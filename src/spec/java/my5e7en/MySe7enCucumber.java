package my5e7en;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@CucumberOptions(
		format = {
				"json:build/cucumber/report.json",
				"html:build/cucumber/report",
				"pretty"
		},
		tags = {"~@ignored"}
)
@RunWith(Cucumber.class)
public class MySe7enCucumber {

}

