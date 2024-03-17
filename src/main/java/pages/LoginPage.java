package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By xErrorMessageButton = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button");
    private By errorMessageContainer = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");
    private By errorMsg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUserName(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void clickxErrorButton(){
        driver.findElement(xErrorMessageButton).click();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMsg).getText();
    }
    public boolean  isElementDisplayed() {
        try {
            driver.findElement(errorMsg).getText();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public String getUsernameFontType(){
        return driver.findElement(usernameField).getCssValue("font-family");
    }
    public String getUsernameFontSize(){
        return driver.findElement(usernameField).getCssValue("font-size");
    }
    public String getPasswordFontType(){
        return driver.findElement(passwordField).getCssValue("font-family");
    }
    public String getPasswordFontSize(){
        return driver.findElement(passwordField).getCssValue("font-size");
    }
    public String getLoginButtonColor(){
        Color backgroundLoiginButtonColor = Color.fromString(driver.findElement(loginButton).getCssValue("background-color"));
        return backgroundLoiginButtonColor.asHex();
    }
    public String getErrorMessageBackgroundColor(){
        Color backgroundLoiginButtonColor = Color.fromString(driver.findElement(errorMessageContainer).getCssValue("background-color"));
        return backgroundLoiginButtonColor.asHex();
    }
    public String getUserNameBorderColor(){
        Color backgroundLoiginButtonColor = Color.fromString(driver.findElement(usernameField).getCssValue("border-bottom-color"));
        return backgroundLoiginButtonColor.asHex();
    }
    public String getPasswordBorderColor(){
        Color backgroundLoiginButtonColor = Color.fromString(driver.findElement(passwordField).getCssValue("border-bottom-color"));
        return backgroundLoiginButtonColor.asHex();
    }
    public String getLoginButtonFontSize(){
        return driver.findElement(loginButton).getCssValue("font-size");
    }
    public String getLoginButtonFontType(){
        return driver.findElement(loginButton).getCssValue("font-family");
    }

}
