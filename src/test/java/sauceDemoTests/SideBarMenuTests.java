package sauceDemoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SideBarMenu;
import pages.YourCartPage;
import static org.junit.Assert.*;

public class SideBarMenuTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private SideBarMenu sideBarMenu;
    private YourCartPage yourCartPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        sideBarMenu = new SideBarMenu(driver);

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        sideBarMenu.clickBurgerMenuButton();
    }
    //Test: BurgerMenuButton and AllItems button functionality
    @Test
    public void burgerMenuButtonTest() throws InterruptedException {
        Thread.sleep(500); // needs more time to click x button to close menu
        assertTrue(sideBarMenu.isCrossMenuButtonDisplayed());
        assertTrue(sideBarMenu.isAllItemSelectionDisplayed());
        assertEquals("#18583a",sideBarMenu.getColorFromAllItemsTitle());
        sideBarMenu.allItemHoverButton();
        assertEquals("#3ddc91",sideBarMenu.getColorFromAllItemsTitle());
    }
    // Test: BurgerMenu About Button functionality

    @Test
    public void testAboutOptionRedirect() throws InterruptedException {
        Thread.sleep(200);
        assertEquals("#18583a",sideBarMenu.getColorFromAboutTitle());
        sideBarMenu.aboutHoverButton();
        assertEquals("#3ddc91",sideBarMenu.getColorFromAboutTitle());
        assertEquals("https://saucelabs.com/",sideBarMenu.getHrefFromAboutOption());
        sideBarMenu.clickAboutOption();
    }
    // Test: BurgerMenu Logout Button functionality
    @Test
    public void testLogoutOptionRedirect() throws InterruptedException {
        Thread.sleep(200);
        assertEquals("#18583a",sideBarMenu.getColorFromLogoutTitle());
        sideBarMenu.logoutHoverButton();
        assertEquals("#3ddc91",sideBarMenu.getColorFromLogoutTitle());
        sideBarMenu.clickLogoutOption();
        String expectedUrl = "https://www.saucedemo.com/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, expectedUrl);
    }
    //Test: BurgerMenu Reset Button functionality
    @Test
    public void testResetOptionRedirect() throws InterruptedException {
        Thread.sleep(200);
        productsPage.addBikeLightToCartButton();
        Thread.sleep(200);
        assertEquals("#18583a",sideBarMenu.getColorFromResetTitle());
        sideBarMenu.resetHoverButton();
        assertEquals("#3ddc91",sideBarMenu.getColorFromResetTitle());
        sideBarMenu.clickResetOption();
        assertFalse(yourCartPage.isItemCartCountDisplayed());
    }
    @After
    public void tearDown () {
        driver.quit();
    }
}
