package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {
    private WebDriver driver;
    private By checkoutYourInformation = By.className("title");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipPostalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");
    private By xErrorMessageButton = By.className("error-button");
    private By errorMessage = By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3");
    public CheckoutYourInformationPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void enterLastName(String lastname){
        driver.findElement(lastNameField).sendKeys(lastname);
    }
    public void enterZipPostalCode(String postalCode){
        driver.findElement(zipPostalCode).sendKeys(postalCode);
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }
    public boolean isCheckoutYourInformationPageDisplayed(){
        return driver.findElement(checkoutYourInformation).getText().equals("Checkout: Your Information");
    }
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
    public void clickXErrorButton(){
        driver.findElement(xErrorMessageButton).click();
    }
    public boolean  isErrorMessageDisplayed() {
        try {
            driver.findElement(errorMessage).getText();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
