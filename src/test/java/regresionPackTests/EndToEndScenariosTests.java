package regresionPackTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;
import pages.*;

import static org.junit.Assert.*;


public class EndToEndScenariosTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private CheckoutYourInformationStepTwoPage checkoutYourInformationStepTwoPage;
    private CheckoutCompletePage checkoutCompletePage;
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
        checkoutYourInformationStepTwoPage = new CheckoutYourInformationStepTwoPage(driver);
         checkoutCompletePage = new CheckoutCompletePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
    }
    // Successfully buying
    @Test
    public void SuccessfullyBuying() {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.addOnesieToCartButton();
        productsPage.addBikeLightToCartButton();
        productsPage.addFleeceJacketToCartButton();
        productsPage.clickShoppingCart();
        yourCartPage.itemCountOnCart();
        assertEquals("3",yourCartPage.itemCountOnCart());
        yourCartPage.clickCheckoutButton();
        checkoutYourInformationPage.enterFirstName("Daniel");
        checkoutYourInformationPage.enterLastName("Markoski");
        checkoutYourInformationPage.enterZipPostalCode("6000");
        checkoutYourInformationPage.clickContinueButton();
        checkoutYourInformationStepTwoPage.clickFinishButton();
        assertTrue(checkoutCompletePage.isCheckoutCompletePageDisplayed());

    }
    // Canceled buy
    @Test
    public void CanceledBuy(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.addOnesieToCartButton();
        productsPage.addBikeLightToCartButton();
        productsPage.addFleeceJacketToCartButton();
        productsPage.clickShoppingCart();
        yourCartPage.itemCountOnCart();
        assertEquals("3",yourCartPage.itemCountOnCart());
        yourCartPage.clickCheckoutButton();
        checkoutYourInformationPage.enterFirstName("Daniel");
        checkoutYourInformationPage.enterLastName("Markoski");
        checkoutYourInformationPage.enterZipPostalCode("6000");
        checkoutYourInformationPage.clickContinueButton();
        checkoutYourInformationStepTwoPage.clickCancelButton();
        assertTrue(productsPage.isProductsPageDisplayed());
    }
    //Selection of multiple items (5) and removing some of them from the Cart (2)
        @Test
        public void SelectAndRemoveSomeItemsTest(){
            loginPage.enterUserName("standard_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLoginButton();
            productsPage.addOnesieToCartButton();
            productsPage.addBikeLightToCartButton();
            productsPage.addFleeceJacketToCartButton();
            productsPage.addTshirtToCartButton();
            productsPage.clickAddBackpackToCartButton();
            productsPage.clickShoppingCart();
            yourCartPage.itemCountOnCart();
            assertEquals("5",yourCartPage.itemCountOnCart());
            yourCartPage.clickRemoveBikeRemoveButton();
            yourCartPage.clickRemoveJacketRemoveButton();
            assertEquals("3",yourCartPage.itemCountOnCart());
            yourCartPage.clickCheckoutButton();
            checkoutYourInformationPage.enterFirstName("Daniel");
            checkoutYourInformationPage.enterLastName("Markoski");
            checkoutYourInformationPage.enterZipPostalCode("6000");
            checkoutYourInformationPage.clickContinueButton();
            checkoutYourInformationStepTwoPage.clickFinishButton();
            assertTrue(checkoutCompletePage.isCheckoutCompletePageDisplayed());
        }
        /*Selection and review of multiple items (4) and removing some (1) directly from the
         inventory item (when the user clicks on the item on the Products page)*/
        @Test
        public void RemoveSomeItemFromInventoryTest()  {
            loginPage.enterUserName("standard_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLoginButton();
            productsPage.addOnesieToCartButton();
            productsPage.addBikeLightToCartButton();
            productsPage.addFleeceJacketToCartButton();
            productsPage.addTshirtToCartButton();
            yourCartPage.itemCountOnCart();
            assertEquals("4",yourCartPage.itemCountOnCart());
            yourCartPage.clickBikeTitle();
            productDetailsPage.clickRemoveBikeItemButton();
            productDetailsPage.clickBackToProductsButton();
            yourCartPage.itemCountOnCart();
            assertEquals("3",yourCartPage.itemCountOnCart());
            assertEquals("Add to cart",productsPage.AddBikeToCartButtonText());
            productsPage.clickShoppingCart();
            yourCartPage.clickCheckoutButton();
            checkoutYourInformationPage.enterFirstName("Daniel");
            checkoutYourInformationPage.enterLastName("Markoski");
            checkoutYourInformationPage.enterZipPostalCode("6000");
            checkoutYourInformationPage.clickContinueButton();
            checkoutYourInformationStepTwoPage.clickFinishButton();
            assertTrue(checkoutCompletePage.isCheckoutCompletePageDisplayed());
        }
        //Selection of multiple items and going back to shopping from Your cart
        @Test
        public void AddItemsToCartAndAddMoreItemsTest(){
            loginPage.enterUserName("standard_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLoginButton();
            productsPage.addOnesieToCartButton();
            productsPage.addBikeLightToCartButton();
            productsPage.addFleeceJacketToCartButton();
            productsPage.clickShoppingCart();
            yourCartPage.itemCountOnCart();
            assertEquals("3",yourCartPage.itemCountOnCart());
            yourCartPage.clickContinueShoppingButton();
            productsPage.clickAddBackpackToCartButton();
            yourCartPage.itemCountOnCart();
            assertEquals("4",yourCartPage.itemCountOnCart());
            productsPage.clickShoppingCart();
            yourCartPage.clickCheckoutButton();
            checkoutYourInformationPage.enterFirstName("Daniel");
            checkoutYourInformationPage.enterLastName("Markoski");
            checkoutYourInformationPage.enterZipPostalCode("6000");
            checkoutYourInformationPage.clickContinueButton();
            checkoutYourInformationStepTwoPage.clickFinishButton();
            assertTrue(checkoutCompletePage.isCheckoutCompletePageDisplayed());
        }
        //Selection of multiple items and going back to Your Cart from Checkout: Your Information page
        @Test
        public void SelectMultipleItemAndGoBackToYourCartTest(){
            loginPage.enterUserName("standard_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLoginButton();
            productsPage.addOnesieToCartButton();
            productsPage.addBikeLightToCartButton();
            productsPage.addFleeceJacketToCartButton();
            productsPage.clickShoppingCart();
            yourCartPage.itemCountOnCart();
            assertEquals("3",yourCartPage.itemCountOnCart());
            yourCartPage.clickCheckoutButton();
            checkoutYourInformationPage.clickCancelButton();
            assertTrue(yourCartPage.isYourCartDisplayed());
            yourCartPage.clickCheckoutButton();
            checkoutYourInformationPage.enterFirstName("Daniel");
            checkoutYourInformationPage.enterLastName("Markoski");
            checkoutYourInformationPage.enterZipPostalCode("6000");
            checkoutYourInformationPage.clickContinueButton();
            checkoutYourInformationStepTwoPage.clickFinishButton();
            assertTrue(checkoutCompletePage.isCheckoutCompletePageDisplayed());
        }

        @After
        public void tearDown() {
            driver.quit();
        }
}

