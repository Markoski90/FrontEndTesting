package sauceDemoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutYourInformationPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import static org.junit.Assert.assertTrue;

public class YourCartPageTests {
    private WebDriver driver;

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();
    }

    @Test
    public void continueShoppingButton(){
        productsPage.clickShoppingCart();
        yourCartPage.clickContinueShoppingButton();
        assertTrue(productsPage.isProductsPageDisplayed());
    }

    @Test
    public void checkoutButtonTest(){
        productsPage.clickShoppingCart();
        yourCartPage.clickCheckoutButton();
        assertTrue(checkoutYourInformationPage.isCheckoutYourInformationPageDisplayed());
    }


    @After
    public void tearDown() {
        driver.quit();
    }


}
