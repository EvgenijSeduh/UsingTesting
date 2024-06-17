package lambda.test;

import baseConfig.BaseTest;
import io.qameta.allure.Allure;
import lambda.ParseInt;
import lambda.page.LambdaPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public void task1Test() {
        assertNotNull(lambdaPage.getTasks().get(0));
        Assertions.assertTrue(lambdaPage.getTasks().get(0).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.getTasks().get(0).findElement(By.tagName("input")).click();
        Assertions.assertTrue(lambdaPage.getTasks().get(0).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    public void task2Test() {
        assertNotNull(lambdaPage.getTasks().get(1));
        Assertions.assertTrue(lambdaPage.getTasks().get(1).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.getTasks().get(1).findElement(By.tagName("input")).click();
        Assertions.assertTrue(lambdaPage.getTasks().get(1).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    public void task3Test() {
        assertNotNull(lambdaPage.getTasks().get(2));
        Assertions.assertTrue(lambdaPage.getTasks().get(2).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.getTasks().get(2).findElement(By.tagName("input")).click();
        Assertions.assertTrue(lambdaPage.getTasks().get(2).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    public void task4Test() {
        assertNotNull(lambdaPage.getTasks().get(3));
        Assertions.assertTrue(lambdaPage.getTasks().get(3).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.getTasks().get(3).findElement(By.tagName("input")).click();
        Assertions.assertTrue(lambdaPage.getTasks().get(3).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    public void task5Test() {
        assertNotNull(lambdaPage.getTasks().get(4));
        Assertions.assertTrue(lambdaPage.getTasks().get(4).findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        lambdaPage.getTasks().get(4).findElement(By.tagName("input")).click();
        Assertions.assertTrue(lambdaPage.getTasks().get(4).findElement(By.tagName("span")).getAttribute("class").contains("done-true"));

        countTaskTextTest();
    }

    @Test
    public void createNewTaskTest(){
        assertNotNull(lambdaPage.getNewTaskInput());
        lambdaPage.getNewTaskInput().click();
        lambdaPage.getNewTaskInput().sendKeys("New test task");
        System.out.println(lambdaPage.getNewTaskInput().getText());
        assertNotNull(lambdaPage.getNewTaskButton());
        lambdaPage.getNewTaskButton().click();
        lambdaPage.setTasks(driver.findElements(By.xpath("//li[@class='ng-scope']")));
        assertNotNull(lambdaPage.getTasks().get(5));
    }

}

