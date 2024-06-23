package baseConfig;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Duration;
import java.util.concurrent.TimeUnit;


abstract public class BaseTest {
    public static WebDriver driver;
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    @BeforeEach
    public void setUp(){
        try {
            logger.info("Setting up the driver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            logger.info("Driver setup completed");
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            BasePage.setDriver(driver);

        } catch (Exception e) {
            logger.error("Error during driver setup", e);
            throw new RuntimeException(e);
        }
    }
    @AfterEach
    public void quit(){
        try {
            logger.info("Quit the driver");
            //Thread.sleep(10_000);
            //driver.quit();
        } catch (Exception e) {
            logger.error("Error quit driver setup", e);
            throw new RuntimeException(e);
        }
    }


}
