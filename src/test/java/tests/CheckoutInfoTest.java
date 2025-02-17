package tests;

import org.junit.jupiter.api.Test;
import pages.CheckoutInformationPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutInfoTest extends TestBase {

    @Test
    public void checkoutInformation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        assertEquals("Products", productsPage.getPageTitle());

        productsPage.accessMyCart();

        YourCartPage myCart = new YourCartPage((driver));
        assertThat(myCart.getPageTitle(), equalTo("Your Cart"));

        myCart.checkoutButton();
        CheckoutInformationPage checkOut = new CheckoutInformationPage((driver));
        assertThat(checkOut.getPageTitle(), equalTo("Checkout: Your Information"));
    }
}
