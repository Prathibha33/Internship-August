package testCases;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;


public class CreateAccount extends ProjectSpecificMethod{
	
	@BeforeMethod
	public void setFile() {
		fileName="CreateAccount";
	}
	@Test(dataProvider="fetchData")
	public void runCreate(String name) throws InterruptedException {
		
		LoginPage ob=new LoginPage(driver);
		
		ob.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickAccounts()
		.clickAccountsTab()
		.clickNew()
		.enterName()
		.clickOwnerShip()
		.choosePublic()
		.clickSave()
		.verifyToasterMsg();
		
	}

}
