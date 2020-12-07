package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AimCloSearchJemperPage {
    private static final String MAIN_PAGE_URL = "https://aimclo.ru";
    private WebDriver driver;

    @FindBy(xpath = "//button [@aria-label='Открыть поиск'  and @class='search-btn header-hover__search-btn js__search-open']")
    private WebElement openSearchButton;

    @FindBy(xpath = "//div[@class='search-block header-hover__search-block']//input[@type='text']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='search-block header-hover__search-block']//button [@type='submit' and @aria-label='Найти']")
    private WebElement searchButton;

    public AimCloSearchJemperPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public AimCloSearchJemperPage openMainPage()
    {
        driver.get(MAIN_PAGE_URL);
        return this;
    }
    public AimCloSearchJemperPage openSearch() {
        openSearchButton.click();
        return this;
    }
    public AimCloSearchJemperPage searchForTerms(String term) {
        searchInput.sendKeys(term);
        return this;
    }

    public AimCloSearchResultsPage searchForTermsResults() {
        searchButton.click();
        return new AimCloSearchResultsPage(driver);
    }

}
