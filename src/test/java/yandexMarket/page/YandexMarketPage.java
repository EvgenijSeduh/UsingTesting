package yandexMarket.page;

import baseConfig.BasePage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class YandexMarketPage extends BasePage {
    @Getter
    @FindBy(xpath = "//button[@class='_30-fz button-focus-ring Hkr1q _1pHod _2rdh3 _3rbM-']")
    private WebElement buttonCatalog;

    @Getter
    @FindBy(xpath = "//a[@href='/catalog--kompiuternaia-tekhnika/54425']")
    private WebElement buttonLaptopsAndComputers;

    @Getter
    @FindBy(xpath = "//a[@href='/catalog--vnutrennie-zhestkie-diski/18072776/list?hid=91033']")
    private WebElement buttonHardDisk;

    @Getter
    @FindBy(xpath = "//div[@data-auto-themename='listDetailed']")
    private List<WebElement> resultSearchList;

    @Getter
    @FindBy(xpath = "//button[@data-zone-name='sort' and text() = 'подешевле']")
    private WebElement buttonSortDisc;

    @FindBy(xpath = "//div[@data-auto='SerpList']")
    private WebElement resultSearchBlock;

    public YandexMarketPage() {
        driver.get("https://market.yandex.ru");
        PageFactory.initElements(driver,this);
    }

    public void openCatalog(){
        logAndClick(buttonCatalog);
    }

    @Step("Open hard disk partition")
    public void openHardDiskPartition(){
        waitToClickable(buttonLaptopsAndComputers);
        moveToElement(buttonLaptopsAndComputers);
        waitToClickable(buttonHardDisk);
        logAndClick(buttonHardDisk);
    }

    @Step("Sort in descending order")
    public void setSortDisc(){
        moveToElement(buttonSortDisc);
        logAndClick(buttonSortDisc);
    }

    @Step("Update result search hard disc")
    public void updateResultSearch(){
        resultSearchList.clear();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-auto-themename='listDetailed']")));
        resultSearchList = driver.findElements(By.xpath( "//div[@data-auto-themename='listDetailed']"));
    }

    @Step("Displaying products in the console")
    public void logProducts(int finish) {
        for (int i = 0; i < finish && i < resultSearchList.size(); i++) {
            WebElement product = resultSearchList.get(i);
            moveToElement(product);
            String title = product.findElement(By.xpath(".//h3")).getText();
            String price = product.findElement(By.xpath(".//span[@data-auto='snippet-price-current']/span[1]")).getText();
            BasePage.getLogger().info("Name: " + title + ". Price: " + price);
        }
    }

    @Step("Checking the results of sorting in descending order")
    public boolean checkResultSortDisc(int finish) {
        updateResultSearch();
        Integer previousCost = null;
        for (int i = 0; i < finish && i < resultSearchList.size(); i++) {
            WebElement currentProduct = resultSearchList.get(i);
            moveToElement(currentProduct);
            Integer currentCost = Integer.parseInt(currentProduct.findElement(By
                    .xpath(".//span[@data-auto='snippet-price-current']/span[1]")).getText()
                    .replaceAll("[^\\d,]", "").replace(",", "."));
            if((previousCost == null)||(currentCost>=previousCost)){
                previousCost = currentCost;
            }
            else{return false;}
        }
        return true;
    }


}
