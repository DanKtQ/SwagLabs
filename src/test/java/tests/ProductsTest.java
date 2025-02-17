package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductsTest extends TestBase {

    @Test
    public void productPicturesAreAllDogsOnProblemUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("problem_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        String actualImageSrc = productsPage.getProductPicture();
        String expectedImageSrc = "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg";

        assertNotEquals(expectedImageSrc, actualImageSrc, "The product picture is incorrect");
        System.out.println("Negative Test OK: The dog image is different than the product picture.");
    }

    @Test
    public void addOneItemToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        assertEquals("Products", productsPage.getPageTitle());

        productsPage.addToCartBackpack();
        assertThat(productsPage.getShoppingCartQuantity(), equalTo(1));
    }

    @Test
    public void addTwoItemsToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        assertEquals("Products", productsPage.getPageTitle());

        productsPage.addToCartBackpack();
        productsPage.addToCartBikeLight();
        assertThat(productsPage.getShoppingCartQuantity(), equalTo(2));
    }

    @Test
    public void canAddProductsToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCartProductWithIndex(0);
        productsPage.addToCartProductWithIndex(2);
        assertThat(productsPage.getShoppingCartQuantity(), equalTo(2));
    }
}