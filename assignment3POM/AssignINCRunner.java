package assignment3POM;

import org.testng.annotations.Test;

public class AssignINCRunner extends ServiceNowBaseClass{

	@Test
	public void updateIncident() throws InterruptedException {
		
		new Login_Page(driver, prop).enterCredentialsClickLogin().clickFilterEnterIncident()
		.clickOpen().switchToFrame().selectNumberEnterINCNumber().clickFirstResultLink()
		.selectAssigngroupAsSoftware().enterWorkNotes().clickUpdateButton().getAndVerifyAssignedGroup();
	
}
	
}
