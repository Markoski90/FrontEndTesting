package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CheckoutYourInformationStepTwoPage {
    private WebDriver driver;
    private By checkoutYourInformationStepTwo = By.className("title");
    private By finishButton = By.id("finish");
    private By cancelButton = By.id("cancel");
    public CheckoutYourInformationStepTwoPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }
    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }
    public boolean isCheckoutYourInformationPageTwoDisplayed(){
        return driver.findElement(checkoutYourInformationStepTwo).getText().equals("Checkout: Overview");
    }
}
