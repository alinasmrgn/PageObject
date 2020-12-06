package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AimCloEmptyBagPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[text()='Корзина пуста']")
    private WebElement KardiganOutOfBag;

    public AimCloEmptyBagPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getTextFromEmptyBag()
    {
        return KardiganOutOfBag.getText();
    }
}

