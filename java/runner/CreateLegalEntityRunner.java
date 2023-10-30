package runner;

import base.BaseClass;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/feature/CreateLegalEntity.feature"},glue = "stepDefinition", monochrome =true,publish = true)
public class CreateLegalEntityRunner extends BaseClass{
	

}
