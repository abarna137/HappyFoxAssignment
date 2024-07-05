package CommonTests;

import Admin_Portal.*;
import Constants.HappyFoxConstants;
import Logging.Log;
import org.testng.Assert;

import CustomerPortal.SupportPortalPage;
import webdriverbase.BaseTest;


public class CommonTests1 extends BaseTest{
	
private LoginPage hploginpage;
private SupportPortalPage hpSupportPortalPage;
private AdminPortalTest1stPage hpAdminPortalTest1;
private AdminPortalTest2ndPage hpAdminPortalTest2;

public void loginAsAdmin() {
    
    String Methodname = new Object(){}.getClass().getEnclosingMethod().getName(); 
	Log.info("Start of LoginAsAdmin "+"MethodName : "+Methodname); 

	try
	{	
		hploginpage = new LoginPage(getDriver());
		hploginpage.navigateToHappyFoxHomePageURL(HappyFoxConstants.ADMIN_PORTAL_URL);
		hploginpage.login(HappyFoxConstants.USERNAME, HappyFoxConstants.PASSWORD);
		Log.info("login clicked");
		hpAdminPortalTest1=hploginpage.validatePendingTicketsTitle();
		
		
	}
 
	catch(Throwable t)
	{
		Log.error(t.getMessage());
		Assert.fail("Error in " + Methodname + " : " + t.getMessage());
	}
	
	
}
  
  public void creatingSupportTicket() {
	  
	  String Methodname = new Object(){}.getClass().getEnclosingMethod().getName(); 
	  Log.info("Start of Client support ticket "+"MethodName : "+Methodname); 
	  
	  try 
	  {
		    
		  hpSupportPortalPage = new SupportPortalPage(getDriver());
		  hpSupportPortalPage.navigateToHappyFoxSupportPortalURL(HappyFoxConstants.SUPPORT_TICKET_URL)
		  			.enterSubject(HappyFoxConstants.SUBJECT).enterMessage(HappyFoxConstants.MESSAGE)
		  				.clickAddCC().clickAddBCC().enterFullName(HappyFoxConstants.FULL_NAME)
		  					.enterEmail(HappyFoxConstants.EMAIL).clickCreateTicket();
		  Log.info("Ticket created");
		  hpAdminPortalTest2.gotoAgentPortal();
	  
	  }
	  
	  catch (Throwable t) {
		    Log.error(t.getMessage());
			Assert.fail("Error in " + Methodname + " : " + t.getMessage());
	  }
  }
  
  public void testCase1() {
	  String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		  String Classname = getClass().getSimpleName();
          Log.info("start of method : " + Classname);
		  hpAdminPortalTest1 = hploginpage.validatePendingTicketsTitle().clickStatus().clickNewStatus();
          Log.info("New Status process started");
          hpAdminPortalTest1.enterStatusName(HappyFoxConstants.STATUS_NAME);
          Log.info("status name entered");
          //hpAdminPortalTest1.enterStatusColour("#21d0d5"); //#21d0d5 skyblue, #21d567 green
          //Log.info("colour set");
          hpAdminPortalTest1.enterBehavior(HappyFoxConstants.PENDING_BEHAVIOUR)
				  .enterStatusDescription(HappyFoxConstants.STATUS_DESCRIPTION);
          Log.info("description added");
          hpAdminPortalTest1.clickAddStatus();
          Log.info("Status added");
          hpAdminPortalTest1.setDefaultStatus(HappyFoxConstants.STATUS_NAME)
				  .clickPrioritySection().clickNewPriority();
          Log.info("New priority process started");
          hpAdminPortalTest1.enterPriorityName(HappyFoxConstants.PRIORITY_NAME)
				  .enterPriorityDescription(HappyFoxConstants.PRIORITY_DESCRIPTION)
				  		.enterPriorityHelpText(HappyFoxConstants.PRIORITY_HELPTEXT)
				  			.clickAddPriority().setDefaultPriroity(HappyFoxConstants.PRIORITY_NAME);
          Log.info("Priority added");
		}
		catch (Throwable e) {
			Log.info(e.getMessage());
			Assert.fail("Error in " + methodName + " : " + e.getMessage());
		}
		
	
} 
  
  public void testCase2() {
		
		try {
			
			String Classname = getClass().getSimpleName();
          Log.info("start of method : " + Classname);
          creatingSupportTicket();
          hpAdminPortalTest2 = hploginpage.validatePendingTicketsTitle1()
				  .clickPendingTickets();
          Log.info("Pending tickets clicked");
          hpAdminPortalTest2.openCustomerTicket(HappyFoxConstants.SUBJECT);
          
          //Assertion of the Priority and Status of the ticket created
			Assert.assertEquals(hpAdminPortalTest2.getContactName(),HappyFoxConstants.EXPECTED_NAME);
			Assert.assertEquals(hpAdminPortalTest2.getEmailtxt(),HappyFoxConstants.EMAIL);
			hpAdminPortalTest2.clickReplyButton();
			verifyPriorityAndStatusOfTicket(HappyFoxConstants.STATUS_NAME, HappyFoxConstants.PRIORITY_NAME);
			hpAdminPortalTest2.clickCannedAction()
					.clickSearchCannedAction(HappyFoxConstants.CANNED_ACTION_SEARCH)
					.clickApplyCannedAction();

          //Assertion of the Priority and Status of the ticket after edition
			verifyPriorityAndStatusOfTicket(HappyFoxConstants.CLOSED_STATUS, HappyFoxConstants.MEDIUM_PRIORITY);
          hpAdminPortalTest2.sendReply();
          hpAdminPortalTest1=hpAdminPortalTest2.closeTheTicket()
				  .clickPriorities();
          Log.info("Test Case 2 over");

		}

		catch(Exception e) {
			 Log.error(e.getMessage());
		}
}

	private void verifyPriorityAndStatusOfTicket(String status, String priority) {
		Assert.assertEquals(hpAdminPortalTest2.getStatustxt(),status);
		Assert.assertEquals(hpAdminPortalTest2.getPrioritytxt(),priority);
	}

	public void testCase3() {
		
		try {
			
			String Classname = getClass().getSimpleName();
			hpAdminPortalTest1.setDefaultPriroity(HappyFoxConstants.LOW_PRIORITY);
			Log.info("Default priority set as Low");
			hpAdminPortalTest1.clickAddedPriority(HappyFoxConstants.PRIORITY_NAME);
			Log.info("Priority clicked");
			hpAdminPortalTest1.clickPriorityDeleteLink().clickDeleteConfirm();
			Log.info("Priority deleted");  
			hpAdminPortalTest1.clickStatusesSection()
					.setDefaultStatus(HappyFoxConstants.NEW_STATUS);
			Log.info("Default status set as New");
			hpAdminPortalTest1.ClickAddedStatus(HappyFoxConstants.STATUS_NAME);
			Log.info("Statuses clicked");
			hpAdminPortalTest1.clickStatusDeleteLink().clickDeleteConfirm();
			Log.info("Statuses deleted");  
			hpAdminPortalTest1.clickProfile().clickLogout();
            Log.info("Logged out successfully"); 
			
				
		} 
		
		catch (Throwable e) {
			Log.error(e.getMessage());
		}
		
	
} 
}
