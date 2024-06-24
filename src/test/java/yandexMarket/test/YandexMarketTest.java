package yandexMarket.test;

import baseConfig.BaseTest;
import baseConfig.TestListener;
import io.qameta.allure.Allure;
import lambda.test.LambdaTest;
import mosPolytech.page.MosPolytechPage;
import mosPolytech.page.SchedulePage;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yandexMarket.page.YandexMarketPage;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class YandexMarketTest extends BaseTest {
    private YandexMarketPage yandexMarketPage;
    private Actions action;
    private static final Logger logger = LoggerFactory.getLogger(YandexMarketTest.class);

    @BeforeEach
    public void setUpEach() {
        Allure.step("Open yandex market site", () -> {
            yandexMarketPage = new YandexMarketPage();
        });
    }

    @Test
    public void sortHardDiskDescendingTest() throws InterruptedException {
        try {
            assertNotNull(yandexMarketPage.getButtonCatalog());
            assertNotNull(yandexMarketPage.getButtonLaptopsAndComputers());
            assertNotNull(yandexMarketPage.getButtonHardDisk());
        }catch (AssertionError e){
            Assert.fail();
        }
        yandexMarketPage.openCatalog();
        yandexMarketPage.openHardDiskPartition();

        yandexMarketPage.logProducts(5);

        yandexMarketPage.setSortDisc();
        Thread.sleep(3000);
        yandexMarketPage.updateResultSearch();
        assertTrue(yandexMarketPage.checkResultSortDisc(10));
    }

}
