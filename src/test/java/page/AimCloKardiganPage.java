package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AimCloKardiganPage {
    private static final String KARDIGAN_PAGE_URL = "https://aimclo.ru/shop/kardigany/kardigan-udlinennyy-seryy/";
    private WebDriver driver;

    @FindBy(xpath = "//*[@value='ДОБАВИТЬ В КОРЗИНУ']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//a[@href='/basket/']")
    private WebElement goToBagButton;

    @FindBy(xpath = "//div[@class='add-basket__footer']")
    private WebElement goToLookBagButton;

    @FindBy(xpath = "//div[@class='close']")
    private WebElement deleteFromBagButton;

    public AimCloKardiganPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public AimCloKardiganPage openPage() {
        driver.get(KARDIGAN_PAGE_URL);
        return this;
    }

    public AimCloKardiganPage addToBag() {
        addToBagButton.click();
        return this;
    }

    public AimCloKardiganPage goToBag() {
        goToBagButton.click();
        return this;
    }
    public AimCloKardiganPage openBagPage() {
        goToLookBagButton.click();
        return this;
    }
    public AimCloEmptyBagPage deleteFromBag() {
        deleteFromBagButton.click();
        return new AimCloEmptyBagPage(driver);
    }

    public AimCloBagPage checkNotEmptyBagPage() {
        goToLookBagButton.click();
        return new AimCloBagPage(driver);
    }




}
