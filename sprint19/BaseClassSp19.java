package sprint19;

import java.time.Duration;

import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.github.javafaker.Faker;



public class BaseClassSp19 {
	
	public  ChromeDriver driver;
	public WebDriverWait wait;
	public Faker faker;
	
	//@Parameters({"url","uname","pword"})
	@BeforeMethod
	public void preCondition(){
		
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
		driver.get("https://login.salesforce.com/ ");
		
		//enter the user name as"prathi@testleaf.com"
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		
		//enter the password as "Supradi3149"
		driver.findElement(By.id("password")).sendKeys("Java@223");
		
		//click login
		driver.findElement(By.id("Login")).click();
		
		
	}
		
		
		
		
		@AfterMethod
		public void postCondition() {
			
		//close the browser	
		driver.close();
	
		
		
	}
		

		
	}
     

