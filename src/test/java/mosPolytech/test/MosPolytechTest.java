package mosPolytech.test;

import baseConfig.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import mosPolytech.page.MosPolytechPage;
import mosPolytech.page.SchedulePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MosPolytechTest extends BaseTest {
    private MosPolytechPage mosPolytechPage;
    private Actions action;
    private SchedulePage schedulePage;
    private static final Logger logger = LoggerFactory.getLogger(MosPolytechTest.class);

    @Before
    public void setUpEach() {
        Allure.step("Open Mospolyesh site", () -> {
            mosPolytechPage = new MosPolytechPage();
        });
    }

    @Step("button Schedule Test")
    @Test
    public void buttonScheduleTest() throws InterruptedException {
        try {
            assertNotNull(mosPolytechPage.getButtonSchedule());
        }catch (AssertionError e){
            Assert.fail();
            return;
        }

        mosPolytechPage.openScheduleTab();
        logger.info("Go to a new tab " + driver.getCurrentUrl());

        mosPolytechPage.openScheduleInNewWindow();
        mosPolytechPage.switchToNewWindow();
        assertEquals(driver.getCurrentUrl(), "https://rasp.dmami.ru/session");

        logger.info("Go to a new window " + driver.getCurrentUrl());


    }

    @Test
    public void testStudentSchedule() throws InterruptedException {
        buttonScheduleTest();

        SchedulePage schedulePage = new SchedulePage();
        schedulePage.inputGroupInTextHolder();

        Assert.assertTrue("Current day is not highlighted in the schedule", schedulePage.isCurrentDayHighlighted());

    }

}
