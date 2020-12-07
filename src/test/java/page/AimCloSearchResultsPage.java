package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AimCloSearchResultsPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='one-product-info' ]/p")
    private WebElement JemperInResult;

    public AimCloSearchResultsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getTextFromSearchResultsPage()
    {
        return JemperInResult.getText();
    }
}
