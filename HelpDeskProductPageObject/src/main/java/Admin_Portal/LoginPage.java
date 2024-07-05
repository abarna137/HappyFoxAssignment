package Admin_Portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriverbase.AppPage;

public class LoginPage extends AppPage {
    //Object repo
    @FindBy(id = "username")
    WebElement usernameTxt;
    @FindBy(id = "password")
    WebElement passwordTxt;
    @FindBy(id = "loginButton")
    WebElement loginBtn;
    @FindBy(linkText = "Forgot password?")
    WebElement forgotPasswordLink;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        type(usernameTxt, username);
        type(passwordTxt, password);
        doClick(loginBtn);
    }

    public void forgotPassword() {
        doClick(forgotPasswordLink);
    }

    public void navigateToHappyFoxHomePageURL(String adminPortalURL) {
        get(adminPortalURL);
    }

    public AdminPortalTest1stPage validatePendingTicketsTitle() {
        return new AdminPortalTest1stPage(driver);
    }

    public AdminPortalTest2ndPage validatePendingTicketsTitle1() {
        return new AdminPortalTest2ndPage(driver);
    }
}
