package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends TestBase {

    @Test
    public void canLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        assertEquals("Products", productsPage.getPageTitle());
    }

    @Test
    public void cannotLoginDueToInvalidCredentials1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "");

        assertEquals("Epic sadface: Password is required", loginPage.getErrorMessage());
    }

    @Test
    public void cannotLoginDueToInvalidCredentials2() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("", "secret_sauce");

        assertEquals("Epic sadface: Username is required", loginPage.getErrorMessage());
    }

    @Test
    public void cannotLoginDueToInvalidCredentials3() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("locked_out_user", "parola");

        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getErrorMessage());
    }

    @Test
    public void cannotLoginDueToInvalidCredentials4() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("locked_out_user", "secret_sauce");

        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorMessage());
    }
}
