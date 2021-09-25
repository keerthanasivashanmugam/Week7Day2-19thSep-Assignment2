package assignment2POM;
import org.testng.annotations.Test;


public class DeleteteLeadRunner extends Lead_BaseClass{
	
	@Test()
	public void runDeleteLead() throws InterruptedException      {
		
		new Login_Page(driver,prop).enterUsernamePassword((prop.getProperty("userName")),prop.getProperty("password")).clickLogin()
		.clickCRMSFA().clickLead().clickFindLeads().clickPhoneTab().enterPhoneNumber(prop.getProperty("phoneNumber")).clickFindLead().selectFirstLink()
		.clickDeleteteButton().clickFindLeads().enterDeletedIDClickFindLeads().verifyDeleteIDNotDisplayed();
	}
	
}
