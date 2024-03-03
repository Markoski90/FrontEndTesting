package sauceDemoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.junit.Assert.*;
public class YourCartPageTests {
    String descriptionTextForJacketItem = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
    String descriptionTextForOnesieItem = "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.";
    String descriptionTextForBikeItem = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private ProductDetailsPage productDetailsPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }
    //Continue Shopping Button
    @Test
    public void continueShoppingButton(){
        productsPage.clickShoppingCart();
        yourCartPage.clickContinueShoppingButton();
        assertTrue(productsPage.isProductsPageDisplayed());
    }
    //Checkout Button
    @Test
    public void checkoutButtonTest(){
        productsPage.clickShoppingCart();
        yourCartPage.clickCheckoutButton();
        assertTrue(checkoutYourInformationPage.isCheckoutYourInformationPageDisplayed());
    }
    //Checkout Button checking color,font,size
    @Test
    public void CheckoutButtonStyle(){
        productsPage.clickShoppingCart();
        assertEquals("#3ddc91",yourCartPage.getCheckoutButtonColor());
        assertEquals("\"DM Sans\", sans-serif",yourCartPage.getCheckoutButtonFontType());
        assertEquals("16px",yourCartPage.getCheckoutButtonFontSize());
    }
    //Remove button color,font,size
    @Test
    public void RemoveButtonStyle(){
        productsPage.addBikeLightToCartButton();
        productsPage.clickShoppingCart();
        assertEquals("#e2231a",yourCartPage.getRemoveButtonColor());
        assertEquals("\"DM Sans\", sans-serif",yourCartPage.getRemoveButtonFontType());
        assertEquals("16px",yourCartPage.getRemoevButtonFontSize());
    }
    //Adding item on cart check values and remove it
    @Test
    public void addItemToYourCartAndRemoveIt(){
        productsPage.addFleeceJacketToCartButton();
        productsPage.clickShoppingCart();
        assertEquals("1",yourCartPage.itemCountOnCart());
        assertEquals("Sauce Labs Fleece Jacket",yourCartPage.getTextFromJacketTitle());
        assertEquals(descriptionTextForJacketItem,yourCartPage.getDescriptionFromJacketItem());
        assertEquals("$49.99",yourCartPage.getPriceForJacketItem());
        assertEquals("Remove",yourCartPage.getTextForJacketItemRemoveButton());
        yourCartPage.clickRemoveJacketRemoveButton();
        assertFalse(yourCartPage.isJacketItemDisplayed());
        assertFalse(yourCartPage.isItemCartCountDisplayed());
     }
     //Add two items on cart check values and remove one of them
    @Test
    public void addTwoItemsToYourCart(){
        productsPage.addOnesieToCartButton();
        productsPage.addBikeLightToCartButton();
        productsPage.clickShoppingCart();
        assertEquals("2",productsPage.itemCountOnCart());
        assertEquals("Sauce Labs Bike Light",yourCartPage.getTextFromBikeTitle());
        assertEquals(descriptionTextForBikeItem,yourCartPage.getDescriptionFromBikeItem());
        assertEquals("$9.99",yourCartPage.getPriceForBikeItem());

        assertEquals("Sauce Labs Onesie",yourCartPage.getTextFromOnesieTitle());
        assertEquals(descriptionTextForOnesieItem,yourCartPage.getDescriptionFromOnesieItem());
        assertEquals("$7.99",yourCartPage.getPriceForOnesieItem());

        yourCartPage.clickRemoveBikeRemoveButton();
        assertFalse(yourCartPage.isBikeItemDisplayed());
        assertEquals("1",yourCartPage.itemCountOnCart());
    }
    //Back to product page button
    @Test
    public void backToProductsPage(){
        yourCartPage.clickBikeTitle();
        assertTrue(productDetailsPage.isProductDetailsDisplayed());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}