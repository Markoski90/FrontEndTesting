package sauceDemoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.junit.Assert.assertTrue;
public class CheckoutCompleteTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private CheckoutYourInformationStepTwoPage checkoutYourInformationStepTwoPage;
    private CheckoutCompletePage checkoutCompletePage;
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
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickShoppingCart();
        yourCartPage.clickCheckoutButton();
        checkoutYourInformationPage.enterFirstName("Daniel");
        checkoutYourInformationPage.enterLastName("Markoski");
        checkoutYourInformationPage.enterZipPostalCode("6000");
        checkoutYourInformationPage.clickContinueButton();
        checkoutYourInformationStepTwoPage.clickFinishButton();
    }
    //Click BackHome button and return to products page
    @Test
    public void clickCancelButton(){
        checkoutCompletePage.clickBackHomeButton();
        assertTrue(productsPage.isProductsPageDisplayed());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
