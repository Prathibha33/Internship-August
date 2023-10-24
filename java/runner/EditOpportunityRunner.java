package runner;

import base.BaseClass;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/feature/EditOpportunity.feature"},glue = "stepDefinition", monochrome =true,publish = true)
public class EditOpportunityRunner extends BaseClass{

}
