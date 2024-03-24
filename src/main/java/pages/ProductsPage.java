package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
public class ProductsPage {
    private WebDriver driver;
    Actions actions;
    public ProductsPage(WebDriver driver){
        this.driver=driver;
        this.actions = new Actions(driver);
    }
    private By backpackTitleHover = By.className("inventory_item_name");
    private By productsTitle = By.className("title");
    private By addBackpackToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By RemoveBackpackButton = By.id("remove-sauce-labs-backpack");
    private By addBikelightToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By addFleeceJacketToCartButton = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By addFOnesieToCartButton = By.id("add-to-cart-sauce-labs-onesie");
    private  By addTshirtToCartButton = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    public By cartItemNumber = By.className("shopping_cart_badge");
    public By clickShoppingCart = By.id("shopping_cart_container");
    private By activeOptionText = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    private By activeOptionByNameText = By.className("inventory_item_name");

    public void clickAddBackpackToCartButton(){
        driver.findElement(addBackpackToCartButton).click();
    }
    public String RemoveBackpackToCartButtonText(){
        return driver.findElement(RemoveBackpackButton).getText();
    }
    public String AddBikeToCartButtonText(){
        return driver.findElement(addBikelightToCartButton).getText();
    }
    public void addBikeLightToCartButton(){
        driver.findElement(addBikelightToCartButton).click();
    }
    public void addFleeceJacketToCartButton(){
        driver.findElement(addFleeceJacketToCartButton).click();
    }
    public void addOnesieToCartButton(){
        driver.findElement(addFOnesieToCartButton).click();
    }
    public void addTshirtToCartButton(){
        driver.findElement(addTshirtToCartButton).click();
    }
    public List<WebElement> getAllOptionsFromDropDown() {
        Select dropdownElement = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        return dropdownElement.getOptions();
    }
    public void selectOrderingDropDownOption (int optionNumber){
        Select dropdownElement = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        if (optionNumber >= 0 && optionNumber <= 3) {
        dropdownElement.selectByIndex(optionNumber);
        } else {
            System.out.println("Invalid value");
              System.exit(1);
            }
        }
    public String getActiveOptionText(){
        return driver.findElement(activeOptionText).getText();
    }
    public String activeOptionByNameText(){
        return driver.findElement(activeOptionByNameText).getText();
    }
    public String getTextFromDropDown(){
        Select dropdownElement = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        return dropdownElement.getFirstSelectedOption().getText();
    }
    public void clickShoppingCart(){
        driver.findElement(clickShoppingCart).click();
    }
        public boolean isProductsPageDisplayed(){
        return driver.findElement(productsTitle).getText().equals("Products");
    }

    public String itemCountOnCart(){
        return driver.findElement(cartItemNumber).getText();
    }

    public void backpackTitleHoverElement(){
        WebElement backpackTitle = driver.findElement(backpackTitleHover);
        actions.moveToElement(backpackTitle).perform();
    }
    public String getColorFromBackpackTitle(){
        Color backpackTitleColor = Color.fromString(driver.findElement(backpackTitleHover).getCssValue("color"));
        return backpackTitleColor.asHex();
    }
}
