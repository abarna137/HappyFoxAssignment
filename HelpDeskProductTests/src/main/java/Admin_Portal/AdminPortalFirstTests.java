package Admin_Portal;

import Logging.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonTests.CommonTests1; 

 public class AdminPortalFirstTests extends CommonTests1  {

  @Test
  public void Scenario1() {
	  
	   String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
	
		try {
			
			String className = getClass().getSimpleName();
            Log.info("start of method : " + className);
            loginAsAdmin();
            testCase1();
            testCase3();
				
		} 
		
		catch (Throwable e) {
			Log.error(e.getMessage());
			Assert.fail("Error in "+ methodName +" : "+ e.getMessage());
		}
		
	
  } 
  
 }
 