package Admin_Portal;

import Constants.HappyFoxConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import webdriverbase.AppPage;

public class AdminPortalTest1stPage extends AppPage {

    @FindBy(xpath = "//span[@class='hf-top-bar_title_text hf-font-light']")
    private WebElement title;
    @FindBy(linkText = "Statuses")
    private WebElement statuses;
    @FindBy(linkText = "Priorities")
    private WebElement priorities;
    @FindBy(xpath = "//button[@class='hf-mod-create']")
    private WebElement newStatus;
    @FindBy(xpath = "//input[@aria-label='Status Name']")
    private WebElement statusName;
    @FindBy(xpath = "//div[@class='sp-preview-inner']")
    private WebElement statusColourInner;
    @FindBy(xpath = "//input[@placeholder='Enter any valid color code format.']")
    private WebElement statusColour;
    @FindBy(xpath = "//div[@aria-label='Behavior']")
    private WebElement behavior;
    @FindBy(xpath = "//textarea[@aria-label='Description']")
    private WebElement statusDescription;
    @FindBy(xpath = "//button[@data-test-id='add-status']")
    private WebElement addStatus;
    @FindBy(xpath = "//a[@data-test-id='manage-statuses-left-nav']")
    private WebElement statusesSection;
    @FindBy(partialLinkText = "Priorities'")
    private WebElement prioritySection;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[9]/td[2]")
    private WebElement newPriority;
    @FindBy(xpath = "//input[@data-test-id='form-field-name']")
    private WebElement priorityName;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/header[1]/div[2]/nav[1]/div[7]/div[1]/div[1]")
    private WebElement priorityDescription;
    @FindBy(xpath = "//textarea[@data-test-id='form-field-helpText']")
    private WebElement priorityHelpText;
    @FindBy(xpath = "//button[@data-test-id='add-priority']")
    private WebElement addPriority;
    @FindBy(xpath = "//a[@data-test-id='priority-delete-trigger']")
    private WebElement priorityDeleteLink;
    @FindBy(xpath = "//span[contains(text(),'Choose Priority')]")
    private WebElement newDefaultPriority;
    @FindBy(xpath = "//input[contains(@class,'ember-power-select-search-input')]")
    private WebElement choosingNewDefaultPriority;
    @FindBy(xpath = "//button[@data-test-id='delete-dependants-primary-action']")
    private WebElement deleteConfirm;
    @FindBy(xpath = "//a[@data-test-id='status-delete-trigger']")
    private WebElement statusDeleteLink;
    @FindBy(xpath = "//span[contains(text(),'Choose Status')]")
    private WebElement newDefaultStatus;
    @FindBy(xpath = "//iframe[@id='hfc-frame']")
    private WebElement toFrames;
    @FindBy(xpath = "//div[@class='hf-avatar-image-container ember-view']//img[@class='hf-avatar-image hf-avatar-image_show']")
    private WebElement profile;
    @FindBy(linkText = "Logout")
    private WebElement logout;

    public AdminPortalTest1stPage(WebDriver driver) {
        super(driver);

    }

    public AdminPortalTest1stPage clickStatus() {
        hoverOverElementUsingJS(title);
        doClick(title);
        doClick(statuses);
        return this;
    }

    public AdminPortalTest1stPage clickPriorities() throws InterruptedException {
        waitForVisible(title);
        hoverOverElementUsingJS(title);
        doClick(title);
        hoverOverElementUsingJS(priorities);
        doClick(priorities);
        return this;
    }

    public AdminPortalTest1stPage clickNewStatus() {
        doClick(newStatus);
        return this;
    }

    public AdminPortalTest1stPage enterStatusName(String text) {
        type(statusName, text);
        return this;
    }

    public AdminPortalTest1stPage clickStatusColourInner() {
        doClick(statusColourInner);
        return this;
    }

    public AdminPortalTest1stPage enterStatusColour(String text) {
        clickStatusColourInner();
        clearAndType(statusColour, text);
        clickStatusColourInner();
        return this;
    }

