package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CheckoutCompletePage {
    private WebDriver driver;
    private By checkoutComplete = By.className("title");
    private By backHomeButton = By.id("back-to-products");
    public CheckoutCompletePage (WebDriver driver){
        this.driver = driver;
    }
    public void clickBackHomeButton(){
        driver.findElement(backHomeButton).click();
    }
    public boolean isCheckoutCompletePageDisplayed(){
        return driver.findElement(checkoutComplete).getText().equals("Checkout: Complete!");
    }
}
