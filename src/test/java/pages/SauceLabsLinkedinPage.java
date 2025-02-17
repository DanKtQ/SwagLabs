package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SauceLabsLinkedinPage {
    WebDriver driver;

    //Constructor
    public SauceLabsLinkedinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to get the title of the current page
    public String getPageTitle() {
        return driver.getTitle();
    }
}
