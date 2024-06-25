package yandexMarket.test;

import baseConfig.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

    @Before
    public void setUpEach() {
        Allure.step("Open yandex market site", () -> {
            yandexMarketPage = new YandexMarketPage();
        });
    }

    @Test
    @DisplayName("Testing the Sorting of Hard Drives in Descending Order")
    @Feature("Checking the sorting work")
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
