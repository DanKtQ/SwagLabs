package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SauceLabsXPage {
    WebDriver driver;

    //Constructor
    public SauceLabsXPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to get the title of the current page
    public String getPageTitle() {
        return driver.getTitle();
    }
}
