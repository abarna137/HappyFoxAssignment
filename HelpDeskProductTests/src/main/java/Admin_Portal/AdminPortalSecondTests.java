package Admin_Portal;

import Logging.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonTests.CommonTests1;

public class AdminPortalSecondTests extends CommonTests1 {
  
  @Test
  public void Scenario2() {
	  
	  String methodname = new Object(){}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String classname = getClass().getSimpleName();
            Log.info("start of method : " + classname);
            loginAsAdmin();
            testCase1();
            testCase2();
            testCase3();
              
		}
		
		catch(Throwable t) {
			 Log.error(t.getMessage());
			 Assert.fail("Error in "+ methodname +" : "+ t.getMessage());
		}
  }
}
