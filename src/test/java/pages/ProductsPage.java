package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ProductsPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//img[@alt='Sauce Labs Backpack' and @src='/static/media/sl-404.168b1cce.jpg']")
    private WebElement productPicture;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")
    private WebElement addToCartBacpack;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-bike-light')]")
    private WebElement addToCartBikeLight;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement shoppingCartQuantity;

    @FindBy(xpath = "//div[@class='inventory_item']//button")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//a[@data-test='social-linkedin']")
    private WebElement linkedinFooterButton;

    @FindBy(xpath = "//a[@data-test='social-facebook']")
    private WebElement facebookFooterButton;

    @FindBy(xpath = "//a[@data-test='social-twitter']")
    private WebElement xFooterButton;

    //Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //method to retrieve the page title
    public String getPageTitle() {

        return pageTitle.getText();
    }

    //method to retrieve the picture validity
    public String getProductPicture() {

        return productPicture.getAttribute("src");
    }

    //method for adding backpack to cart
    public void addToCartBackpack() {
        addToCartBacpack.click();
    }

    //method for adding bike light to cart
    public void addToCartBikeLight() {
        addToCartBikeLight.click();
    }

    //method to access my Cart
    public void accessMyCart() {
        shoppingCartButton.click();
    }

    //method to retrieve shopping cart quantity
    public Integer getShoppingCartQuantity() {
        String shopppingCartQuantity = shoppingCartQuantity.getText();
        return Integer.valueOf(shopppingCartQuantity);
    }

    //method to add a product from list, based on an index
    public void addToCartProductWithIndex(int index) {
        //similar to arrays:
        // addToCartButtons[index]
        addToCartButtons.get(index).click();
    }

    public String getTextFromButtonWithIndex(int index) {
        return addToCartButtons.get(index).getText();
    }

    //method to retrieve the price of a product based on index
    public String getProductPriceWithIndex(int index) {
        return productPrices.get(index).getText();
    }

    //method to access LinkedIn
    public void accessLinkedIn() {
        linkedinFooterButton.click();
        Set<String> windowsHandles = driver.getWindowHandles();
        List<String> handles = new ArrayList<>(windowsHandles);

        driver.switchTo().window(handles.get(1));
    }

    //method to access Facebook
    public void accessFacebook() {
        facebookFooterButton.click();
        Set<String> windowsHandles = driver.getWindowHandles();
        List<String> handles = new ArrayList<>(windowsHandles);

        driver.switchTo().window(handles.get(1));
    }

    //method to access X
    public void accessX() {
        xFooterButton.click();
        Set<String> windowsHandles = driver.getWindowHandles();
        List<String> handles = new ArrayList<>(windowsHandles);

        driver.switchTo().window(handles.get(1));
    }
}
