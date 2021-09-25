package assignment3POM;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class INCNumber_Incidents_ServiceNow_Page extends ServiceNowBaseClass{

	public INCNumber_Incidents_ServiceNow_Page(EdgeDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	
	public INCNumber_Incidents_ServiceNow_Page NumberPageswitchToFrame() {
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement1);
		return this;
	}
	
	public INCNumber_Incidents_ServiceNow_Page getIncidentNumber() {
		//input[@id='incident.number']
		IncidentNumber = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Created Incident no : "+IncidentNumber);
		return this;
	}
	
	
	public INCNumber_Incidents_ServiceNow_Page enterCallerName() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).sendKeys(prop.getProperty("caller"));
		Thread.sleep(3000);
		System.out.println("Caller Name : "+prop.getProperty("caller"));
		return this;
	}
	
	public INCNumber_Incidents_ServiceNow_Page enterShortDescription() {
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys(prop.getProperty("shortdescription"));
		System.out.println("Short Description : "+prop.getProperty("shortdescription"));
		return this;
	}
	
	public Incidents_ServiceNow_Page  clickCreateINCSubmit() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(1000);
		return new Incidents_ServiceNow_Page(driver, prop);
	}
	
	
	public INCNumber_Incidents_ServiceNow_Page  selectUrgencyHigh() {
		WebElement selectElement1 = driver.findElement(By.xpath("//select[@name='incident.urgency']"));
		Select drpdwn1= new Select(selectElement1);
		drpdwn1.selectByValue("1");
		String urgency = driver.findElement(By.xpath("(//option[@selected='SELECTED'])[8]")).getText();
		System.out.println("Before update : "+urgency);
		return this;
	}
	
	public INCNumber_Incidents_ServiceNow_Page  selectStateInProgress() {
		WebElement selectElement2 = driver.findElement(By.xpath("//select[@name='incident.state']"));
		Select drpdwn2 = new Select(selectElement2);
		drpdwn2.selectByValue("2");
		String state = driver.findElement(By.xpath("(//option[@selected='SELECTED'])[5]")).getText();
		System.out.println("Before update : "+state);
		return this;
	}
	
	public Incidents_ServiceNow_Page  clickUpdateButton() {
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		return new Incidents_ServiceNow_Page(driver, prop);
	}
	
	public INCNumber_Incidents_ServiceNow_Page  getAndVerifyUrgencyState() {
		String stateAfterUpdate = driver.findElement(By.xpath("(//option[@selected='SELECTED'])[5]")).getText();
		String urgencyAfterUpdate = driver.findElement(By.xpath("(//option[@selected='SELECTED'])[8]")).getText();
		System.out.println("Urgency after update"+urgencyAfterUpdate);
		System.out.println("State after update"+stateAfterUpdate);
			if(urgencyAfterUpdate.contains("High") 	&& 	stateAfterUpdate.contains("In Progress"))
			{
				System.out.println("Update happened for : "+IncidentNumber);
			}else
				System.out.println("Update didn happened for : "+IncidentNumber);
			
		return this;
	}
	
	
	public INCNumber_Incidents_ServiceNow_Page selectAssigngroupAsSoftware() throws InterruptedException {
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[6]")).click();
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List <String> windowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
		driver.switchTo().window(windowHandlesList1.get(1));
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(prop.getProperty("group"));
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		Set<String> windowHandlesSet2 = driver.getWindowHandles();
		List <String> windowHandlesList2 = new ArrayList<String>(windowHandlesSet2);
		driver.switchTo().window(windowHandlesList2.get(0));
		WebElement frameElement2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement2);
		Thread.sleep(1000);
		return this;
		
	}
	
	public INCNumber_Incidents_ServiceNow_Page  enterWorkNotes() {
		driver.findElement(By.xpath("(//span[@class='icon icon-locked'])[2]")).click();
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys(prop.getProperty("workNotes"));
		return this;
	}
	
	public Incidents_ServiceNow_Page clickDeleteButton() throws InterruptedException 
	{
		driver.findElement(By.xpath("//button[@id='sysverb_delete']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		Thread.sleep(3000);
		return new Incidents_ServiceNow_Page(driver, prop);
	}
	
}
