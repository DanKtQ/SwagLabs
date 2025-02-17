package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class YourCartPage {

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//button[contains(@id,'checkout')]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//a[@id='item_4_title_link']")
    private WebElement backpackInCart;

    @FindBy(xpath = "//a[@id='item_0_title_link']")
    private WebElement bikeLightInCart;

    private WebDriver driver;

    //Constructor
    public YourCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //method to retrieve the page title
    public String getPageTitle() {
        return pageTitle.getText();
    }

    //method to checkout
    public void checkoutButton() {
        checkoutButton.click();
    }

    //method to retrieve the backpack
    public String getBackpackFromCart() {
        return backpackInCart.getText();
    }

    //method to retrieve the bike light
    public String getBikeLightFromCart() {
        return bikeLightInCart.getText();
    }
}
