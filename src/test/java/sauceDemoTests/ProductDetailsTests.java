package sauceDemoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.junit.Assert.*;

public class ProductDetailsTests {
    String BikeItemDescription= "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private ProductDetailsPage productDetailsPage;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }
    //Click on item title to open page for item details
    @Test
    public void clickOnItemTitleForDetails(){
        yourCartPage.clickBikeTitle();
        assertEquals("Sauce Labs Bike Light",productDetailsPage.getTextFromBikeTitle());
        assertEquals(BikeItemDescription,productDetailsPage.getDescriptionFromBikeItem());
        assertEquals("$9.99",productDetailsPage.getPriceForBikeItem());
        productDetailsPage.clickAddToCartBikeItemButton();
        productDetailsPage.clickRemoveBikeItemButton();
        assertFalse(yourCartPage.isItemCartCountDisplayed());
    }
    //Back to product Button
    @Test
    public void clickBackToProductsButton(){
        yourCartPage.clickBikeTitle();
        productDetailsPage.clickBackToProductsButton();
        assertTrue(productsPage.isProductsPageDisplayed());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
