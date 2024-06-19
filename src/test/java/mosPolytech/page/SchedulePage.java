package mosPolytech.page;

import baseConfig.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchedulePage extends BasePage {
    @Getter
    @FindBy(xpath = "*[@id='bx_3777608605_2854']/div[3]/div/div[1]/a")
    WebElement buttonSeeScheduleOnWebsite;

    public SchedulePage() {
        PageFactory.initElements(driver, this);
    }
}
