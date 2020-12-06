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
    public static AimCloKardiganPage aimCloKardiganPage;

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
                .openBagPage();
        String expectedResult=aimCloBagPage.getTextFromBag();
        Assert.assertEquals(expectedResult,"Кардиган удлиненный, серый");
    }

    @AfterMethod(alwaysRun = true)
    public void driverShutDown(){
        driver.quit();
        driver=null;
    }



}

