package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    final ThreadLocal<NavigationPage> navigationPage;

    private final By searchedProduct = By.cssSelector(".features_items>h2");
    private final By allProducts = By.cssSelector("[class=\"features_items\"]");
    private static final By firstProducts = By.xpath("(//div@[class=\"productinfo text-center\"])[1]");
    private static final By secondProduct = By.xpath("(//div@[class=\"productinfo text-center\"])[2]");

    private static final By addFirstProductToCart = By.xpath("//div@[class=\"productinfo text-center\"]/a)[1]");
    private static final By addToCartBtnOfSecondProduct = By.xpath("//div@[class=\"productinfo text-center\"]/a)[1]");

    private final By continueShoppingBtn = By.cssSelector(".btn-success >h2");
    private final By viewCartLink = By.xpath("//p[@class=\"text-center\"]/a");


    public ProductsPage(WebDriver driver) {
        super(driver);
        navigationPage = new ThreadLocal<>();
    }

    @Override
    public void scrollToElement(By elementLocator) {
        super.scrollToElement(elementLocator);
    }

    public String searchedProduct(){return getTextOfElement(searchedProduct);}
    public String allProducts(){return getTextOfElement(allProducts);}
    public static void scrollFirstProduct(){
        scrollingProductPageV(500);
    }

    public static void addFirstProductToCart(){
        hoverOverElement(firstProducts);
        forceClickOnElement(addFirstProductToCart);
}
   public ProductsPage clickContinueShoppingBtn(){
        clickElement(continueShoppingBtn);
        return new ProductsPage(driver);
   }
   public CartPage clickViewCartLink(){
        clickElement(viewCartLink);
        return new CartPage(driver);
   }
    public void addSecondProductToCart() {
        hoverOverElement(secondProduct);
        forceClickOnElement(addToCartBtnOfSecondProduct);
    }

}
