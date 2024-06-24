package museum.test;

import baseConfig.BaseTest;
import io.qameta.allure.Allure;
import museum.page.MuseumPage;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yandexMarket.page.YandexMarketPage;
import yandexMarket.test.YandexMarketTest;

public class MuseumTest extends BaseTest {
    private MuseumPage museumPage;
    private Actions action;
    private static final Logger logger = LoggerFactory.getLogger(MuseumTest.class);

    @BeforeEach
    public void setUpEach() {
        Allure.step("Open museum site", () -> {
            museumPage = new MuseumPage();
        });
    }

    @Test
    public void exhibitionsRelevantTest(){
        museumPage.openExhibition();
        for(WebElement i: museumPage.getExhibitionList()){
            if(!(museumPage.itLaterToday(museumPage.exhibitionGetDate(i)))){
                logger.error("Contains an exhibition that has already taken place");
                Assert.fail();
            }
        }
        logger.info("All exhibitions are relevant");
    }

    @Test
    public void numberTelephoneTest(){
        museumPage.openHowToReachUs();
        Assert.assertNotNull(museumPage.getTextWithTel());
        Assert.assertTrue(museumPage.checkTel("Автоответчик: 8 (499) 783-22-53"));
        Assert.assertTrue(museumPage.checkTel("Экскурсионное бюро: 8 (499) 134-61-24"));
        Assert.assertTrue(museumPage.checkTel("Заказ программы «День рождения в ГДМ»: 8 (499) 724-19-64,  8 (499) 783-22-57"));
        Assert.assertTrue(museumPage.checkTel("Факс: 8 (499) 783-22-54"));
    }

    @Test
    public void test(){
        museumPage.openAnnualReports();
        museumPage.openReport();
        museumPage.openLinkReport();
        if(driver.getCurrentUrl().indexOf(".pdf")!=-1){
            logger.info("The file is on the page and it opens");
        }else Assert.fail();
    }
}
