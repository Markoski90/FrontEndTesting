package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ProductDetailsPage {
    private WebDriver driver;
    private By ProductDetails = By.id("back-to-products");
    private By backToProductsButton = By.id("back-to-products");
    private By bikeItemTitle = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
    private By bikeItemDescription = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]");
    private By bikeItemPrice = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]");
    private By addToCartBikeItemButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By removeBikeItemButton = By.id("remove-sauce-labs-bike-light");
    public ProductDetailsPage (WebDriver driver){
        this.driver=driver;
    }
    public String getTextFromBikeTitle(){
        return driver.findElement(bikeItemTitle).getText();
    }
    public String getDescriptionFromBikeItem(){
        return driver.findElement(bikeItemDescription).getText();
    }
    public String getPriceForBikeItem(){
        return driver.findElement(bikeItemPrice).getText();
    }
    public void clickAddToCartBikeItemButton(){
        driver.findElement(addToCartBikeItemButton).click();
    }
    public void clickRemoveBikeItemButton(){
        driver.findElement(removeBikeItemButton).click();
    }
    public void clickBackToProductsButton(){
        driver.findElement(backToProductsButton).click();
    }
    public boolean isProductDetailsDisplayed(){
        return driver.findElement(ProductDetails).getText().equals("Back to products");
    }
}
