package EventAppTests;

//import java.util.ArrayList;
import java.util.List;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Other.Settings;
public class PresentationsTest extends Settings {

	private static int linksCount = 0;

	@Test
	public void PresentationsTest() throws InterruptedException {

		Thread.sleep(2000); // prosthetw ena wait 2 deyteroleptwn gia na
							// prolavei na ananewthei h selida. alliws
							// epistrefei False

		// GO to the 'Remote' Page
		driver.findElement(By.className("icons8-statistics")).click();

		Thread.sleep(2000);

		// Check page title contains the search term if it does we are in the
		// right module

		String pageTitle = driver.getTitle(); // pare ton titlo ths selidas kai
												// apothikeyese ton sthn
												// metavlhth pageTitle

		System.out.println(pageTitle);

		boolean titleContainsTerm = pageTitle.contains("Presentation"); // true
																		// or
																		// false
																		// oti
																		// to
																		// pageTitle
																		// einai
																		// ayto
																		// pou
																		// psaxnoume

		System.out.println(titleContainsTerm);

		Assert.assertTrue(titleContainsTerm);

		Thread.sleep(2000);

		// Click on all the links one by one

		// Find all elements on 'Presentations' page. Print them and click one
		// by one

		List<WebElement> allElements = driver.findElements(By.tagName("h2"));
		linksCount = allElements.size(); // Vale se mia metavlhth to megethos
											// ths listas
		System.out.println("----------------------");
		System.out.println("Total no of 'Sets' Available: " + linksCount); // Print
																			// the
																			// number
																			// of
																			// elements
																			// in
																			// the
																			// list
		System.out.println("----------------------");

		// print all the elements in the list
		for (WebElement elements : allElements) {
			System.out.println(elements.getText());
		}

		// Click on the 1st default Presentation set

		driver.findElement(By.xpath("//*[@id='set-26']/div[1]/h2/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='pres-26-14']/a/span")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id='pres-26-14']/a/div/span")).click();
		Thread.sleep(2000);

		// Ksekina to auto slide
		driver.findElement(By.xpath("html/body/div/section/div/div[5]/div[3]/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div/section/div/div[5]/div[2]/div[1]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("html/body/div/section/div/nav/div/div/div/div/button[2]")).click();
		Thread.sleep(2000);

		// Vres to input fiels sto pop up katharise to kai grapse to slide
		// noumero 2
		driver.findElement(By.xpath("//*[@id='dialog-314489250']/div/div/div[2]/div[2]/div/input")).clear();
		driver.findElement(By.xpath("//*[@id='dialog-314489250']/div/div/div[2]/div[2]/div/input")).sendKeys("3"); // Grapse
																													// sto
																													// pedio
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='dialog-314489250']/div/div/div[2]/div[3]/div[2]/button")).click();
		Thread.sleep(2000);

		// Click sto Restart button kai 'YES' sto pop up
		driver.findElement(By.xpath("html/body/div/section/div/nav/div/div/div/div/button[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='dialog-2005443522']/div/div/div[2]/div[2]/div[2]/button")).click();
		Thread.sleep(10000);

		// Click se kathe stoixerio ths listas
		// for(int i=1;i<=linksCount;i++)
		// {
		// driver.findElement(By.tagName("h2")).click();
		// Thread.sleep(2000);

	}
}
