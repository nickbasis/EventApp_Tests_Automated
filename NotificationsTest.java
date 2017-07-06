package EventAppTests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Other.Settings;

public class NotificationsTest extends Settings {
	
	@Test
	public void NotificationsTest() throws InterruptedException {
		
						
				Thread.sleep(2000); // prosthetw ena wait 2 deyteroleptwn gia na prolavei na ananewthei h selida. alliws epistrefei False
				
				//GO to the 'Remote' Page
				driver.findElement(By.className("icons8-remote-control")).click();
				
				Thread.sleep(2000);
				
				//Check page title contains the search term if it does we are in the right module
				
				String pageTitle = driver.getTitle(); //pare ton titlo ths selidas kai apothikeyese ton sthn metavlhth pageTitle
						
					System.out.println(pageTitle);
						
				boolean titleContainsTerm = pageTitle.contains("Remote"); //true or false oti to pageTitle einai ayto pou psaxnoume
						
					System.out.println(titleContainsTerm);
						
					Assert.assertTrue(titleContainsTerm);
					
				//Find and Click the 'Notify' link
					
					Thread.sleep(2000);
					
					driver.findElement(By.linkText("Notify")).click();
					
					Thread.sleep(3000);
					
				//Send ALL Notifications
					
					for(int i=1;i<=3;i++) {
						
						Thread.sleep(1000);
						driver.findElement(By.xpath(".//*[@id='page-notify']/div[2]/div[1]/div/button["+i+"]")).click(); //Click sto kathe button me thn seira
						Thread.sleep(1000);
						
						//driver.findElement(By.id("notification-message")).clear(); //Vres to pedio gia username kai katharise to
						driver.findElement(By.id("notification-message")).sendKeys("Test all notifications: LOW, MEDIUM and HIGH"); //Grapse sto pedio
						Thread.sleep(1000);
						
						driver.findElement(By.xpath(".//*[@id='page-notify']/div[2]/div[2]/button")).click();
						Thread.sleep(1000);
						
						Alert alert = driver.switchTo().alert(); //Kane accept to modal dialog
						alert.accept();
						Thread.sleep(1000);
						
						
						
						
					}
					
		
		
		
		
	}

}
