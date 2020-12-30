package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

public class Tests {

    private WebDriver driver;
    private final String partUrlPageWithProduct = "kardigany/kardigan-udlinennyy-seryy/";

    @BeforeMethod(alwaysRun = true)
    public void browserStart() {
        driver = new ChromeDriver();
    }

@Test
    public void addToBagTest() {
        BagPage bagPage= new ProductPage(driver)
                .openPage(partUrlPageWithProduct)
                .addProductToBag()
                .goToBagPage()
                .goToLookBagPage();
    Assert.assertEquals(bagPage.getBagPageResult(), "Кардиган удлиненный, серый");
    }

    @Test
    public void deleteFromBagTest() {
        BagPage bagPage= new ProductPage(driver)
                .openPage(partUrlPageWithProduct)
                .addProductToBag()
                .goToBagPage()
                .goToLookBagPage()
                .deleteFromBagPage();
    Assert.assertEquals(bagPage.getEmptyBagPageResult(), "Корзина пуста");
    }

    @Test
    public void searchTest() {
          SearchResultsPage searchResultsPagePage= new MainPage(driver)
                .openPage()
                  .openSearch()
                .searchForTerms("Джемпер из хлопка с коротким рукавом, бежевый")
                .searchForTermsResults();
        Assert.assertEquals(searchResultsPagePage.getSearchResults(), "Джемпер из хлопка с коротким рукавом, бежевый");

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void quiteBrowserAfterTest() {
        driver.quit();
    }
}

