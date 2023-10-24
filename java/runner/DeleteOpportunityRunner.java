package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/feature/DeleteOpportunity.feature"},glue = "stepDefinition", monochrome =true,publish = true)
public class DeleteOpportunityRunner extends AbstractTestNGCucumberTests{

}
