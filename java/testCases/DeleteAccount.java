package testCases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class DeleteAccount extends ProjectSpecificMethod{
	
	@Test
	public void runDelete() throws InterruptedException {
LoginPage ob = new LoginPage(driver);
		
		ob.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickAccounts()
		.clickAccountsTab()
		.clickDropDown()
		.chooseDelete()
		.clickDelete()
		.verifyTM();
	}

}
