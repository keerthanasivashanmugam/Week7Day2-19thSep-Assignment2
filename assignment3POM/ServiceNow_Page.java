package assignment3POM;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ServiceNow_Page extends ServiceNowBaseClass{

	public ServiceNow_Page(EdgeDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	
	public ServiceNow_Page clickFilterEnterIncident() {
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		driver.findElement(By.xpath("//input[@id='filter']")).click();
		return this;
	}
	
	public INCNumber_Incidents_ServiceNow_Page clickCreateNew() {
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		return new INCNumber_Incidents_ServiceNow_Page(driver, prop);
	}
	
	
	public Incidents_ServiceNow_Page clickIncident() {
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		return new Incidents_ServiceNow_Page(driver, prop);
	}
	
	public Incidents_ServiceNow_Page  clickOpen() {
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		return new Incidents_ServiceNow_Page(driver, prop);
		
	}
	
	
	
}
