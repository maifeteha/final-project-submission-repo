package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTests extends BaseTests {
    @Test
    public void testHomeItemAreDisplay()
    {
        HomePage homePage= new HomePage(driver);
        Assert.assertEquals(homePage.category,"CATEGORY","the test should be CATEGORY");
    }
}
