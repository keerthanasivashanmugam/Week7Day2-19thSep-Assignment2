package assignment3POM;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Login_Page extends ServiceNowBaseClass {

	public  Login_Page(EdgeDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;						
	}
	
	public ServiceNow_Page enterCredentialsClickLogin() {
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		return new ServiceNow_Page(driver,prop);
	}
	
	
}
