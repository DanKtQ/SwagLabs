package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@placeholder='Zip/Postal Code']")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    //Constructor
    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //method for checkout information
    public void checkoutInformation(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
    }

    //method to retrieve the page title
    public String getPageTitle() {
        return pageTitle.getText();
    }

    //method to continue
    public void continueCheckoutButton() {
        continueButton.click();
    }
}
