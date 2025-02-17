package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SauceLabsFacebookPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FacebookTest extends TestBase {

    @Test
    public void canNavigateToSauceLabsFacebookPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.accessFacebook();

        SauceLabsFacebookPage facebookPage = new SauceLabsFacebookPage(driver);
        assertThat(facebookPage.getPageUrl(), is("https://www.facebook.com/saucelabs"));
    }
}
