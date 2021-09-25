package assignment3POM;

import org.testng.annotations.Test;

public class CreateINCRunner extends ServiceNowBaseClass{

	@Test
	public void createIncident() throws InterruptedException {
		
		new Login_Page(driver, prop).enterCredentialsClickLogin().clickFilterEnterIncident()
		.clickCreateNew().NumberPageswitchToFrame().getIncidentNumber()
		.enterCallerName().enterShortDescription().getIncidentNumber()
		.clickCreateINCSubmit().selectNumberEnterINCNumber().verifyCreatedINC();
	
	}
}
