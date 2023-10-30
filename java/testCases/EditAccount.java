package testCases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class EditAccount extends ProjectSpecificMethod{
	
	@Test
	public void runEdit() throws InterruptedException {
		LoginPage ob = new LoginPage(driver);
		
		ob.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickToggleMenu()
		.clickViewAll()
		.clickAccounts()
		.clickAccountsTab()
		.clickDropDown()
		.chooseEdit()
		.chooseType()
		.chooseIndustry()
		.enterStreet()
		.enterCity()
		.enterState()
		.enterPostalCode()
		.enterCountry()
		.enterStreet1()
		.enterCity1()
		.enterState1()
		.enterPostalCode1()
		.entryCountry1()
		.chooseCustomerPriority()
		.chooseActive()
		.chooseRating()
		.enterPhNo()
		.chooseOwnerShip()
		.clickSave()
		.verifyPhNo();
	}

}
