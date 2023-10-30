package base;

import java.io.File;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass1 {

	// declare a excelFileName
	public String excelFileName;
	// declare a ExtentReports
	public static ExtentReports extent;
	
	//public static ExtentTest child;
	
	// declare a ExtentTest
//	public  ExtentTest test, node;
	// declare test details
//	public String testName;
	
	public static ExtentHtmlReporter reporter;
	public String testDescription, testCaseName;
	public String testCategory;
	public String testAuthor;
	
	private static  ThreadLocal <ExtentTest> parentTest =  new ThreadLocal<ExtentTest>() ;
	
	private static  ThreadLocal <ExtentTest> test = new ThreadLocal<ExtentTest>();
	
	private static  ThreadLocal<String> testName = new ThreadLocal<String>();
	
	
	// create a object for ThreadLocal of type RemoteWebDriver
	private static final ThreadLocal<RemoteWebDriver> rd = new ThreadLocal<RemoteWebDriver>();
	


	public void setMethod() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		rd.set(new ChromeDriver(opt));
		
	}

	public RemoteWebDriver getMethod() {
		return rd.get();
	}

	public   void setTest() {
//		ExtentTest childTest = parentTest.get().createNode(getTestName());
		ExtentTest childTest = parentTest.get().createNode("Login Script ");
		test.set(childTest);
	}
	
	
	public String getTestName() {
		return testName.get();
	}
	
	@BeforeSuite
	public  void startReport() {
		// set the path
        reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
//		setMethod();
	}
	@BeforeClass
	public  void testcaseDetails() {
		ExtentTest parent = extent.createTest(testCaseName, testDescription);
		parent.assignCategory(testCategory);
		parent.assignAuthor(testAuthor);
		parentTest.set(parent);
		testName.set(testCaseName);
		System.out.println("beforeclass");
		System.out.println("testcaseName : "+testCaseName);
	}

	public  int takeSnap() throws IOException, WebDriverException {
		int ranNum = (int) (Math.random() * 9999);
		File source = getMethod().getScreenshotAs(OutputType.FILE);
		File des = new File("./Snaps/img" + ranNum + ".png");
		FileUtils.copyFile(source, des);
		
		return ranNum;

	}

	@BeforeMethod
	public void preCondition() {
		setTest();
//		WebDriverManager.chromedriver().setup();
		setMethod();
		SessionId sessionId = getMethod().getSessionId();
		System.out.println("session id : "+sessionId);
//		getMethod().get("http://leaftaps.com/opentaps/");
		getMethod().get("https://login.salesforce.com/ ");
		getMethod().manage().window().maximize();
		getMethod().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@AfterMethod
	public void postCondition() {
		 getMethod().close();
	}
	
	
	
	
	public  void reportStep(String msg,String status) throws IOException {
		
			
		
		if (status.equalsIgnoreCase("pass")) {
			System.out.println("TestCasePass"+test.get());
			test.get().pass(msg, MediaEntityBuilder.createScreenCaptureFromPath(".././Snaps/img"+takeSnap()+".png").build());	
			
		}
		else if(status.equalsIgnoreCase("fail")) {
			test.get().fail(msg, MediaEntityBuilder.createScreenCaptureFromPath("../Snaps./img"+takeSnap()+".png").build());
			System.out.println("TestCaseFail");
			
		}
		

	}
	
	
	
	@DataProvider(name = "fetch", parallel = true)
	public Object[][] fetchData() throws IOException {
		return ReadExcel.readExcelData(excelFileName);
	}
	
	
	@AfterSuite
	public  void stopReport() {
		extent.flush();

	}
	
}
