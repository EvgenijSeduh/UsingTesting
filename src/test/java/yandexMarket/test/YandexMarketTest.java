package yandexMarket.test;

import baseConfig.BaseTest;
import io.qameta.allure.Allure;
import lambda.test.LambdaTest;
import mosPolytech.page.MosPolytechPage;
import mosPolytech.page.SchedulePage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yandexMarket.page.YandexMarketPage;

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
}
