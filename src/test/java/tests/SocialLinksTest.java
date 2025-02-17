package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SauceLabsLinkedinPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SocialLinksTest extends TestBase {

    @Test
    public void canNavigateToSauceLabsLinkedinPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.accessLinkedIn();

        SauceLabsLinkedinPage linkedinPage = new SauceLabsLinkedinPage(driver);
        assertThat(linkedinPage.getPageTitle(), is("Sauce Labs | LinkedIn"));
    }
}
