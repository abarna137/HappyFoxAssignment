package Admin_Portal;

import Logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriverbase.AppPage;

public class AdminPortalTest2ndPage extends AppPage {

    @FindBy(xpath = "//span[@class='hf-top-bar_title_text hf-font-light']")
    private WebElement title;
    @FindBy(partialLinkText = "Pending Tickets")
    private WebElement pendingTickets;
    @FindBy(xpath = "//a[@data-test-id='ticket-side-pane-contact-name']")
    private WebElement contactName;
    @FindBy(xpath = "//a[@data-test-id='ticket-side-pane-contact-name']//following::div[1]/div[1]/span[1]")
    private WebElement emailtxt;
    @FindBy(xpath = "//div[contains(text(),'status')]//following::div[1]")
    private WebElement statustxt;
    @FindBy(xpath = "//div[contains(text(),'status')]//following::div[1]//following::span[1]/div/div/div/div[2]")
    private WebElement prioritytxt;
    @FindBy(xpath = "//span[contains(text(),'Reply')]")
    private WebElement replyBtn;
    @FindBy(xpath = "//span[@data-test-id='canned-action-trigger']")
    private WebElement cannedAction;
    @FindBy(xpath = "//input[@placeholder='Search more Canned Actions']")
    private WebElement searchCannedAction;
    @FindBy(xpath = "//li[@class='ember-power-select-option']")
    private WebElement chooseCannedAction;
    @FindBy(xpath = "//button[@data-test-id='hf-add-canned-action']")
    private WebElement applyCannedAction;
    @FindBy(xpath = "//button[@data-test-id='add-update-reply-button']")
    private WebElement reply;
    @FindBy(partialLinkText = "Agent Portal")
    private WebElement agentPortal;
    @FindBy(xpath = "//a[@data-test-id='details-close']")
    private WebElement closeTicket;

    public AdminPortalTest2ndPage(WebDriver driver) {
        super(driver);
    }

    public AdminPortalTest2ndPage clickPendingTickets() {
        hoverOverElementUsingJS(pendingTickets);
        doClick(pendingTickets);
        return this;
    }


    public void openCustomerTicket(String ticket) {
        String ticketXpath = "//a[@title='" + ticket + "']";
        WebElement customerTicket = driver.findElement(By.xpath(ticketXpath));
        hoverOverElementUsingJS(customerTicket);
        doClick(customerTicket);
    }


    public String getContactName() {
        Log.info(retrieveText(contactName));
        return retrieveText(contactName);
    }


    public String getEmailtxt() {
        Log.info(retrieveText(emailtxt));
        return retrieveText(emailtxt);
    }


    public String getStatustxt() {
        Log.info(retrieveText(statustxt));
        return retrieveText(statustxt);
    }


    public String getPrioritytxt() {
        Log.info(retrieveText(prioritytxt));
        return retrieveText(prioritytxt);
    }


    public void clickReplyButton() {
        doClick(replyBtn);

    }


    public AdminPortalTest2ndPage clickCannedAction() {
        doClick(cannedAction);
        return this;

    }


    public AdminPortalTest2ndPage clickSearchCannedAction(String searchText) {
        doClick(searchCannedAction);
        type(searchCannedAction, searchText);
        doClick(chooseCannedAction);
        return this;
    }


    public void clickApplyCannedAction() {
        doClick(applyCannedAction);

    }


    public void sendReply() throws InterruptedException {
        doClick(reply);


    }


    public void gotoAgentPortal() {

        doClick(agentPortal);
    }


    public AdminPortalTest1stPage closeTheTicket() {
        doClick(closeTicket);
        return new AdminPortalTest1stPage(driver);

    }

}
