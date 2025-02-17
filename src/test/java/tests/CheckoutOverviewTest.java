package tests;

import org.junit.jupiter.api.Test;
import pages.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutOverviewTest extends TestBase {

    @Test
    public void checkoutOverview() {
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
        checkOut.checkoutInformation("Dan", "B", "500283");

        checkOut.continueCheckoutButton();

        CheckoutOverviewPage orderOverview = new CheckoutOverviewPage((driver));
        assertThat(orderOverview.getPageTitle(), equalTo("Checkout: Overview"));
    }

    @Test
    public void twoItemsTotalPrice() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        assertEquals("Products", productsPage.getPageTitle());

        productsPage.addToCartProductWithIndex(0);
        productsPage.addToCartProductWithIndex(2); //el pune produsul cu index 2 din restul butoanelor "Add to cart" ramase disponibile. Dupa ce adauga produsul cu index0, mai raman 5 butoane disponibil. Astfel ca produsul cu index 2, va fi de fapt produsul initial care avea index 3

        productsPage.accessMyCart();

        YourCartPage myCart = new YourCartPage((driver));
        assertThat(myCart.getPageTitle(), equalTo("Your Cart"));

        myCart.checkoutButton();
        CheckoutInformationPage checkOut = new CheckoutInformationPage((driver));
        assertThat(checkOut.getPageTitle(), equalTo("Checkout: Your Information"));
        checkOut.checkoutInformation("Dan", "B", "500283");

        checkOut.continueCheckoutButton();

        CheckoutOverviewPage orderOverview = new CheckoutOverviewPage((driver));
//        double price1 = orderOverview.getProductPrice(0);
//        double price2 = orderOverview.getProductPrice(1); //pentru ca am doar 2 elemente in cos(produsul cu index2 din productsPage devine produsul cu index1 din orderOverview)
//        double totalPrice = price1 + price2;
        System.out.println("The total price of products with index 0 and index 2 is: " + (orderOverview.getProductPrice(0) + orderOverview.getProductPrice(1)) + " $");
    }
}
