package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
public class SideBarMenu {
    private WebDriver driver;
    Actions actions;
    public SideBarMenu (WebDriver driver){
        this.driver=driver;
        this.actions = new Actions(driver);
    }
    private By clickBurgerMenuButton = By.id("react-burger-menu-btn");
    private By allItemsSelectionButton = By.id("inventory_sidebar_link");
    private By aboutItemSelectionButton = By.id("about_sidebar_link");
    private By logOutSelectionButton = By.id("logout_sidebar_link");
    private By resetSelectionButton = By.id("reset_sidebar_link");
    private By crossMenuButton = By.id("react-burger-cross-btn");

    public void clickBurgerMenuButton() {
        driver.findElement(clickBurgerMenuButton).click();
    }
    public boolean isAllItemSelectionDisplayed(){
        return driver.findElement(allItemsSelectionButton).getText().equals("All Items");
    }
    public boolean isCrossMenuButtonDisplayed() {
        return driver.findElement(crossMenuButton).isDisplayed();
    }
    public void clickAboutOption() {
        WebElement aboutSidebarButton = driver.findElement(aboutItemSelectionButton);
        aboutSidebarButton.click();
    }
    public void clickLogoutOption() {
        WebElement logoutSidebarButton = driver.findElement(logOutSelectionButton);
        logoutSidebarButton.click();
    }
    public void clickResetOption() {
        WebElement resetSidebarButton = driver.findElement(resetSelectionButton);
        resetSidebarButton.click();
    }
    public void allItemHoverButton(){
        WebElement allItemButtonTextHover = driver.findElement(allItemsSelectionButton);
        actions.moveToElement(allItemButtonTextHover).perform();
    }
    public void aboutHoverButton(){
        WebElement aboutButtonTextHover = driver.findElement(aboutItemSelectionButton);
        actions.moveToElement(aboutButtonTextHover).perform();
    }
    public void logoutHoverButton(){
        WebElement logoutButtonTextHover = driver.findElement(logOutSelectionButton);
        actions.moveToElement(logoutButtonTextHover).perform();
    }
    public void resetHoverButton(){
        WebElement resetButtonTextHover = driver.findElement(resetSelectionButton);
        actions.moveToElement(resetButtonTextHover).perform();
    }
    public String getColorFromAllItemsTitle(){
        Color allItemsTitleColor = Color.fromString(driver.findElement(allItemsSelectionButton).getCssValue("color"));
        return allItemsTitleColor.asHex();
    }
    public String getColorFromAboutTitle(){
        Color aboutTitleColor = Color.fromString(driver.findElement(aboutItemSelectionButton).getCssValue("color"));
        return aboutTitleColor.asHex();
    }
    public String getColorFromLogoutTitle(){
        Color logoutTitleColor = Color.fromString(driver.findElement(logOutSelectionButton).getCssValue("color"));
        return logoutTitleColor.asHex();
    }
    public String getColorFromResetTitle(){
        Color resetTitleColor = Color.fromString(driver.findElement(resetSelectionButton).getCssValue("color"));
        return resetTitleColor.asHex();
    }
    public String getHrefFromAboutOption(){
        WebElement aboutHrefElement = driver.findElement(aboutItemSelectionButton);
        return aboutHrefElement.getAttribute("href");
    }
}
