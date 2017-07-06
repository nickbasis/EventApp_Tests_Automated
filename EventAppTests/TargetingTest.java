package EventAppTests;

import java.util.List;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Other.Settings;

public class TargetingTest extends Settings {

	@Test
	public void TargetingTest() throws InterruptedException {

		Thread.sleep(2000); // prosthetw ena wait 2 deyteroleptwn gia na
							// prolavei na ananewthei h selida. alliws
							// epistrefei False

		// GO to the 'Remote' Page
		driver.findElement(By.className("icons8-remote-control")).click();

		Thread.sleep(2000);

		// Check page title contains the search term if it does we are in the
		// right module

		String pageTitle = driver.getTitle(); // pare ton titlo ths selidas kai
												// apothikeyese ton sthn
												// metavlhth pageTitle

		System.out.println(pageTitle);

		boolean titleContainsTerm = pageTitle.contains("Remote"); // true or
																	// false oti
																	// to
																	// pageTitle
																	// einai
																	// ayto pou
																	// psaxnoume

		System.out.println(titleContainsTerm);

		Assert.assertTrue(titleContainsTerm);

		Thread.sleep(1000);

		// grab the Remote element, and look anywhere inside it to find a span
		// element that has the text of 'Target'

		driver.findElement(By.xpath("//*[@id='remote']/descendant::span[text()='Target']")).click();
		Thread.sleep(1000);

		// Vres to pedio kai grapse 'concise'
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[2]/div/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("tt-input")).sendKeys("concise");
		Thread.sleep(1000);
		driver.findElement(By.className("target-btn")).click();
		Thread.sleep(1000);

		for (int i = 1; i <= 3; i++) {
			driver.findElement(By.xpath("//*[@id='pages']/ul/li[" + i + "]/div")).click();
			Thread.sleep(2000);
		}

		// Click the Groups button and test some pages
		driver.findElement(By.xpath("//div[2]/div/button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("target-btn")).click();
		Thread.sleep(1000);
		for (int i = 1; i <= 3; i++) {
			driver.findElement(By.xpath("//*[@id='pages']/ul/li[" + i + "]/div")).click();
			Thread.sleep(2000);
		}

		// Click the Breakouts button and test some pages
		driver.findElement(By.xpath("//div[2]/div/button[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("target-btn")).click();
		Thread.sleep(1000);
		for (int i = 1; i <= 3; i++) {
			driver.findElement(By.xpath("//*[@id='pages']/ul/li[" + i + "]/div")).click();
			Thread.sleep(2000);
		}

		// Klikare stis 3 prwtes selides na doume an leitourgei
		// for(int i=1;i<=3;i++)
		// {
		// driver.findElement(By.xpath("//*[@id='pages']/ul/li["+i+"]/div")).click();
		// Thread.sleep(2000);

		// }

	}

}
