package lambda.page;

import baseConfig.BasePage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class LambdaPage extends BasePage {
    @Getter
    @FindBy(xpath = "//li[@class='ng-scope']")
    private List<WebElement> tasks;

    @Getter
    @FindBy(className = "ng-binding")
    private WebElement countTaskText;

    @Getter
    @FindBy(xpath = "//span[text()='5 of 5 remaining']")
    private WebElement title;

    @Getter
    @FindBy(id = "sampletodotext")
    private WebElement newTaskInput;

    @Getter
    @FindBy(id = "addbutton")
    private WebElement newTaskButton;

    public LambdaPage() {
        driver.get("https://lambdatest.github.io/sample-todo-app/");
        PageFactory.initElements(driver, this);
    }

    @Step("Update tasks list")
    public List<WebElement> updateTasks(){
        return driver.findElements(By.xpath("//li[@class = 'ng-scope']"));
    }

    @Step("Click test")
    public void clickTask(WebElement task) {
        assertNotNull(task);
        Assert.assertTrue(task.findElement(By.tagName("span")).getAttribute("class").contains("done-false"));
        logAndClick(task.findElement(By.tagName("input")));
        Assert.assertTrue(task.findElement(By.tagName("span")).getAttribute("class").contains("done-true"));
    }


}
