package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage{
    public NavigationPage(WebDriver driver) {
        super(driver);
    }
    private final By productBtn = By.xpath("//a[@href=\"/products\"]");
    public ProductsPage clickProductsFromNavBar() {
        clickElement(productBtn);
        return new ProductsPage(driver) ;
    }

}
