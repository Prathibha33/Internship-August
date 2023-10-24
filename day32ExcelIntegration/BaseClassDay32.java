package day32ExcelIntegration;

import java.io.IOException;
import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;

public class BaseClassDay32 {

	public  ChromeDriver driver;
	public WebDriverWait wait;
	public String fileName;
	public Faker faker;
	
	@Parameters({"url","uname","pword"})
	@BeforeMethod
	public void preCondition(String url, String uname, String pword){
		
		faker = new Faker(new Locale("en","IN"));
		
		//Launch the Chrome browser
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		
		//Maximise the window
		driver.manage().window().maximize();
		
		//Launch the url "https://login.salesforce.com/ "
		driver.get(url);
		
		//enter the user name as"prathi@testleaf.com" or "gokul.sekar@testleaf.com"
		driver.findElement(By.id("username")).sendKeys(uname);
		
		//enter the password as "Supradi3149" or "Java@223"
		driver.findElement(By.id("password")).sendKeys(pword);
		
		//click login
		driver.findElement(By.id("Login")).click();
		
		
	}
		
		
		
		
		@AfterMethod
		public void postCondition() {
			
		//close the browser	
		driver.close();
	
		
		
	}
		@DataProvider(name="fetchData")
		public Object[][] sendata() throws IOException{
			return ReadExcelData32.readExcelData(fileName);

		
	}
		

		
	}
