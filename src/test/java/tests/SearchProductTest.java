package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NavigationPage;
import pages.ProductsPage;
import pages.SearchPage;

import static fileReaderManager.ReadFromFiles.getJsonValueByKey;

public class SearchProductTest extends BaseTests {
    NavigationPage navigationPage;
    String productTitle;
    String productTitle2;

    @BeforeMethod
    public void loadTestData() {
        productTitle = (String) getJsonValueByKey("testData.json", "productName");
        productTitle2 = (String) getJsonValueByKey("testData.json", "productName2");
    }


    @Test
    public void testUserCanNavigateAllProduct() {
        navigationPage = new NavigationPage(driver);
        ProductsPage productsPage = navigationPage.clickProductsFromNavBar();
        Assert.assertEquals(productsPage.allProducts(), "ALL PRODUCTS", "the test should be ALL PRODUCTS");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.productSearch(productTitle);
        Assert.assertEquals(searchPage.searchedProduct(), "Search Product", "the test should be Search Product ");
        Assert.assertEquals(SearchPage.getModalContent(), "12", "the test should be top ");


    }

    @Test
    public void testUserCanSeeMessageWhenNoResult() {
        navigationPage = new NavigationPage(driver);
        ProductsPage productsPage = navigationPage.clickProductsFromNavBar();
        Assert.assertEquals(productsPage.allProducts(), "ALL PRODUCTS", "the test should be ALL PRODUCTS");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.productSearch(productTitle2);
        Assert.assertEquals(productsPage.allProducts(), "ALL PRODUCTS", "the test should be ALL PRODUCTS ");
        Assert.assertEquals(SearchPage.getModalContent(), "12", "the test should be top ");


    }
}
