package mosPolytech.test;

import baseConfig.BaseTest;
import io.qameta.allure.Allure;
import lambda.page.LambdaPage;
import lambda.test.LambdaTest;
import mosPolytech.page.MosPolytechPage;
import mosPolytech.page.SchedulePage;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDate;

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
        mosPolytechPage.switchToNewWindow();

        SchedulePage schedulePage = new SchedulePage();
        System.out.println(driver.getCurrentUrl());
        schedulePage.getGroupInput().sendKeys("221-361");
        SchedulePage.getWait().until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("221-361"))));

        schedulePage.setGroup221_361Href(driver.findElement(By.xpath("//div[contains(@class, 'found-groups')]/div[@id='221-361']")));
        System.out.println(schedulePage.getGroup221_361Href().getTagName());
        assertNotNull(schedulePage.getGroup221_361Href());
        SchedulePage.getWait().until(ExpectedConditions.elementToBeClickable(schedulePage.getGroup221_361Href()));
        schedulePage.getGroup221_361Href().click();
        schedulePage.setScheduleTodays(driver.findElement(By.xpath("//div[@class='schedule-day schedule-day_today']")));
        assertNotNull(schedulePage.getScheduleTodays());
        SchedulePage.getWait().until(ExpectedConditions.elementToBeClickable(schedulePage.getScheduleTodays()));
        assertNotNull(schedulePage.getScheduleTodays());

        Allure.step("Verify current day is highlighted", () -> {
            boolean isCurrentDayHighlighted = schedulePage.isCurrentDayHighlighted();
            Assertions.assertTrue(isCurrentDayHighlighted, "Current day is not highlighted in the schedule");
        });

    }

}
