package assignment2POM;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;



public class FindLead_Page extends Lead_BaseClass{

		public FindLead_Page(EdgeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
		}
		
		public FindLead_Page  clickPhoneTab() {
			
			driver.findElement(By.xpath("//span[text()='Phone']")).click();
			return this;
		}
		
		public FindLead_Page enterPhoneNumber(String phoneNumber) {
			driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(prop.getProperty("phoneNumber")); 
			return this;  
		}

		public FindLead_Page  clickFindLead() throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(By.xpath(prop.getProperty("FindLead_Page.FindLeadsButton.Xpath"))).click();
			Thread.sleep(2000);
			return this;  //FindLead_Page.FindLeadsButton.Xpath=Find Leads
		}
			
		public FindLead_Page  clickFindLeadMerge() {
			driver.findElement(By.linkText(prop.getProperty("MyLead_Page.FindLeadsButton.LinkText"))).click();
			return this;
		}
		
		public ViewLead_Page  selectFirstLink() {
			
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			return new ViewLead_Page(driver,prop);
		}

	public FindLead_Page  enterDeletedIDClickFindLeads() {
			
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadIDDelete);
			driver.findElement(By.xpath(prop.getProperty("FindLead_Page.FindLeadsButton.Xpath"))).click();
			return this;
		}
		

		public FindLead_Page  verifyDeleteIDNotDisplayed() throws InterruptedException {
			String text = driver.findElement(By.className("x-paging-info")).getText();
			if (text.equals("No records to display")) {
				System.out.println("Text matched");
			} else {
				System.out.println("Text not matched");
			}
			System.out.println(leadIDDelete+" : Deleted Lead ID");
			return this;
		}
		
		public FindLead_Page enterLeadIDClickFindLeads() {

			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadIDMerge);
			driver.findElement(By.xpath("//button[text()='Rechercher des prospects']")).click();
			return this;
		}
		
		public FindLead_Page verifyMergedLeadID() {
			String text = driver.findElement(By.className("x-paging-info")).getText();
			if (text.equals("No records to display")) {
				System.out.println("Text matched");
			} else {
				System.out.println("Text not matched");
			}
			return this;
		}
		
		}



	