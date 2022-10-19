package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.NavigationPage;
import pages.ProductsPage;

public class AddToCartTest extends BaseTests {
    NavigationPage navigationPage;

    @Test
    public void testAddToCart() {
        navigationPage = new NavigationPage(driver);
        ProductsPage productsPage = navigationPage.clickProductsFromNavBar();
        ProductsPage.scrollFirstProduct();
        ProductsPage.addFirstProductToCart();
        CartPage cartPage = productsPage.clickContinueShoppingBtn().clickViewCartLink();
        Assert.assertEquals(cartPage.getNumberOfAddItems(), "1", "the number added should be 1");
        Assert.assertEquals(cartPage.getPriceOfFirstProduct(), "Rs. 500", "the price should Rs. 500");
        Assert.assertEquals(cartPage.getQuantityOfFirstProduct(), "1", "the Quantity should 1");
        Assert.assertEquals(cartPage.getTotalOfFirstProduct(), "Rs. 500", "the total should Rs. 500");
    }

    @Test
    public void testAddMultipleItemToCart() {
        navigationPage = new NavigationPage(driver);
        ProductsPage productsPage = navigationPage.clickProductsFromNavBar();
        ProductsPage.scrollFirstProduct();
        ProductsPage.addFirstProductToCart();
        CartPage cartPage = productsPage.clickContinueShoppingBtn().clickViewCartLink();
        Assert.assertEquals(cartPage.getNumberOfAddItems(), "1", "the number added should be 1");
        Assert.assertEquals(cartPage.getPriceOfSecondProduct(), "Rs. 500", "the price should Rs. 500");
        Assert.assertEquals(cartPage.getQuantityOfSecondProduct(), "2", "the Quantity should 2");
        Assert.assertEquals(cartPage.getTotalOfSecondProduct(), "Rs. 1000", "the total should Rs. 1000");
    }
}
