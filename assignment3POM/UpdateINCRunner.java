package assignment3POM;

import org.testng.annotations.Test;

public class UpdateINCRunner extends ServiceNowBaseClass{

	@Test
	public void updateIncident() throws InterruptedException {
		
		new Login_Page(driver, prop).enterCredentialsClickLogin().clickFilterEnterIncident()
		.clickIncident().switchToFrame().selectNumberEnterINCNumber().clickFirstResultLink()
		.selectUrgencyHigh().selectStateInProgress().clickUpdateButton()
		.clickFirstResultLink().getAndVerifyUrgencyState();
	
	}
	
}
