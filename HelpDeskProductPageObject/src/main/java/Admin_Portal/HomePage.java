package Admin_Portal;

import Constants.HappyFoxConstants;
import Logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import webdriverbase.AppPage;

import java.util.List;

public class HomePage extends AppPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "profileLink")
    WebElement profile;

    public void verifyHomePage() {
        if (!getCurrentUrl().equals(HappyFoxConstants.HOME_PAGE_URL)) {
            throw new IllegalStateException("Not on the home page");
        }
    }

    public void navigateToProfile() {
        doClick(profile);
    }

    public class TablePage extends AppPage {

        @FindBys(@FindBy(xpath = "//table[@id='dataTable']/tbody/tr"))
        List<WebElement> rows;


        public TablePage(WebDriver driver) {
            super(driver);
        }

        public String retrieveRowTexts() {
            String rowText = null;
            for (WebElement row:rows) {
                rowText = row.getText();
                Log.info("Row Text: " + rowText);
            }
            return rowText;
        }

    }


}
