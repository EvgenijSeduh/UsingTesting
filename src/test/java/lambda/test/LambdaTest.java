package lambda.test;

import baseConfig.BaseTest;
import baseConfig.TestListener;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lambda.ParseInt;
import lambda.page.LambdaPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LambdaTest extends BaseTest {
    private LambdaPage lambdaPage;
    private static final Logger logger = LoggerFactory.getLogger(LambdaTest.class);

    private int currentNumberActiveTasks;

    @BeforeEach
    public void setUpEach() {
        Allure.step("Open LambdaTest sample app and initialize page", () -> {
            lambdaPage = new LambdaPage();
        });
        currentNumberActiveTasks = lambdaPage.getTasks().size();
    }



    @Test
    @Step("Checking that there are no crossed-out tasks")
    public void countTaskTextTest() {
        int count = 0;
        if (lambdaPage.getTasks().get(0) == null)
            return;
        for (WebElement i : lambdaPage.getTasks()) {
            if (i.findElement(By.tagName("span")).getAttribute("class").contains("done-true")) {
                count++;
            }
        }
        currentNumberActiveTasks = count;
        assertEquals(ParseInt.parseFirstInt(lambdaPage.getCountTaskText().getText()), (lambdaPage.getTasks().size() - currentNumberActiveTasks));
    }

    @Test
    @Step("Test 1 task")
    public void task1Test() {
        assertNotNull(lambdaPage.getTasks().get(0));
        Assertions.assertTrue(lambdaPage.getTasks().get(0).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.logAndClick(lambdaPage.getTasks().get(0).findElement(By.tagName("input")));
        Assertions.assertTrue(lambdaPage.getTasks().get(0).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    @Step("Test 2 task")
    public void task2Test() {
        assertNotNull(lambdaPage.getTasks().get(1));
        Assertions.assertTrue(lambdaPage.getTasks().get(1).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.logAndClick(lambdaPage.getTasks().get(1).findElement(By.tagName("input")));
        Assertions.assertTrue(lambdaPage.getTasks().get(1).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    @Step("Test 3 task")
    public void task3Test() {
        assertNotNull(lambdaPage.getTasks().get(2));
        Assertions.assertTrue(lambdaPage.getTasks().get(2).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.logAndClick(lambdaPage.getTasks().get(2).findElement(By.tagName("input")));
        Assertions.assertTrue(lambdaPage.getTasks().get(2).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    @Step("Test 4 task")
    public void task4Test() {
        assertNotNull(lambdaPage.getTasks().get(3));
        Assertions.assertTrue(lambdaPage.getTasks().get(3).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.logAndClick(lambdaPage.getTasks().get(3).findElement(By.tagName("input")));
        Assertions.assertTrue(lambdaPage.getTasks().get(3).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    @Step("Test 5 task")
    public void task5Test() {
        assertNotNull(lambdaPage.getTasks().get(4));
        Assertions.assertTrue(lambdaPage.getTasks().get(4).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.logAndClick(lambdaPage.getTasks().get(4).findElement(By.tagName("input")));
        Assertions.assertTrue(lambdaPage.getTasks().get(4).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    @Step("Create new task")
    public void createNewTaskTest(){
        assertNotNull(lambdaPage.getNewTaskInput());
        lambdaPage.logAndClick(lambdaPage.getNewTaskInput());
        lambdaPage.getNewTaskInput().sendKeys("New test task");
        assertNotNull(lambdaPage.getNewTaskButton());
        lambdaPage.logAndClick(lambdaPage.getNewTaskButton());
        lambdaPage.updateTasks();
        assertNotNull(lambdaPage.getTasks().get(5));
    }

    @Test
    @Step("Test inscription Title")
    public void startInscriptionTitle(){
        assertEquals(lambdaPage.getTitle().getText(),"5 of " + lambdaPage.getTasks().size() + " remaining");
    }

}


