package mosPolytech.test;

import baseConfig.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
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
    private static final Logger logger = LoggerFactory.getLogger(MosPolytechTest.class);

    @BeforeEach
    public void setUpEach() {
        Allure.step("Open Mospolyesh site", () -> {
            mosPolytechPage = new MosPolytechPage();
        });
    }

    @Step("button Schedule Test")
    @Test
    public void buttonScheduleTest() throws InterruptedException {
        assertNotNull(mosPolytechPage.getButtonMenu());
        assertNotNull(mosPolytechPage.getButtonSchedule());
        assertNotNull(mosPolytechPage.getButtonForStudents());

        mosPolytechPage.openScheduleTab();
        logger.info("Go to a new tab " + driver.getCurrentUrl());

        mosPolytechPage.openScheduleInNewWindow();
        mosPolytechPage.switchToNewWindow();
        assertEquals(driver.getCurrentUrl(),"https://rasp.dmami.ru/session");

        logger.info("Go to a new window " + driver.getCurrentUrl());


    }

    @Test
    public void testStudentSchedule() throws InterruptedException {
        buttonScheduleTest();



        SchedulePage schedulePage = new SchedulePage();
        schedulePage.inputGroupInTextHolder();


        Assertions.assertTrue( schedulePage.isCurrentDayHighlighted(), "Current day is not highlighted in the schedule");

    }

}
