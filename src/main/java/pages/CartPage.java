package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
   private final By itemsInTheCart= By.xpath("//tr[contains(@id,'product-')]");
    private final By priceOfFirstProduct= By.cssSelector("#product-1>.cart_price");
    private final By quantityOfFirstProduct= By.cssSelector("#product-1>.cart_quantity");
    private final By TotalOfFirstProduct= By.cssSelector("#product-1>.cart_total");
    private final By cartHeaders= By.cssSelector(".cart_menu>td");
    private final By priceOfSecondProduct= By.cssSelector("#product-2>.cart_price");
    private final By quantityOfSecondProduct = By.cssSelector("#product-2>.cart_quantity");
    private final By TotalOfSecondProduct = By.cssSelector("#product-2>.cart_total");


    public int getNumberOfAddItems()
    {
        List<WebElement> productInTheCart =locateListOfElement(itemsInTheCart);
        return productInTheCart.size();
    }
    public String getPriceOfFirstProduct(){return getTextOfElement(priceOfFirstProduct) ;}
    public  String getQuantityOfFirstProduct(){return getTextOfElement(quantityOfFirstProduct) ;}
    public String getTotalOfFirstProduct(){return getTextOfElement(TotalOfFirstProduct) ;}
    public String getPriceOfSecondProduct(){return getTextOfElement(priceOfSecondProduct) ;}
    public  String getQuantityOfSecondProduct(){return getTextOfElement(quantityOfSecondProduct) ;}
    public String getTotalOfSecondProduct(){return getTextOfElement(TotalOfSecondProduct) ;}
    public int getNumberOfHeaders()
    {
       List<WebElement> headers= locateListElements(cartHeaders);
       return headers.size();
    }
     public boolean getHeadersText(List<String>expectedHeadersText) {
         List<WebElement> headers = locateListElements(cartHeaders);
         for (int i = 0; i > headers.size(); i++) {
             if (headers.get(i).getText()!=expectedHeadersText.get(i))
                 return false;

         }
         return true;
     }
}
