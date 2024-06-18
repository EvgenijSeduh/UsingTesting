package mosPolytech.test;

import baseConfig.BaseTest;
import io.qameta.allure.Allure;
import lambda.page.LambdaPage;
import lambda.test.LambdaTest;
import mosPolytech.page.MosPolytechPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class MosPolytechTest extends BaseTest {
    private MosPolytechPage mosPolytechPage;
    private static final Logger logger = LoggerFactory.getLogger(LambdaTest.class);

    @BeforeEach
    public void setUpEach() {
        Allure.step("Open Mospolyesh site", () -> {
            mosPolytechPage = new MosPolytechPage();
        });
    }

    @Test
    public void buttonScheduleTest(){
        Actions action = new Actions(driver);
        action
                .moveToElement(mosPolytechPage.getButtonMenu())
                .click()
                .moveToElement(mosPolytechPage.getButtonForStudents())
                .pause(2000)
                .moveToElement(mosPolytechPage.getButtonSchedule())
                .click()
                .release()
                .build();
        System.out.println(driver.getCurrentUrl());
        assertEquals(driver.getCurrentUrl(), "https://mospolytech.ru/obuchauschimsya/raspisaniya/");


    }

}
