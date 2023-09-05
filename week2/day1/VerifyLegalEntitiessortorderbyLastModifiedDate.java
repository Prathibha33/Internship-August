package week2.day1;
//Login to  
//
//Click on the toggle menu button from the left corner
//
//Click View All and click Legal Entities from App Launcher
//
//Click on the legal Entities tab 
//
//Click the sort arrow in the Last Modified Date.
//
//Verify the Legal Entities displayed in ascending order by Last Modified Date.

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifyLegalEntitiessortorderbyLastModifiedDate {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/ ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("prathi@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Supradi3149");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		WebElement viewall = driver.findElement(By.xpath("//button[text()='View All']"));
		driver.executeScript("arguments[0].click();", viewall);
		WebElement le = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", le);
		WebElement le1 = driver.findElement(By.xpath("//span[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", le1);
		WebElement lmd = driver.findElement(By.xpath("//span[text()='Last Modified Date']"));
		driver.executeScript("arguments[0].click();", lmd);
		String text = driver.findElement(By.xpath("//span[@data-aura-class='uiOutputDateTime']")).getText();
		System.out.println(text);
		//String[] split=text.split(",");
		//System.out.println(split);
		String text1 = driver.findElement(By.xpath("(//span[@data-aura-class='uiOutputDateTime'])[2]")).getText();
		System.out.println(text1);
		if(text.equals(text1)) {
			System.out.println("Legal entity is not sorted");
		}else {
			System.out.println("Legal entity is sorted");
		}
		//String[] split1=text1.split(",");
		//System.out.println(split1);
//		if(split[0].equals(split1[0])){
//			if(split[1].equals(split1[1])) {
//				System.out.println("Legal entity is not sorted");
//				
//			}else {
//				String time = split[1].replaceAll("[^0-9]","");
//				String time1= split1[1].replaceAll("[^0-9]","");
//				int t = Integer.parseInt(time);
//				System.out.println(t);
//				int t1 = Integer.parseInt(time1);
//				System.out.println(t1);
//				if(t>t1) {
//					System.out.println("legal entity is sorted");
//				}else {
//					System.out.println("Legal entity is not sorted");
//				}
//			
//			}
//		
//			
		}
	}


