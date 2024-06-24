package baseConfig;

import io.qameta.allure.Allure;
import lambda.page.LambdaPage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static baseConfig.BaseTest.driver;

public class TestListener extends BaseTest implements TestWatcher {
    //private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private static final String SCREENSHOT_DIR = "testScreenshots/";

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        //logger.error("Test failed: " + context.getDisplayName(), cause);
        captureScreenshotAndLogs("Failed test", context, true);
        quitDriver();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        //logger.info("Test success: " + context.getDisplayName());
        captureScreenshotAndLogs("Successful test", context, false);
        quitDriver();
    }

    private void captureScreenshotAndLogs(String status, ExtensionContext context, boolean saveToFile) {
        try {
            // Скриншот
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.getLifecycle().addAttachment(status + " screenshot", "image/png", "png", screenshot);

            if (saveToFile) {
                // Сохранение скриншота в файл
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                DateTimeFormatter format = DateTimeFormatter.ofPattern("uuuu-MMM-dd-HH-mm-ss");
                String pathName = SCREENSHOT_DIR + status + "-(" + context.getDisplayName().replaceAll(" ", "-").replaceAll("[\\/\\?]", "_") + ")-" + LocalDateTime.now().format(format) + ".png";
                FileUtils.copyFile(srcFile, new File(pathName));
            }
        } catch (IOException e) {
            //logger.error("Failed to capture screenshot and logs", e);
            throw new RuntimeException(e);
        }
    }

    private void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
