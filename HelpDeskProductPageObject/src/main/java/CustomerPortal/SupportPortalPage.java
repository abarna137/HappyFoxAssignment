package CustomerPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Admin_Portal.AdminPortalTest2ndPage;
import webdriverbase.AppPage;


public class SupportPortalPage extends AppPage {

    //Object repository
    @FindBy(id = "id_subject")
    private WebElement subject;
    @FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    private WebElement message;
    @FindBy(id = "add-cc")
    private WebElement addCC;
    @FindBy(id = "add-bcc")
    private WebElement addBCC;
    @FindBy(id = "id_cc")
    private WebElement cc;
    @FindBy(id = "id_bcc")
    private WebElement bcc;
    @FindBy(xpath = "//a[@class='hf-attach-file_link']")
    private WebElement browseFile;
    @FindBy(id = "id_name")
    private WebElement fullName;
    @FindBy(id = "id_email")
    private WebElement email;
    @FindBy(id = "id_phone")
    private WebElement phone;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement createTicket;

    public SupportPortalPage(WebDriver driver) {
        super(driver);
    }

    public SupportPortalPage navigateToHappyFoxSupportPortalURL(String url) {
        get(url);
        return this;
    }

    public SupportPortalPage enterSubject(String text) {
        type(subject, text);
        return this;
    }


    public SupportPortalPage enterMessage(String text) {
        type(message, text);
        return this;
    }

    public SupportPortalPage clickAddCC() {
        doClick(addCC);
        return this;
    }


    public SupportPortalPage clickAddBCC() {
        doClick(addBCC);
        return this;
    }


    public SupportPortalPage enterCC(String text) {
        type(cc, text);
        return this;
    }


    public SupportPortalPage enterBCC(String text) {
        type(bcc, text);
        return this;
    }


    public SupportPortalPage addingScreenshot(String file) {
        type(browseFile, getTestDataFullDirPath(file));
        return this;
    }


    public SupportPortalPage enterFullName(String text) {
        waitForVisible(fullName);
        type(fullName, text);
        return this;
    }


    public SupportPortalPage enterEmail(String text) {
        waitForVisible(email);
        type(email, text);
        return this;
    }


    public void enterPhone(String text) {
        type(phone, text);
    }


    public AdminPortalTest2ndPage clickCreateTicket() {
        doClick(createTicket);
        return new AdminPortalTest2ndPage(driver);
    }

}
