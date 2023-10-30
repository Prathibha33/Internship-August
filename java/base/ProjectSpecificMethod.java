package base;

import java.io.IOException;

import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;

public class ProjectSpecificMethod {
	private final static ThreadLocal<RemoteWebDriver> rd = new ThreadLocal<RemoteWebDriver>();
	
	public void setDriver() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		rd.set(new ChromeDriver(option));
	}
	
	public RemoteWebDriver getDriver() {
		return rd.get();
	}
	public static RemoteWebDriver driver;
	public WebDriverWait wait;
	public Faker faker;
	public String fileName;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void preCondition(String browser){
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver =new FirefoxDriver();
		}
		System.out.println(driver);
		
		faker = new Faker(new Locale("en","IN"));
		
		//Launch the Chrome browser
		
		setDriver();
		
		//Maximise the window
		getDriver().manage().window().maximize();
		
		//Launch the url "https://login.salesforce.com/ "
		getDriver().get("https://login.salesforce.com/ ");
		
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(getDriver(),Duration.ofSeconds(15));
}
	@AfterMethod
	public void postCondition() {
		
	//close the browser	
	getDriver().close();

	
	
}
	@DataProvider(name="fetchData")
	public Object[][] sendata() throws IOException{
		return ReadExcel.readExcelData(fileName);

	
}
}
