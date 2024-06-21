package baseConfig;

import lombok.Getter;
import lombok.Setter;
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

    public void moveToElementAndLog(WebElement element){
        logger.info("move to element {}", element);
        Actions action = new Actions(driver);
        action.moveToElement(element);
    }

}
