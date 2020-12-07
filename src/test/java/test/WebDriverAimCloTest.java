package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

public class WebDriverAimCloTest {

    private WebDriver driver;
    public static AimCloBagPage aimCloBagPage;
    public static AimCloEmptyBagPage aimCloEmptyBagPage;
    public static AimCloKardiganPage aimCloKardiganPage;
    public static AimCloSearchJemperPage aimCloSearchJemperPage;
    public static AimCloSearchResultsPage aimCloSearchResultsPage;

    @BeforeMethod(alwaysRun = true)
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addToBagTest() {
        aimCloKardiganPage= new AimCloKardiganPage(driver);
        aimCloBagPage=aimCloKardiganPage.openPage()
                .addToBag()
                .goToBag()
                .checkNotEmptyBagPage();
        String expectedResult=aimCloBagPage.getTextFromBag();
        Assert.assertEquals(expectedResult,"Кардиган удлиненный, серый");
    }

    @Test
    public void deleteFromBagTest() {
        aimCloKardiganPage= new AimCloKardiganPage(driver);
        aimCloEmptyBagPage=aimCloKardiganPage.openPage()
                .addToBag()
                .goToBag()
                .openBagPage()
                .deleteFromBag();
        String expectedResult=aimCloEmptyBagPage.getTextFromEmptyBag();
        Assert.assertEquals(expectedResult,"Корзина пуста");
    }
    @Test
    public void searchJemperTest() {
        aimCloSearchJemperPage = new AimCloSearchJemperPage(driver);
        aimCloSearchResultsPage = aimCloSearchJemperPage.openMainPage()
                .openSearch()
                .searchForTerms("Джемпер из хлопка с коротким рукавом, бежевый")
                .searchForTermsResults();
        String expectedResult=aimCloSearchResultsPage.getTextFromSearchResultsPage();
        Assert.assertEquals(expectedResult,"Джемпер из хлопка с коротким рукавом, бежевый");
    }

    @AfterMethod(alwaysRun = true)
    public void driverShutDown(){
        driver.quit();
        driver=null;
    }



}

