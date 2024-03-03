package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage {
    private WebDriver driver;

    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");

    public YourCartPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickContinueShoppingButton(){
        driver.findElement(continueShoppingButton).click();
    }
    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }

}
