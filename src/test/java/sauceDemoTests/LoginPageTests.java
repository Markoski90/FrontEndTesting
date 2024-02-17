package sauceDemoTests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPageTests {
    private WebDriver driver;

    private LoginPage loginPage;

    private ProductsPage productsPage;

    @Before
    public void setUp(){
        //Initialize ChromeDriver instance
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

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

    @Test
    public void errorMessageTest(){
        loginPage.enterUserName("sfdfdgdgf");
        loginPage.enterPassword("sfsdfsdf");

        //Click on the login button
        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMessage());
    }
    @Test
    public void invalidPasswordTest(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("sfsdfsdf");


        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMessage());
    }
    @Test
    public void invalidUsernameTest(){
        loginPage.enterUserName("standards_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMessage());
    }

    @Test
    public void emptyPasswordTest(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("");

        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Password is required",loginPage.getErrorMessage());
    }
    @Test
    public void emptyUsernameTest(){
        loginPage.enterUserName("");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Username is required",loginPage.getErrorMessage());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
