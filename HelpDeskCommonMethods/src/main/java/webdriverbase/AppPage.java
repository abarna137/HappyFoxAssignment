package webdriverbase;

import java.util.concurrent.TimeUnit;

import Logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppPage {
	
	public static final String MAIN_RESOURCES_PATH = "src/main/resources/";
	public static int WAIT_TIME_SEC = 60;	
	protected WebDriver driver ;
	
	JavascriptExecutor javaScriptExecutor;
	
	public AppPage(WebDriver driver) {
		this.driver = driver;
		waitImplicitly();	
		PageFactory.initElements(driver, this);
		maximizeWindow();
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}

	public void get(String url) {
		this.driver.get(url);
	}

	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}
	
	public void maximizeWindow() {
			driver.manage().window().maximize();		
	}
	
	public void waitImplicitly() {
		driver.manage().timeouts().implicitlyWait(WAIT_TIME_SEC, TimeUnit.SECONDS);
	}

	public void waitImplicitly(int timeOutInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
	}
	
	public void clearAndType(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void type(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void doClick(WebElement element) {
		element.click();
	}

	public String retrieveText(WebElement element) {
		return element.getText();
	}
	
	public void switchToDefaultContent() {
		this.driver.switchTo().defaultContent();
	}
	
	public void switchToFrame(WebElement frame) {
		this.driver.switchTo().frame(frame);
	}
	
	public void hoverOverElementUsingJS(WebElement element) {
		String js = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		getJavaScriptExecutor().executeScript(js, element);
	}
	
	public JavascriptExecutor getJavaScriptExecutor() {
		if (javaScriptExecutor == null)
			javaScriptExecutor = (JavascriptExecutor) driver;
		return javaScriptExecutor;
	}
	
	public void scrolltoElement(String locator) {
		try {
			WebElement element = this.driver.findElement(By.xpath(locator));
			scrolltoElement(element);
		} catch (Exception ex) {
			Log.error(ex.getMessage());
		}
	}
	
	public void scrolltoElement(WebElement element) {
		getJavaScriptExecutor().executeScript("arguments[0].scrollIntoView(false)", element);
		waitForVisible(element);
	}
	
	public void waitForClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_SEC);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_SEC);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public String getCurrentWorkingDirectory()
	{
		String workingDir = null;
		try{
			workingDir = System.getProperty("user.dir");
		}catch(Exception e){
			Log.error(e.getMessage());
		}
		return workingDir;
	}
	
	public String getTestDataFullDirPath(String fileName)
	{
		String path = MAIN_RESOURCES_PATH;
		if(getOperatingSystemType() == OSType.Windows)
			path = MAIN_RESOURCES_PATH;
		return (getCurrentWorkingDirectory()+ path+ fileName);
	}
	
	public enum OSType {
	    Windows, MacOS, Linux, Other
	  };
	  
	 protected static OSType detectedOS;
	 
	 public static OSType getOperatingSystemType() 
	 {
		 detectedOS = OSType.Windows;
		 return detectedOS;
	 }
	

}
