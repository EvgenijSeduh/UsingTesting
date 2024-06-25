package lambda.test;

import baseConfig.BaseTest;
import baseConfig.TestListener;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import lambda.ParseInt;
import lambda.page.LambdaPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class LambdaTest extends BaseTest {
    private LambdaPage lambdaPage;
    private static final Logger logger = LoggerFactory.getLogger(LambdaTest.class);

    private int currentNumberActiveTasks;

    @Before
    public void setUpEach() {
        Allure.step("Open LambdaTest sample app and initialize page", () -> {
            lambdaPage = new LambdaPage();
        });
        assertNotNull(lambdaPage.getTasks());
        currentNumberActiveTasks = lambdaPage.getTasks().size();
    }



    @Test
    @DisplayName("Checking that there are no crossed-out tasks")
    @Feature("Correctness of the text")
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
    @DisplayName("Test 1 task")
    @Feature("Reaction to clicks")
    public void task1Test() {
        assertNotNull(lambdaPage.getTasks().get(0));
        Assert.assertTrue(lambdaPage.getTasks().get(0).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.waitToClickable(lambdaPage.getTasks().get(0).findElement(By.tagName("input")));
        lambdaPage.logAndClick(lambdaPage.getTasks().get(0).findElement(By.tagName("input")));
        Assert.assertTrue(lambdaPage.getTasks().get(0).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    @DisplayName("Test 2 task")
    @Feature("Reaction to clicks")
    public void task2Test() {
        assertNotNull(lambdaPage.getTasks().get(1));
        Assert.assertTrue(lambdaPage.getTasks().get(1).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.logAndClick(lambdaPage.getTasks().get(1).findElement(By.tagName("input")));
        Assert.assertTrue(lambdaPage.getTasks().get(1).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    @DisplayName("Test 3 task")
    @Feature("Reaction to clicks")
    public void task3Test() {
        assertNotNull(lambdaPage.getTasks().get(2));
        Assert.assertTrue(lambdaPage.getTasks().get(2).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.logAndClick(lambdaPage.getTasks().get(2).findElement(By.tagName("input")));
        Assert.assertTrue(lambdaPage.getTasks().get(2).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    @DisplayName("Test 4 task")
    @Feature("Reaction to clicks")
    public void task4Test() {
        assertNotNull(lambdaPage.getTasks().get(3));
        Assert.assertTrue(lambdaPage.getTasks().get(3).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.logAndClick(lambdaPage.getTasks().get(3).findElement(By.tagName("input")));
        Assert.assertTrue(lambdaPage.getTasks().get(3).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    @DisplayName("Test 5 task")
    @Feature("Reaction to clicks")
    public void task5Test() {
        assertNotNull(lambdaPage.getTasks().get(4));
        Assert.assertTrue(lambdaPage.getTasks().get(4).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.logAndClick(lambdaPage.getTasks().get(4).findElement(By.tagName("input")));
        Assert.assertTrue(lambdaPage.getTasks().get(4).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    @DisplayName("Create new task")
    @Feature("Creating an Item")
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
    @DisplayName("Test inscription Title")
    @Feature("Correctness of the text")
    public void startInscriptionTitle(){
        assertEquals(lambdaPage.getTitle().getText(),"5 of " + lambdaPage.getTasks().size() + " remaining");
    }

}


