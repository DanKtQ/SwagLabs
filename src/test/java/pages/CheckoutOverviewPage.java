package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutOverviewPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//button[contains(@id,'finish')]")
    private WebElement finishButton;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement totalPrice;

    //Constructor
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //method to retrieve the page title
    public String getPageTitle() {
        return pageTitle.getText();
    }

    //method to finish the order
    public void finishOrderButton() {
        finishButton.click();
    }

    //method to retrieve the price of a product based on index
    public double getProductPrice(int index) {
        String priceText = productPrices.get(index).getText(); // Example: "$29.99"
        priceText = priceText.replace("$", ""); // Remove the dollar sign
        return Double.parseDouble(priceText); // Convert to double
    }
}
