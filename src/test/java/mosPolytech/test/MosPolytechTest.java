package mosPolytech.test;

import baseConfig.BaseTest;
import io.qameta.allure.Allure;
import lambda.page.LambdaPage;
import lambda.test.LambdaTest;
import mosPolytech.page.MosPolytechPage;
import mosPolytech.page.SchedulePage;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MosPolytechTest extends BaseTest {
    private MosPolytechPage mosPolytechPage;
    private Actions action;
    private SchedulePage schedulePage;
    private static final Logger logger = LoggerFactory.getLogger(LambdaTest.class);

    @BeforeEach
    public void setUpEach() {
        Allure.step("Open Mospolyesh site", () -> {
            mosPolytechPage = new MosPolytechPage();
        });
    }

    @Test
    public void buttonScheduleTest() throws InterruptedException {
        assertNotNull(mosPolytechPage.getButtonMenu());
        assertNotNull(mosPolytechPage.getButtonSchedule());
        assertNotNull(mosPolytechPage.getButtonForStudents());
        action = new Actions(driver);
        MosPolytechPage.getWait().until(ExpectedConditions.elementToBeClickable(mosPolytechPage.getButtonMenu()));
        action
                .moveToElement(mosPolytechPage.getButtonMenu())
                .click()
                .build()
                .perform();
        MosPolytechPage.getWait().until(ExpectedConditions.elementToBeClickable(mosPolytechPage.getButtonForStudents()));
        action
                .moveToElement(mosPolytechPage.getButtonForStudents())
                .build()
                .perform();
        MosPolytechPage.getWait().until(ExpectedConditions.elementToBeClickable(mosPolytechPage.getButtonSchedule()));
        action
                .moveToElement(mosPolytechPage.getButtonSchedule())
                .click()
                .build()
                .perform();
        assertEquals(driver.getCurrentUrl(), "https://mospolytech.ru/obuchauschimsya/raspisaniya/");
    }

    @Test
    public void testStudentSchedule() throws InterruptedException {
        buttonScheduleTest();
        mosPolytechPage.switchToNewWindow();
        action = new Actions(driver);
        mosPolytechPage.setButtonSeeScheduleOnWebsite(driver.findElement(By.xpath("//a[@href='https://rasp.dmami.ru/']")));
        action.moveToElement(mosPolytechPage.getButtonSeeScheduleOnWebsite()).build().perform();
        MosPolytechPage.getWait().until(ExpectedConditions.elementToBeClickable(mosPolytechPage.getButtonSeeScheduleOnWebsite()));
        assertNotNull(mosPolytechPage.getButtonSeeScheduleOnWebsite());
        mosPolytechPage.getButtonSeeScheduleOnWebsite().click();
        assertEquals(driver.getCurrentUrl(), "https://mospolytech.ru/obuchauschimsya/raspisaniya/");
    }

}
