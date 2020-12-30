package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wait.WaitWebElement;

public class BagPage extends AbstractPageWithStaticUrl {
    @FindBy(xpath = "//div[@class='tovar']//a")
    private WebElement bagPageResult;

    @FindBy(xpath = "//*[text()='Корзина пуста']")
    private WebElement emptyBagPageResult;

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
