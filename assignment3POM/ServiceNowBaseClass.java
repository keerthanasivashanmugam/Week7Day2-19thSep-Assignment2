package assignment3POM;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowBaseClass {

	public EdgeDriver driver;
	public static String IncidentNumber;
	public Properties prop;

	@BeforeMethod
	public void runServiceNowBase() throws IOException {

		FileInputStream fis = new FileInputStream("./src/main/resources/ServiceNow.properties");
		prop = new Properties();
		prop.load(fis);
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		}

	@AfterMethod
	public void closeServiceNow() {
		driver.close();
	}

}
