package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SauceLabsXPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class XTest extends TestBase {

    @Test
    public void canNavigateToSauceLabsXPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.accessX();

        Thread.sleep(6000);

        SauceLabsXPage xPage = new SauceLabsXPage(driver);
        assertThat(xPage.getPageTitle(), is("Sauce Labs (@saucelabs) / X"));
    }
}
