package baseConfig;

import lombok.Getter;
import lombok.Setter;
import mosPolytech.page.MosPolytechPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;
import lombok.Setter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Duration;


abstract public class BasePage {

    @Setter
    protected static WebDriver driver;
    @Getter
    @Setter
    private static WebDriverWait wait;
    @Getter
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void logAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        logger.info("Clicked on element: {}", element);
    }
    public void switchToNewWindow() {

        String originalWindow = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void moveToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void waitToClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitToVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("Element visible:" + element);
    }

}
