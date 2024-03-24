package sauceDemoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static org.junit.Assert.*;
public class CheckoutYourInformationTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private CheckoutYourInformationStepTwoPage checkoutYourInformationStepTwoPage;
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

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage.clickShoppingCart();
        yourCartPage.clickCheckoutButton();
    }
    //Successful buying product
    @Test
    public void successfulBuyingProduct(){
        checkoutYourInformationPage.enterFirstName("Daniel");
        checkoutYourInformationPage.enterLastName("Markoski");
        checkoutYourInformationPage.enterZipPostalCode("6000");
        checkoutYourInformationPage.clickContinueButton();
        assertTrue(checkoutYourInformationStepTwoPage.isCheckoutYourInformationPageTwoDisplayed());
    }
    //Cancel Button
    @Test
    public void cancelButton() {
        checkoutYourInformationPage.clickCancelButton();
        assertTrue(yourCartPage.isYourCartDisplayed());
    }
    //Error Message for FirstName
    @Test
    public void errorMessageForFirstname(){
        checkoutYourInformationPage.clickContinueButton();
        assertEquals("Error: First Name is required",checkoutYourInformationPage.getErrorMessage());
        checkoutYourInformationPage.clickXErrorButton();
        assertFalse(checkoutYourInformationPage.isErrorMessageDisplayed());
    }
    //Error Message for Lastname
    @Test
    public void errorMessageForLastname(){
        checkoutYourInformationPage.enterFirstName("Daniel");
        checkoutYourInformationPage.clickContinueButton();
        assertEquals("Error: Last Name is required",checkoutYourInformationPage.getErrorMessage());
        checkoutYourInformationPage.clickXErrorButton();
        assertFalse(checkoutYourInformationPage.isErrorMessageDisplayed());
    }
    //Error Message for ZIP PostalCode
    @Test
    public void errorMessageForPostalCode(){
        checkoutYourInformationPage.enterFirstName("Daniel");
        checkoutYourInformationPage.enterLastName("Markoski");
        checkoutYourInformationPage.clickContinueButton();
        assertEquals("Error: Postal Code is required",checkoutYourInformationPage.getErrorMessage());
        checkoutYourInformationPage.clickXErrorButton();
        assertFalse(checkoutYourInformationPage.isErrorMessageDisplayed());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
