package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage{
        String productName ="Blue Top";
        private final By searchErrorMessage = By.id("");
        private final By searchField = By.id("search_product");
        private final By searchBtn = By.cssSelector(".container>button");
        private final By searchedProduct = By.cssSelector(".features_items>h2");
        private static final By modalContent = By.xpath("//div@[class=\"productinfo text-center\"]//p[contains(text(),'Top')]");
        private final By firstProduct = By.xpath("(//div@[class=\"productinfo text-center\"])[1]");
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public ProductsPage productSearch(String searchTextBOX)

    {
        typeOnInputField(searchField,searchTextBOX);
        clickElement(searchBtn);
        return new ProductsPage(driver);
    }
        public String searchedProduct(){ return getTextOfElement(searchedProduct);}
        public static int getModalContent()
        {
            List<WebElement> modalContentItems = locateListOfElement(modalContent);
            return modalContentItems.size();
        }
        public String getEmptySearchErrorMessage(){
        return getTextOfElement(searchErrorMessage);
        }

        public By getFirstProduct() {
        return firstProduct;
    }
}


