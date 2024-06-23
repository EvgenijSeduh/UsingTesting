package museum.test;

import io.qameta.allure.Allure;
import museum.page.MuseumPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yandexMarket.page.YandexMarketPage;
import yandexMarket.test.YandexMarketTest;

public class MuseumTest {
    private MuseumPage museumPage;
    private Actions action;
    private static final Logger logger = LoggerFactory.getLogger(MuseumTest.class);

    @BeforeEach
    public void setUpEach() {
        Allure.step("Open yandex market site", () -> {
            museumPage = new MuseumPage();
        });
    }

//    @Test
//    public void
}
