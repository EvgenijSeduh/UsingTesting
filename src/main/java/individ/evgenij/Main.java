//package individ.evgenij;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class Main {
//    @Test
//    public static void main(String[] args) throws InterruptedException {
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        driver.get("https://lambdatest.github.io/sample-todo-app/ ");
//        String window1 = driver.getWindowHandle();
//
//
//
//
//        WebElement numberTaskText = driver.findElement(By.xpath("//span[text()='5 of 5 remaining']"));
//
//
//
//
//        WebElement task1 = driver.findElement(By.name("li1"));
//        WebElement task2 = driver.findElement(By.name("li2"));
//        WebElement task3 = driver.findElement(By.name("li3"));
//        WebElement task4 = driver.findElement(By.name("li4"));
//        WebElement task5 = driver.findElement(By.name("li5"));
//        Thread.sleep(1000);
//        task1.click();
//        Thread.sleep(1000);
//        task2.click();
//        Thread.sleep(1000);
//        task3.click();
//        Thread.sleep(1000);
//        task4.click();
//        Thread.sleep(1000);
//        task5.click();
//        WebElement newTaskInput = driver.findElement(By.id("sampletodotext"));
//        newTaskInput.click();
//        newTaskInput.sendKeys("newTask", Keys.ENTER);
//        WebElement newTaskPoint = (new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.name("li6")))
//        );
//
//
//
//    }
//}