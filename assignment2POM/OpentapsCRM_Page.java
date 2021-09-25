package assignment2POM;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class OpentapsCRM_Page extends Lead_BaseClass{
	
	public OpentapsCRM_Page(EdgeDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	
	public ViewLead_Page clickCreateLead( ) {
		
		driver.findElement(By.name("submitButton")).click();
		return new ViewLead_Page(driver,prop);
	}
	
	public OpentapsCRM_Page enterCompanyName(String companyName) {
		
		WebElement comapnyNameElement = driver.findElement(By.id("updateLeadForm_companyName"));
		String actualCompanyName = comapnyNameElement.getAttribute("value");
		System.out.println(actualCompanyName+"  : actual company name");
		comapnyNameElement.clear();
		comapnyNameElement.sendKeys(companyName);
		return this;
	}
	
}
