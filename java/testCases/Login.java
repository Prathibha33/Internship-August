package testCases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class Login extends ProjectSpecificMethod {
@Test
public void runLogin() {
	
    LoginPage ob=new LoginPage(driver);
		
		ob.enterUsername()
		.enterPassword()
		.clickLogin();
	}
}
