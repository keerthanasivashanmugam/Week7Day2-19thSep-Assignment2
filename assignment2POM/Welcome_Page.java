package assignment2POM;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class Welcome_Page extends Lead_BaseClass{

		public Welcome_Page(EdgeDriver driver, Properties prop)
		{
			this.driver=driver;
			this.prop=prop;
		}
		
		public MyHome_Page clickCRMSFA() {
			driver.findElement(By.linkText("CRM/SFA")).click();
			return new MyHome_Page(driver,prop);
		}
	}

	

