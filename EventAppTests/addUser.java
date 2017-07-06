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

public class addUser extends Settings {

	private static int linksCount = 0;
	private static int linksCountdialog = 0;
	private static int linksCountdialogTF = 0;
	private static int linksCountdialogVote = 0;

	@Test
	public void addUser() throws InterruptedException {

		Thread.sleep(3000); // prosthetw ena wait 2 deyteroleptwn gia na
							// prolavei na ananewthei h selida. alliws
							// epistrefei False

	
		
		//Go to the CMS
		
		driver.findElement(By.xpath("//i[@class='fa fa-pencil-square']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Delegates")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='ctl01_mainContent_ctl00_TabContainer1_tabGroups_gvGroups']/tbody/tr[1]/td[11]")).click();
		
		Thread.sleep(2000);
		
		//Vres pedio gia First Name gia kainourgio user
//		driver.findElement(By.xpath("//*[@id='ctl01_mainContent_ctl00_TabContainer1_tabUsers_gvUsers_ctl32_txtNewFirstName']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.id("ctl01_mainContent_ctl00_TabContainer1_tabUsers_gvUsers_ctl32_txtNewFirstName")).sendKeys("Test"); //Grapse 'Test' gia First Name
		Thread.sleep(2000);
		
		//Vres pedio gia Laste Name gia kainourgio user
		//driver.findElement(By.xpath("//*[@id='ctl01_mainContent_ctl00_TabContainer1_tabUsers_gvUsers_ctl32_txtNewLastName']']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='ctl01_mainContent_ctl00_TabContainer1_tabUsers_gvUsers_ctl32_txtNewLastName']']")).sendKeys("User"); //Grapse 'User' gia Last Name
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//*[@id='ctl01_mainContent_ctl00_TabContainer1_tabUsers_gvUsers_ctl32_btnAddNew']")).click();
		Thread.sleep(2000);
		
		
		
		
		
		
//		WebElement table_element = driver.findElement(By.xpath(".//*[@id='ctl01_mainContent_ctl00_TabContainer1_tabGroups_gvGroups']/tbody"));
//        List <WebElement> tr_collection=table_element.findElements(By.xpath("id('ctl01_mainContent_ctl00_TabContainer1_tabGroups_gvGroups']/tbody/tr/td"));
//        
//        System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
//        int row_num,col_num;
//        row_num=1;
//        for(WebElement trElement : tr_collection)
//        {
//            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
//            System.out.println("NUMBER OF COLUMNS="+td_collection.size());
//            col_num=1;
//            for(WebElement tdElement : td_collection)
//            {
//                System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
//                col_num++;
//            }
//            row_num++;
//        } 
					

	}

}
