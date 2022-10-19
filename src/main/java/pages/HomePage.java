package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{


    public String category;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By featuredItems = By.cssSelector(".features_items > h2");


    public String getTextFeaturedItems ()
    {
        return getTextOfElement(featuredItems) ;
    }
}

