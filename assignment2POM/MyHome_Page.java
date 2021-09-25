package assignment2POM;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class MyHome_Page extends Lead_BaseClass{

		public  MyHome_Page(EdgeDriver driver, Properties prop)
		{
			this.driver=driver;
			this.prop=prop;
		}
		
		public MyLead_Page  clickLead() {
			
			driver.findElement(By.linkText(prop.getProperty("MyHome_Page.LeadsTab.LinkText"))).click(); //MyHome_Page.LeadTab.LinkText=Leads
			return new MyLead_Page(driver,prop);
		}
		
	}

	

