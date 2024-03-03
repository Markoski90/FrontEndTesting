package sauceDemoTests;

import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;




public class LoginPageParametirizedTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;


    @ParameterizedTest
    @ValueSource(strings = {"wrong_user","standard_user"})
    public void errorMessageInvalidUserAndPassword(String username){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");

            loginPage = new LoginPage(driver);
            productsPage = new ProductsPage(driver);

            loginPage.enterUserName(username);
            loginPage.enterPassword("wrong_pass");

            loginPage.clickLoginButton();


        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getErrorMessage());
    }
    @After
    public void tearDown () {
        driver.quit();
    }

}
