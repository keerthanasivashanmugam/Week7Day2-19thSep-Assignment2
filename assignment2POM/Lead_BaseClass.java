package assignment2POM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Lead_BaseClass {

	public EdgeDriver driver;
	public String fileName=null;
	public static String leadIDDelete;
	public static String leadIDMerge;
	public Properties prop;
	
	@DataProvider()
	public String[][] LeadDetails() throws IOException   {
	return readingDataFromExcel1.readExcel1(fileName);
	}
	
	@Parameters({"language"})
	@BeforeMethod
	public void preCondition(String language) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/main/resources/LeadFunctionality"+language+".properties");
		prop = new Properties();
		prop.load(fis);
		
		
		WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
}
