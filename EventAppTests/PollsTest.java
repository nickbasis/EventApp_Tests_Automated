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

public class PollsTest extends Settings {

	private static int linksCount = 0;
	private static int linksCountdialog = 0;
	private static int linksCountdialogTF = 0;
	private static int linksCountdialogVote = 0;

	@Test
	public void pollsTest() throws InterruptedException {

		Thread.sleep(2000); // prosthetw ena wait 2 deyteroleptwn gia na
							// prolavei na ananewthei h selida. alliws
							// epistrefei False

		// GO to the 'Remote' Page
		driver.findElement(By.className("icons8-poll-topic")).click();

		Thread.sleep(2000);

		// Check page title contains the search term if it does we are in the
		// right module

		String pageTitle = driver.getTitle(); // pare ton titlo ths selidas kai
												// apothikeyese ton sthn
												// metavlhth pageTitle

		System.out.println(pageTitle);

		boolean titleContainsTerm = pageTitle.contains("Operator"); // true or
																	// false oti
																	// to
																	// pageTitle
																	// einai
																	// ayto pou
																	// psaxnoume

		System.out.println(titleContainsTerm);

		Assert.assertTrue(titleContainsTerm);

		// Find all elements on 'Pages' tab. Print them and click one by one

		List<WebElement> allElements = driver.findElements(By.xpath("html/body/div/div[2]/div/div[1]"));
		linksCount = allElements.size(); // Vale se mia metavlhth to megethos
											// ths listas
		System.out.println("----------------------");
		System.out.println("Total no of 'Voting Sets' Available: " + linksCount); // Print
																					// the
																					// number
																					// of
																					// elements
																					// in
																					// the
																					// list
		System.out.println("----------------------");

		// links= new String[linksCount];
		// System.out.println("List of links Available: ");

		// print all the elements in the list
		for (WebElement elements : allElements) {
			System.out.println(elements.getText());
		}
		
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div[1]/span")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@ng-click='deleteAnswers(set.id)']")).click(); //Vres to sygkekrimeno attribute kai click
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert(); // Kane accept to modal dialog
		alert.accept();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//i[@class='fa fa-toggle-on']")).click();
		
		Thread.sleep(5000);
		
		//Go to the WebApp and Log In
		
		driver.get("https://staging.cmdapp.com/app");
		
		//Thread.sleep(1000);
		
		//driver.findElement(By.xpath(".//*[@id='dialog1589761478']/div/div/div[2]/div/div[1]/a/img")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@class='digit digit-0 btn btn-default btn-lg btn-block']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@class='digit digit-0 btn btn-default btn-lg btn-block']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@class='digit digit-0 btn btn-default btn-lg btn-block']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@class='digit digit-2 btn btn-default btn-lg btn-block']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@class='ok ok-pin ok-big btn btn-lg btn-block btn-primary']")).click();
		
		Thread.sleep(3000);
		
		
		//Go to the Polling
		
		driver.findElement(By.className("icons8-poll-topic")).click();
		
		Thread.sleep(10000);
		
	

	}

}
