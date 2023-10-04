package week6.day1;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;





public class BaseClass {
	public  ChromeDriver driver;
	public WebDriverWait wait;
	@Parameters({"url","uname","pword"})
	@BeforeMethod
	public void preCondition(String url, String uname, String pword) {
		
		        //Launch the Chrome browser
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-notifications");
				driver = new ChromeDriver(option);
				
				
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				wait = new WebDriverWait(driver,Duration.ofSeconds(15));
				
				//Maximise the window
				driver.manage().window().maximize();
				
				//Launch the url
				driver.get(url);
				
				//enter the user name
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
				
				//enter the password
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pword);
				
				//click login
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Login']"))).click();
				
				//Click on the toggle menu button from the left corner
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']"))).click();
				
				//Click on content
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Content']"))).click();
				
				//Click on View all under today's task
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='View All'])[2]"))).click();
				
				//Choose display as table view
			     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-aura-class='forceListViewManagerDisplaySwitcher']"))).click();
			     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Table']"))).click();



				

}
	@AfterMethod
	public void postCondition() {
	driver.close();
}
}