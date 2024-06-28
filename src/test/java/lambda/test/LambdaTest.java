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
        if (lambdaPage.getTasks().get(0) == null) {
            Assert.fail();
            return;
        }
        for (WebElement i : lambdaPage.getTasks()) {
            if (i.findElement(By.tagName("span")).getAttribute("class").contains("done-true")) {
                count++;
            }
        }
        currentNumberActiveTasks = count;
        assertEquals(ParseInt.parseFirstInt(lambdaPage.getCountTaskText().getText()), (lambdaPage.getTasks().size() - currentNumberActiveTasks));
    }

    @Test
    @DisplayName("Test tasks")
    @Feature("Reaction to clicks")
    public void taskTest() {
        for (WebElement i: lambdaPage.getTasks()){
            lambdaPage.clickTask(i);
            countTaskTextTest();
        }
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
        assertNotNull(lambdaPage.getTasks().get(lambdaPage.getTasks().size()-1));
    }

    @Test
    @DisplayName("Test inscription Title")
    @Feature("Correctness of the text")
    public void startInscriptionTitle(){
        assertEquals(lambdaPage.getTitle().getText(),"5 of " + lambdaPage.getTasks().size() + " remaining");
    }

}


