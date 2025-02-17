package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    private WebDriver driver;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement orderConfirmationMessage;

    //Constructor
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //method to retrieve the page title
    public String getPageTitle() {
        return pageTitle.getText();
    }

    //method to retrieve the order confirmation message
    public String getConfirmationMessage() {
        return orderConfirmationMessage.getText();
    }
}
