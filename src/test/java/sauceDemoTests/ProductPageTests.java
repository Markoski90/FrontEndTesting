package sauceDemoTests;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;
import java.util.List;
import static org.junit.Assert.*;
public class ProductPageTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }
    //Test: na addToCart i Remove kopce
    @Test
    public void addAndRemoveToCartButtonTest() {
        productsPage.clickAddBackpackToCartButton();
        assertEquals("Remove", productsPage.RemoveBackpackToCartButtonText());
    }
    //Test: Klikame addToCart i dali ke ni se prikaze crvenoto krugce na add to cart ikonata
    @Test
    public void addToCartButton() {
        productsPage.clickAddBackpackToCartButton();
        boolean isShoppingCartDisplayed = driver.findElement(productsPage.cartItemNumber).isDisplayed();
        assertTrue(isShoppingCartDisplayed);
    }
    /*Test: Klikame na addToCart na dva proizvodi i
    sporeduvame dali brojot vo addToCart ikonceto ni e ednakov na izbranite proizvodi*/
    @Test
    public void addTwoItemsOnShoppingCart() {
        productsPage.addBikeLightToCartButton();
        productsPage.addFleeceJacketToCartButton();
        assertEquals("2",productsPage.itemCountOnCart());
    }
    //Test dropDown menu
    @Test
    public void orderingDropDownTest(){
        ProductsPage productPage = new ProductsPage(driver);
        List<WebElement> options = productPage.getAllOptionsFromDropDown();
        assertEquals("Name (A to Z)", options.get(0).getText());
        assertEquals("Name (Z to A)", options.get(1).getText());
        assertEquals("Price (low to high)", options.get(2).getText());
        assertEquals("Price (high to low)", options.get(3).getText());
    }
    //Test: Price (high to low) option
    @Test
    public void mostExpensivePriceTest(){
        productsPage.selectOrderingDropDownOption(3);
        assertEquals("$49.99",productsPage.getActiveOptionText());
        assertEquals("Price (high to low)",productsPage.getTextFromDropDown());
    }
    //Test: Price (low to high) option
    @Test
    public void mostCheapestPriceTest() {
        productsPage.selectOrderingDropDownOption(2);
        assertEquals("$7.99", productsPage.getActiveOptionText());
        assertEquals("Price (low to high)", productsPage.getTextFromDropDown());
    }
    //Test: Name (A to Z) option
    @Test
    public void sortItemsFromAtoZTest() {
        productsPage.selectOrderingDropDownOption(0);
        assertEquals("Sauce Labs Backpack", productsPage.activeOptionByNameText());
        assertEquals("Name (A to Z)", productsPage.getTextFromDropDown());
    }
    //Test: Name (Z to A) option
    @Test
    public void sortItemsFromZtoATest() {
        productsPage.selectOrderingDropDownOption(1);
        assertEquals("Test.allTheThings() T-Shirt (Red)", productsPage.activeOptionByNameText());
        assertEquals("Name (Z to A)", productsPage.getTextFromDropDown());
    }
    //Test: BurgerMenuButton functionality
    @SneakyThrows
    @Test
    public void burgerMenuButtonTest() {
        productsPage.clickBurgerMenuButton();
            Thread.sleep(5000); // 5 seconds
        assertTrue(productsPage.isCrossMenuButtonDisplayed());
        assertTrue(productsPage.isAllItemSelectionDisplayed());
    }
    /*Hover on some Item */
    //In progress
    @After
        public void tearDown () {
            driver.quit();
        }
}