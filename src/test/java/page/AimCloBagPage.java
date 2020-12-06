package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AimCloBagPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='tovar']//a")
    private WebElement KardiganInBag;

    public AimCloBagPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getTextFromBag()
    {
        return KardiganInBag.getText();
    }
}

