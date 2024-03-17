package sauceDemoTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.*;
public class LoginPageTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    @Before
    public void setUp(){
        //Initialize ChromeDriver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }
    //Test: Successfull login
    @Test
    public void loginTest(){
        //Enter username and password
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");

        //Click on the login button
        loginPage.clickLoginButton();

        //Verify login successful
        assertTrue(productsPage.isProductsPageDisplayed());
    }
    //Test: Wrong user and wrong password
    @Test
    public void errorMessageTest(){
        loginPage.enterUserName("error_user");
        loginPage.enterPassword("error_password");
        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMessage());
    }
    //Test: locked_out_user and correct password*/
    @Test
    public void locked_out_userTest(){
        loginPage.enterUserName("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Sorry, this user has been locked out.",loginPage.getErrorMessage());
    }
    //Test: correct user and wrong password
    @Test
    public void invalidPasswordTest(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("wrong pass");
        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMessage());
    }
    //Test: invalid user and correct password
    @Test
    public void invalidUsernameTest(){
        loginPage.enterUserName("invalid_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMessage());
    }
    //Test: correct user and empty password field
    @Test
    public void emptyPasswordTest(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Password is required",loginPage.getErrorMessage());
    }
    //Test: empty user field and correct password
    @Test
    public void emptyUsernameTest(){
        loginPage.enterUserName("");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Username is required",loginPage.getErrorMessage());
    }
    //Test: Empty fields
    @Test
    public void emptyFieldsTest(){
        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Username is required",loginPage.getErrorMessage());
    }
    //Test: error message X button
    @Test
    public void errorMessageXButton(){
        loginPage.clickLoginButton();
        loginPage.clickxErrorButton();
        assertFalse(loginPage.isElementDisplayed());
    }
    //Test: Checking color,fontType,FontSize
    @Test
    public void loginFormInitialStateInterfaceTest(){
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif",loginPage.getUsernameFontType());
        assertEquals("14px",loginPage.getUsernameFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif",loginPage.getPasswordFontType());
        assertEquals("14px",loginPage.getPasswordFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif",loginPage.getLoginButtonFontType());
        assertEquals("16px",loginPage.getLoginButtonFontSize());
        assertEquals("#3ddc91",loginPage.getLoginButtonColor());
    }
    //Test: Checking error message background color,and border color
    @Test
    public void loginFormErrorStateInterfaceTest(){
        loginPage.clickLoginButton();
        assertEquals("#e2231a",loginPage.getErrorMessageBackgroundColor());
        assertEquals("#e2231a",loginPage.getUserNameBorderColor());
        assertEquals("#e2231a",loginPage.getPasswordBorderColor());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
