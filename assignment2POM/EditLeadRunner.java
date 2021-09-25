package assignment2POM;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class EditLeadRunner extends Lead_BaseClass{
	
		@BeforeClass
		public void fileName () {
			fileName ="EditLead";
		}

	@Test(dataProvider="LeadDetails")
	public void runEditLead(String userName, String password, String phoneNumber, String companyName) throws InterruptedException   {
		
		new Login_Page(driver,prop).enterUsernamePassword((prop.getProperty("userName")),prop.getProperty("password")).clickLogin().clickCRMSFA().clickLead()
		.clickFindLeads().clickPhoneTab().enterPhoneNumber(phoneNumber).clickFindLead()
		.selectFirstLink().clickEdit().enterCompanyName(companyName).clickCreateLead().getUpdatedCompanyNameToPrint();
	
	}
	
}
