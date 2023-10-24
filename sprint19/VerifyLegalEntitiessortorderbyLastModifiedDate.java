package sprint19;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VerifyLegalEntitiessortorderbyLastModifiedDate extends BaseClassSp19{

	@Test(dependsOnMethods = "sprint19.CreateLegalEntity.runCreateLegalEntity")
	public void runVerifyLegalEntitiessortorderbyLastModifiedDate() {
		
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


