package baseConfig;

import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener extends AllureJunit4 {

    @Override
    public void testFailure(final Failure failure) {
        byte[] byteImage = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
        String testName = failure.getDescription().getDisplayName();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String screenshotName = String.format("%s_%s.png", testName, timestamp);
        getLifecycle().addAttachment(screenshotName, "image/png", null, byteImage);
        super.testFailure(failure);
    }
}