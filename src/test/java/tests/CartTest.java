package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest extends TestBase {

    @Test
    public void accessMyCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        assertEquals("Products", productsPage.getPageTitle());

        productsPage.accessMyCart();

        YourCartPage myCart = new YourCartPage((driver));
        assertThat(myCart.getPageTitle(), equalTo("Your Cart"));
    }

    @Test
    public void checkProductsInCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        assertEquals("Products", productsPage.getPageTitle());

        productsPage.addToCartBackpack();
        productsPage.addToCartBikeLight();
        assertThat(productsPage.getShoppingCartQuantity(), equalTo(2));

        productsPage.accessMyCart();

        YourCartPage myCart = new YourCartPage((driver));
        assertThat(myCart.getBackpackFromCart(), equalTo("Sauce Labs Backpack"));
        assertThat(myCart.getBikeLightFromCart(), equalTo("Sauce Labs Bike Light"));
    }
}
