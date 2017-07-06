package EventAppTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Useful_Techniques {
	
	
	
	
//	Customized xpath Using Attributes .//tagName[@attribute=‘value’] 
	
//  traverse to sibling element using xpath example: .//*[@id='tablist1-tab1']/following-sibling::li[2]
	
//  traverse back to Parent element from Child element using Xpath: .//*[@id='tablist1-tab1']/parent::ul
	
//  Target based on text. Careful for spaces/gap    //*[text()='Words']
	
//  Targeting CSS tagname[attribute='value'] parageidma: div[class='identify first'] me xpath tha htan //*[@class='identify first']
	
	// //*[@id='pages']/ul/li/div" Gia to RemoteController Test

}

// HANDLING STATIC DROPDOWNS //

//example with Chrome

/* System.setProperty("webdriver.chrome.driver", "C:\\Selenium3.4\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("http://spicejet.com");

Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_Adult']")));
dropdown.selectByIndex(4);
dropdown.selectByVisibleText("9 Adults");
dropdown.selectByValue("8");*/


// HANDLING DYNAMIC DROPDOWNS //

/* driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
driver.findElement(By.xpath("//a[@value='GOI']")).click();
driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click(); -- Ignore the value on the 1st dynamic drop down and click this 2nd in order */


// HANDLING CHECKBOXES

/*System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).isSelected());
driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).isSelected());
//true  false */



// HANDLING RADIO BUTTONS

/*
 		driver.get("http://www.echoecho.com/htmlforms10.htm");
		driver.findElement(By.xpath("//input[@value='Butter']")).click();
		System.out.println("Radio buttons in Group1: " + driver.findElements(By.xpath("//input[@name='group1']")).size()); --How many Radio buttons in this group
		
 */

//HANDLING RADIO BUTTONS DYNAMICALLY

/*
   --Click all the radio buttons in Group 1--
   
	for (int i=0;i<count;i++) 
	{
		driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();	
	}
	
	--Print the values aff the items--
	
	for (int i=0;i<count;i++) 
			
		{
			//driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
			System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value"));
		}
	
	--Click radio button only if...--
	
	for (int i=0;i<count;i++) 
			
		{
			//driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
			String text = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");
			if (text.equals("Cheese"))
			{
				driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
			}
		}
	
HANDLING ALERTS

		--Clicking OK--

		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
		driver.findElement(By.xpath("//input[@value='Confirmation Alert']")).click();
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	
	
*/

