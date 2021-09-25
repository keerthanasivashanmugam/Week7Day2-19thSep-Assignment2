package assignment3POM;

import org.testng.annotations.Test;

public class DeleteINCRunner extends ServiceNowBaseClass{

	@Test
	public void updateIncident() throws InterruptedException {
		
		new Login_Page(driver, prop).enterCredentialsClickLogin().clickFilterEnterIncident()
		.clickIncident().switchToFrame().selectNumberEnterINCNumber().clickFirstResultLink()
		.clickDeleteButton().selectNumberEnterINCNumber().verifyDeleteINC();
	}
	
}
