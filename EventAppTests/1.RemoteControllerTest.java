package EventAppTests;




//import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Other.Settings;

public class RemoteControllerTest extends Settings {
	

	private static int linksCount = 0;
	private static int linksCountdialog = 0;
	private static int linksCountdialogTF = 0;
	private static int linksCountdialogVote = 0;
	
	@Test
	public void remoteControllerTest() throws InterruptedException {
	
		
				
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
		
		
		//If Pages tab exists, go there
		
		Boolean ispagespresent = driver.findElement(By.linkText("Pages")).isDisplayed();
		if (ispagespresent == true)
		{
			driver.findElement(By.linkText("Pages")).click();
		}
		else
		{
			System.out.println("Pages link does not exist");
		}
		
		//Click on all the links one by one
		
		
		//Find all elements on 'Pages' tab. Print them and click one by one
		
		List <WebElement> allElements = driver.findElements(By.xpath("//*[@class='btn-command module btn btn-default']"));
		linksCount = allElements.size(); //Vale se mia metavlhth  to megethos ths listas
		System.out.println("----------------------");
		System.out.println("Total no of 'Pages' Available: "+linksCount); //Print the number of elements in the list
		System.out.println("----------------------");
		
//		links= new String[linksCount];
//		System.out.println("List of links Available: ");
		
		// print all the elements in the list
		for(WebElement elements : allElements) {			  
			  System.out.println(elements.getText());
		}
		
		// Click se kathe stoixerio ths listas
		for(int i=1;i<=linksCount;i++)
		{
		driver.findElement(By.xpath("//*[@id='pages']/ul/li["+i+"]/div")).click();
	    Thread.sleep(2000);

		}
		
		
		//If 'Dialogs' tab exists, go there
		
		Boolean isdialogspresent = driver.findElement(By.linkText("Dialogs")).isDisplayed();
		if (isdialogspresent == true)
			{
			driver.findElement(By.linkText("Dialogs")).click();
			}
		else
			{
			System.out.println("Dialogs tab does not exist");
			}
		
		//Find all elements on 'Dialogs' tab. Print them and click one by one
		
		List <WebElement> allDialogElements = driver.findElements(By.xpath("//*[@id='dialogs']/ul/li/div"));
		linksCountdialog = allDialogElements.size(); //Vale se mia metavlhth  to megethos ths listas
		
		List <WebElement> allDialogElementsTF = driver.findElements(By.xpath("//*[@id='dialogs']/ul[1]/li/div"));
		linksCountdialogTF = allDialogElementsTF.size(); //Vale se mia metavlhth  to megethos ths listas tou Text & Forms
		
		List <WebElement> allDialogElementsVote = driver.findElements(By.xpath("//*[@id='dialogs']/ul[2]/li/div"));
		linksCountdialogVote = allDialogElementsVote.size(); //Vale se mia metavlhth  to megethos ths listas tou Voting
		
			System.out.println("----------------------");
			System.out.println("Total no of 'Dialogs' Available: "+linksCountdialog); //Print the number of elements in the list
			System.out.println("----------------------");
			System.out.println("Text & Forms Dialogs Available: "+linksCountdialogTF); //Print the number of elements in the list
			System.out.println("----------------------");
			System.out.println("Voting sets 'Dialogs' Available: "+linksCountdialogVote); //Print the number of elements in the list
			System.out.println("----------------------");
				
		
		for(WebElement elements : allDialogElements) {			  
			  System.out.println(elements.getText());
		}
		
		// Click on every element of the 'Dialogs' tab
			
				for(int i=1, j=1; i<=linksCountdialogTF; i++)
				{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='dialogs']/ul["+j+"]/li["+i+"]/div/div/div[1]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='dialogs']/ul["+j+"]/li["+i+"]/div/div/div[2]")).click();
				}
			
				
				for(int i=1, j=2; i<=linksCountdialogVote; i++)
				{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='dialogs']/ul["+j+"]/li["+i+"]/div/div/div[1]")).click();
				}
				
				driver.findElement(By.linkText("Devices")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.xpath(".//*[@id='commands']/div[3]/div[3]/div[1]")).click(); //Click sto Restart
				Thread.sleep(3000);
				
				Alert alert = driver.switchTo().alert(); //Kane accept to modal dialog
				alert.accept();
				Thread.sleep(2000);
		

	         }
		}
		
		
		
		
		
	



	



