package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/feature/CreateLegalEntity.feature"},glue = "stepDefinition", monochrome =true,publish = true)
public class CreateLegalEntityRunner extends AbstractTestNGCucumberTests{
	

}