    public AdminPortalTest1stPage enterBehavior(String text) {
        doClick(behavior);
        type(behavior, text);
        behavior.sendKeys(Keys.ENTER);
        return this;
    }

    public AdminPortalTest1stPage enterStatusDescription(String text) {
        clearAndType(statusDescription, text);
        return this;
    }

    public AdminPortalTest1stPage clickAddStatus() {
        doClick(addStatus);
        return this;
    }

    public AdminPortalTest1stPage clickStatusesSection() throws InterruptedException {
        scrolltoElement(statusesSection);
        doClick(statusesSection);
        return this;
    }

    public AdminPortalTest1stPage setDefaultStatus(String status) throws InterruptedException {
        String statusXpath = "//div[contains(text(),'" + status + "')]//following::td[3]";
        WebElement statusEle = driver.findElement(By.xpath(statusXpath));
        hoverOverElementUsingJS(statusEle);
        doClick(statusEle);
        return this;
    }

    public AdminPortalTest1stPage clickPrioritySection() {
        doClick(prioritySection);
        return this;
    }

    public AdminPortalTest1stPage clickNewPriority() {
        doClick(newPriority);
        return this;
    }

    public AdminPortalTest1stPage enterPriorityName(String text) {
        clearAndType(priorityName, text);
        return this;
    }

    public AdminPortalTest1stPage enterPriorityDescription(String text) {
        clearAndType(priorityDescription, text);
        return this;
    }

    public AdminPortalTest1stPage enterPriorityHelpText(String text) {
        clearAndType(priorityHelpText, text);
        return this;
    }

    public AdminPortalTest1stPage clickAddPriority() {
        doClick(addPriority);
        return this;
    }

    public AdminPortalTest1stPage setDefaultPriroity(String priroity) throws InterruptedException {
        String priorityXpath = "//span[contains(text(),'" + priroity + "')]//following::td[3]";
        WebElement priorityElement = driver.findElement(By.xpath(priorityXpath));
        hoverOverElementUsingJS(priorityElement);
        doClick(priorityElement);
        return this;
    }

    public AdminPortalTest1stPage clickAddedPriority(String priority) {
        String priorityXpath = "//span[contains(text(),'" + priority + "')]";
        scrolltoElement(priorityXpath);
        doClick(driver.findElement(By.xpath(priorityXpath)));
        return this;
    }

    public AdminPortalTest1stPage clickPriorityDeleteLink() {
        scrolltoElement(priorityDeleteLink);
        doClick(priorityDeleteLink);
        return this;
    }

    public void setNewDefaultPriority() {
        hoverOverElementUsingJS(newDefaultPriority);
        doClick(newDefaultPriority);
        doClick(choosingNewDefaultPriority);
        type(choosingNewDefaultPriority, HappyFoxConstants.LOW_PRIORITY);
        choosingNewDefaultPriority.sendKeys(Keys.ENTER);
    }

    public AdminPortalTest1stPage clickDeleteConfirm() {
        doClick(deleteConfirm);
        return this;
    }

    public AdminPortalTest1stPage ClickAddedStatus(String status) {
        String statusXpath = "//div[contains(text(),'" + status + "')]";
        scrolltoElement(statusXpath);
        doClick(driver.findElement(By.xpath(statusXpath)));
        return this;
    }

    public AdminPortalTest1stPage clickStatusDeleteLink() {
        scrolltoElement(statusDeleteLink);
        doClick(statusDeleteLink);
        return this;
    }

    public AdminPortalTest1stPage setNewDefaultStatus() {
        hoverOverElementUsingJS(newDefaultStatus);
        doClick(newDefaultStatus);
        newDefaultStatus.sendKeys(Keys.DOWN);
        newDefaultStatus.sendKeys(Keys.ENTER);
        return this;
    }

    public void switchToFrames() {
        switchToFrame(toFrames);
    }

    public void switchToDefaultPage() {
        switchToDefaultContent();
    }

    public AdminPortalTest1stPage clickProfile() throws InterruptedException {
        waitForClickable(profile);
        doClick(profile);
        return this;
    }

    public void clickLogout() {
        doClick(logout);
    }



}
