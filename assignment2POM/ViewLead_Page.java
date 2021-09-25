package assignment2POM;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ViewLead_Page extends Lead_BaseClass {

	public ViewLead_Page(EdgeDriver driver, Properties prop) {
		this.driver = driver;
		this.prop=prop;
	}

	public ViewLead_Page getCompanyFirstLastName() {

		boolean displayed1 = driver.findElement(By.id("viewLead_companyName_sp")).isDisplayed();
		boolean displayed2 = driver.findElement(By.id("viewLead_firstName_sp")).isDisplayed();
		boolean displayed3 = driver.findElement(By.id("viewLead_lastName_sp")).isDisplayed();

		Assert.assertTrue(displayed1);
		Assert.assertTrue(displayed2);
		Assert.assertTrue(displayed3);

		String text1 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String leadID = text1.replaceAll("[^0-9]", "");
		System.out.println(leadID + " : Created Lead ID");
		return this;
	}

	public OpentapsCRM_Page clickEdit() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.linkText(prop.getProperty("ViewLead_Page.EditButton.LinkText"))).click();  //ViewLead_Page.EditButton.LinkText=Edit
		return new OpentapsCRM_Page(driver,prop);
	}

	public ViewLead_Page getUpdatedCompanyNameToPrint() throws InterruptedException {
		Thread.sleep(9000);
		String updatedComapnyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println(updatedComapnyName + "  : updated company name");
		return this;
	}

	public OpentapsCRM_Page clickDuplicateButton() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.linkText(prop.getProperty("ViewLead_Page.DuplicateLeadButton.LinkText"))).click();  //ViewLead_Page.DuplicateLeadButton.LinkText=Duplicate Lead
		return new OpentapsCRM_Page(driver,prop);
	}

	public ViewLead_Page getUpdatedCompanyName() throws InterruptedException {
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		String replaceAll = text.replaceAll("[^0-9 ()]", "");
		System.out.println(replaceAll + " Created Duplicate Lead ID");
		return this;
	}

	public MyLead_Page clickDeleteteButton() {

		String leadID = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		leadIDDelete = leadID.replaceAll("[^0-9]", "");
		
		if(driver.findElement(By.xpath(prop.getProperty("ViewLead_Page.DeleteButton.Xpath"))).isDisplayed())
		{
		driver.findElement(By.xpath(prop.getProperty("ViewLead_Page.DeleteButton.Xpath"))).click();//ViewLead_Page.DeleteButton.LinkText=Delete
		return new MyLead_Page(driver,prop);
		}else {
			System.out.println(leadIDDelete +": doesn't have delete option");
		}
		return new MyLead_Page(driver,prop);
	}

}
