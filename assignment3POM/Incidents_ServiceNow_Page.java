package assignment3POM;



import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Incidents_ServiceNow_Page extends ServiceNowBaseClass{

	public Incidents_ServiceNow_Page(EdgeDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	
	
	public Incidents_ServiceNow_Page selectNumberEnterINCNumber() throws InterruptedException 
	{

		WebElement selectWebElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn = new Select(selectWebElement);
		drpdwn.selectByValue("number");
		WebElement searchINC = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchINC.sendKeys(IncidentNumber);
		searchINC.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		return this;
	}

	public Incidents_ServiceNow_Page  verifyCreatedINC()
	{
		String INCNo = driver.findElement(By.xpath("//label[@class='checkbox-label']/span")).getText();
		String replaceAllINCNO = INCNo.replaceAll("[^0-9INC]", "");
		Assert.assertEquals(IncidentNumber, replaceAllINCNO);
		return this;
	}
	
	public Incidents_ServiceNow_Page switchToFrame() {
		
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement1);
		return this;
	}
	
	public INCNumber_Incidents_ServiceNow_Page  clickFirstResultLink() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		return new INCNumber_Incidents_ServiceNow_Page(driver, prop);
	}
	
	public Incidents_ServiceNow_Page getAndVerifyAssignedGroup() {
		
		/*String AssignGrp = driver.findElement(By.xpath("//tr[@class='list_row list_odd']/td[10]")).getText();
		System.out.println("Assigned group:"+AssignGrp);	
		
		if(AssignGrp.contains("Software")) {
			System.out.println(IncidentNumber+ "  :Assigned to Software group");
			Assert.assertTrue(true);
		}else
		{
		System.out.println("Not Assigned to Software group");
		Assert.assertFalse(false);
		}
		driver.switchTo().defaultContent();
		return this;*/
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		String assignedGroup = driver.findElement(By.id("sys_display.incident.assignment_group")).getAttribute("value");
		Assert.assertEquals("Software", assignedGroup);
		System.out.println(IncidentNumber+" : is assigned to Software group");
		return this;
		
		
		
	}
	
	public Incidents_ServiceNow_Page verifyDeleteINC() {
		boolean displayed1 = driver.findElement(By.xpath("//td[text()='No records to display']")).isDisplayed();
		Assert.assertTrue(displayed1);
		System.out.println(IncidentNumber+" is deleted successfully");
		return this;
	}
	
}
