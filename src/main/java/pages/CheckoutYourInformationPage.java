package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {
    private WebDriver driver;

    private By productsTitle = By.className("title");



    public CheckoutYourInformationPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isCheckoutYourInformationPageDisplayed(){
        return driver.findElement(productsTitle).getText().equals("Checkout: Your Information");
    }

}
