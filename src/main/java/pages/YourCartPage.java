package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
public class YourCartPage {
    private WebDriver driver;
    private By yourCart = By.className("title");
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private By jacketTitle = By.id("item_5_title_link");
    private By descriptionForJacketItem = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]");
    private By priceForJacketItem = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private By jacketItemRemoveButton = By.id("remove-sauce-labs-fleece-jacket");
    private By bikeTitle = By.id("item_0_title_link");
    private By descriptionForBikeItem = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[1]");
    private By priceForBikeItem = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div");
    private By bikeItemRemoveButton = By.id("remove-sauce-labs-bike-light");
    private By onesieItemTitle = By.id("item_2_title_link");
    private By descriptionForOnesieItem = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]");
    private By priceForOnesieItem = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private By cartItemNumber = By.className("shopping_cart_badge");

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isYourCartDisplayed() {
        return driver.findElement(yourCart).getText().equals("Your Cart");
    }

    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void clickBikeTitle() {
        driver.findElement(bikeTitle).click();
    }

    public String getTextFromJacketTitle() {
        return driver.findElement(jacketTitle).getText();
    }

    public String getDescriptionFromJacketItem() {
        return driver.findElement(descriptionForJacketItem).getText();
    }

    public String getPriceForJacketItem() {
        return driver.findElement(priceForJacketItem).getText();
    }

    public String getTextFromOnesieTitle() {
        return driver.findElement(onesieItemTitle).getText();
    }

    public String getDescriptionFromOnesieItem() {
        return driver.findElement(descriptionForOnesieItem).getText();
    }

    public String getPriceForOnesieItem() {
        return driver.findElement(priceForOnesieItem).getText();
    }

    public String getTextFromBikeTitle() {
        return driver.findElement(bikeTitle).getText();
    }

    public String getDescriptionFromBikeItem() {
        return driver.findElement(descriptionForBikeItem).getText();
    }

    public String getPriceForBikeItem() {
        return driver.findElement(priceForBikeItem).getText();
    }

    public void clickRemoveJacketRemoveButton() {
        driver.findElement(jacketItemRemoveButton).click();
    }

    public void clickRemoveBikeRemoveButton() {
        driver.findElement(bikeItemRemoveButton).click();
    }

    public String getTextForJacketItemRemoveButton() {
        return driver.findElement(jacketItemRemoveButton).getText();
    }

    public boolean isJacketItemDisplayed() {
        try {
            driver.findElement(jacketTitle).getText();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isBikeItemDisplayed() {
        try {
            driver.findElement(bikeTitle).getText();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isItemCartCountDisplayed() {
        try {
            driver.findElement(cartItemNumber).getText();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String itemCountOnCart() {
        return driver.findElement(cartItemNumber).getText();
    }

    public String getCheckoutButtonColor() {
        Color backgroundLoiginButtonColor = Color.fromString(driver.findElement(checkoutButton).getCssValue("background-color"));
        return backgroundLoiginButtonColor.asHex();
    }

    public String getCheckoutButtonFontSize() {
        return driver.findElement(checkoutButton).getCssValue("font-size");
    }

    public String getCheckoutButtonFontType() {
        return driver.findElement(checkoutButton).getCssValue("font-family");
    }

    public String getRemoveButtonColor() {
        Color backgroundLoiginButtonColor = Color.fromString(driver.findElement(bikeItemRemoveButton).getCssValue("color"));
        return backgroundLoiginButtonColor.asHex();
    }

    public String getRemoevButtonFontSize() {
        return driver.findElement(bikeItemRemoveButton).getCssValue("font-size");
    }

    public String getRemoveButtonFontType() {
        return driver.findElement(bikeItemRemoveButton).getCssValue("font-family");
    }
}