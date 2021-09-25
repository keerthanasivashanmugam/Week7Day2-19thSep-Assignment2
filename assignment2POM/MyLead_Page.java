package assignment2POM;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class MyLead_Page extends Lead_BaseClass{

		
		public MyLead_Page(EdgeDriver driver, Properties prop) {
			this.driver=driver;
			this.prop=prop;
		}

		public CreateLead_Page clickCreateLead() {
			driver.findElement(By.linkText(prop.getProperty("MyLead_Page.CreateLeadButton.LinkText"))).click();   //MyLead_Page.CreateLeadButton.LinkText=Create Lead
			return new CreateLead_Page(driver,prop);
		}


		public FindLead_Page  clickFindLeads() throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(By.linkText(prop.getProperty("MyLead_Page.FindLeadsButton.LinkText"))).click();	//MyLead_Page.FindLeadsButton.LinkText=Find Leads
			return new FindLead_Page(driver,prop);
		}

	}


