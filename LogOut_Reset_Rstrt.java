package EventAppTests;

//import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Other.Settings;

public class LogOut_Reset_Rstrt extends Settings {

	@Test
	public void LogOut_Reset_Rstrt() throws InterruptedException {

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

		// Find and Click the 'Devices' link

		driver.findElement(By.linkText("Devices")).click();

		Thread.sleep(1000);

		// Send ALL Notifications

		for (int i = 1; i <= 3; i++) {

			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='commands']/div[3]/div[1]/div[1]")).click(); // Click
																								// sto
																								// Log
																								// Out
			Thread.sleep(1000);

			driver.findElement(By.linkText("Advanced")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(".//*[@id='page-advanced']/ul/div[1]/li[1]/div")).click(); // Click
																									// sto
																									// Log
																									// In
			Thread.sleep(2000);

			driver.findElement(By.linkText("Devices")).click();
			Thread.sleep(3000);

		}

		driver.findElement(By.xpath(".//*[@id='commands']/div[3]/div[3]/div[1]")).click(); // Click
																							// sto
																							// Restart
		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert(); // Kane accept to modal dialog
		alert.accept();
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='commands']/div[3]/div[2]/div[1]")).click(); // Click
																							// sto
																							// Reset
		Thread.sleep(3000);

		Alert alert2 = driver.switchTo().alert(); // Kane accept to modal dialog
		alert2.accept();
		Thread.sleep(3000);

	}

}
