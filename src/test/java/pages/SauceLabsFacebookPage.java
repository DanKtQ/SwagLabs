package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SauceLabsFacebookPage {
    WebDriver driver;

    //Constructor
    public SauceLabsFacebookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to get the url of the current page
    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}
