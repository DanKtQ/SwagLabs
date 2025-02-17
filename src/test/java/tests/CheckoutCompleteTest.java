package tests;

import org.junit.jupiter.api.Test;
import pages.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutCompleteTest extends TestBase {

    @Test
    public void emptyCartCheckoutComplete() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(1000);
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        assertEquals("Products", productsPage.getPageTitle());
        Thread.sleep(1000);

        productsPage.accessMyCart();
        Thread.sleep(1000);

        YourCartPage myCart = new YourCartPage((driver));
        assertThat(myCart.getPageTitle(), equalTo("Your Cart"));

        myCart.checkoutButton();
        Thread.sleep(1000);

        CheckoutInformationPage checkOut = new CheckoutInformationPage((driver));
        assertThat(checkOut.getPageTitle(), equalTo("Checkout: Your Information"));
        checkOut.checkoutInformation("Dan", "B", "500283");

        checkOut.continueCheckoutButton();
        Thread.sleep(1000);

        CheckoutOverviewPage orderOverview = new CheckoutOverviewPage((driver));
        assertThat(orderOverview.getPageTitle(), equalTo("Checkout: Overview"));

        orderOverview.finishOrderButton();
        Thread.sleep(1000);

        CheckoutCompletePage orderDone = new CheckoutCompletePage((driver));
        assertThat(orderDone.getPageTitle(), equalTo("Checkout: Complete!"));
        assertThat(orderDone.getConfirmationMessage(), equalTo("Thank you for your order!"));
        Thread.sleep(1000);
    }

    @Test
    public void OrderCompleteForFirst3Products() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(1000);
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        assertEquals("Products", productsPage.getPageTitle());
        Thread.sleep(1000);

        productsPage.addToCartProductWithIndex(0);
        productsPage.addToCartProductWithIndex(3);
        productsPage.addToCartProductWithIndex(5);

        productsPage.accessMyCart();
        Thread.sleep(1000);

        YourCartPage myCart = new YourCartPage((driver));
        assertThat(myCart.getPageTitle(), equalTo("Your Cart"));

        myCart.checkoutButton();
        Thread.sleep(1000);

        CheckoutInformationPage checkOut = new CheckoutInformationPage((driver));
        assertThat(checkOut.getPageTitle(), equalTo("Checkout: Your Information"));
        checkOut.checkoutInformation("Dan", "B", "500283");

        checkOut.continueCheckoutButton();
        Thread.sleep(1000);

        CheckoutOverviewPage orderOverview = new CheckoutOverviewPage((driver));
        assertThat(orderOverview.getPageTitle(), equalTo("Checkout: Overview"));
        System.out.println("The total price of first 3 products is: " + (orderOverview.getProductPrice(0) + orderOverview.getProductPrice(1) + orderOverview.getProductPrice(2)) + " $");

        orderOverview.finishOrderButton();
        Thread.sleep(1000);

        CheckoutCompletePage orderDone = new CheckoutCompletePage((driver));
        assertThat(orderDone.getPageTitle(), equalTo("Checkout: Complete!"));
        assertThat(orderDone.getConfirmationMessage(), equalTo("Thank you for your order!"));
        Thread.sleep(1000);
    }
}
