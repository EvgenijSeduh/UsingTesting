package yandexMarket.page;

import baseConfig.BasePage;
import lombok.Getter;
import mosPolytech.page.MosPolytechPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class YandexMarketPage extends BasePage {
    @Getter
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/header/div[1]/div/div/noindex[1]/div/div/button")
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

    public void openHardDiskPartition(){
        getWait().until(ExpectedConditions.elementToBeClickable(buttonLaptopsAndComputers));
        moveToElementAndLog(buttonLaptopsAndComputers);
        getWait().until(ExpectedConditions.elementToBeClickable(buttonHardDisk));
        logAndClick(buttonHardDisk);
    }

    public void setSortDisc(){
        moveToElementAndLog(buttonSortDisc);
        logAndClick(buttonSortDisc);
    }

    public void updateResultSearch(){
        resultSearchList.clear();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-auto-themename='listDetailed']")));
        resultSearchList = driver.findElements(By.xpath( "//div[@data-auto-themename='listDetailed']"));
    }

    public void logProducts(int finish) {
        for (int i = 0; i < finish && i < resultSearchList.size(); i++) {
            WebElement product = resultSearchList.get(i);
            moveToElementAndLog(product);
            String title = product.findElement(By.xpath(".//h3")).getText();
            String price = product.findElement(By.xpath(".//span[@data-auto='snippet-price-current']/span[1]")).getText();
            BasePage.getLogger().info("Name: " + title + ". Price: " + price);
        }
    }

    public boolean checkResultSortDisc(int finish) {
        updateResultSearch();
        Integer previousCost = null;
        for (int i = 0; i < finish && i < resultSearchList.size(); i++) {
            WebElement currentProduct = resultSearchList.get(i);
            moveToElementAndLog(currentProduct);
            Integer currentCost = Integer.parseInt(currentProduct.findElement(By
                    .xpath(".//span[@data-auto='snippet-price-current']/span[1]")).getText()
                    .replaceAll("[^\\d,]", "").replace(",", "."));
            System.out.println(currentCost);
            if((previousCost == null)||(currentCost>=previousCost)){
                previousCost = currentCost;
            }
            else{return false;}
        }
        return true;
    }



    //h3[@data-auto="snippet-title"]//name disk
    //span[@class="_1ArMm"]// cell disc

}
