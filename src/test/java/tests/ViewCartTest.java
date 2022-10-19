package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.NavigationPage;
import pages.ProductsPage;
import java.util.ArrayList;
import java.util.List;

public class ViewCartTest extends BaseTests{
    NavigationPage navigationPage;
    CartPage cartPage;
    @BeforeMethod
    public void addCartToItem(){
        navigationPage = new NavigationPage(driver);
        ProductsPage productsPage = navigationPage.clickProductsFromNavBar();
        ProductsPage.scrollFirstProduct();
        ProductsPage.addFirstProductToCart();
        cartPage= productsPage.clickViewCartLink();
    }
    @Test
    public void testCheckColumnsHeaders(){
        Assert.assertEquals(cartPage.getNumberOfHeaders(),6,"the number of headers equal 6");
        List<String>headers = new ArrayList<>();
        headers.add("item");
        headers.add("Description");
        headers.add("Price");
        headers.add("Quantity");
        headers.add("Total");
        headers.add("Remove");
        Assert.assertTrue(cartPage.getHeadersText(headers),"the header should be "+ headers);
    }
}
