package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractPageWithParameterizedUrl {

    @FindBy(xpath = "//a[@href='/basket/']")
    private WebElement goToBagPageButton;

    @FindBy(xpath = "//div[@class='add-basket__footer']")
    private WebElement goToLookBagPageButton;

    @FindBy(xpath = "//*[@value='ДОБАВИТЬ В КОРЗИНУ']")
    private WebElement addProductToBagPageButton;

    public ProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public ProductPage openPage(String urlPart) {
        driver.get("https://aimclo.ru/shop/"+urlPart);
        return this;
    }

    public ProductPage addProductToBag()
    {
        addProductToBagPageButton.click();
        return this;
    }
    public ProductPage goToBagPage()
    {
        goToBagPageButton.click();
        return this;
    }

    public BagPage goToLookBagPage(){
        goToLookBagPageButton.click();
        return new BagPage(driver);
    }
}
