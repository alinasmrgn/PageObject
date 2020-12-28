package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitWebElement;

public class BagPage extends AbstractPageWithStaticUrl {

    @FindBy(xpath = "//div[@class='close']")
    private WebElement deleteFromBagPageButton;

    public BagPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public BagPage openPage() {
        driver.get("https://aimclo.ru/basket/");
        return this;
    }

    public boolean checkAddProductToBagPage() {
        try {
            WaitWebElement.waitWebElementLocatedBy(driver, By
                    .xpath("//div[@class='tovar']//a and text()='Кардиган удлиненный, серый']"));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    @FindBy(xpath = "//div[@class='tovar']//a")
    private WebElement bagPageResult;

    public boolean checkDeleteProductToBagPage() {
        try {
            WaitWebElement.waitWebElementLocatedBy(driver, By
                    .xpath("//*[text()='Корзина пуста']"));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    @FindBy(xpath = "//*[text()='Корзина пуста']")
    private WebElement emptyBagPageResult;

    public BagPage deleteFromBagPage() {
        deleteFromBagPageButton.click();
        return this;
    }

    public String getBagPageResult() {
        return bagPageResult.getText();
    }
    public String getEmptyBagPageResult() {
        return emptyBagPageResult.getText();
    }
}
