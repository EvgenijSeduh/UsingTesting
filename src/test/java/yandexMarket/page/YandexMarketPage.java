package yandexMarket.page;

import baseConfig.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YandexMarketPage extends BasePage {
    @Getter
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/header/div[1]/div/div/noindex[1]/div/div/button")
    private WebElement buttonCatalog;

    @Getter
    @FindBy(xpath = "/html/body/div[7]/div/div/div/div/div/div/div[1]/div/ul/li[21]/a")
    private WebElement buttonLaptopsAndComputers;

    @Getter
    @FindBy(xpath = "/html/body/div[7]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div/div/div/div/div/div/div[3]/div[3]/ul/li[3]/div/a")
    private WebElement buttonHardDisk;

    @Getter
    @FindBy(xpath = "//*[@id='/content/page/fancyPage/cms/3/SearchSerp-SearchSerp/serpSearch/content/lazyGenerator/initialContent']/div")
    private List<WebElement> resultSearchList;

    @Getter
    @FindBy(xpath = "//*[@id='/content/page/fancyPage/cms/3/SearchControls-SearchControls/sort']/div/noindex/div/button[2]")
    private WebElement buttonSortCheaper;

    public YandexMarketPage() {
        driver.get("https://market.yandex.ru");
        PageFactory.initElements(driver,this);
    }

}
