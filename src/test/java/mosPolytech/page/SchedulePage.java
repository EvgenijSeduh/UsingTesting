package mosPolytech.page;

import baseConfig.BasePage;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class SchedulePage extends BasePage {
    @Getter
    @FindBy(xpath = "//a[@href='https://rasp.dmami.ru/session']")
    private WebElement buttonSeeScheduleOnWebsite;

    @Getter
    @FindBy(xpath = "//input[@class='groups']")
    private WebElement groupInput;

    @Getter
    @FindBy(xpath = "//div[contains(@class, 'found-groups')]/div[@id='221-361']")
    private WebElement group221_361Href;

    @Getter
    @FindBy(xpath = "//div[@class='schedule-day schedule-day_today']")
    WebElement scheduleToday;

    public SchedulePage() {
        PageFactory.initElements(driver, this);
    }

    public void inputGroupInTextHolder(){
        groupInput.sendKeys("221-361");
        logAndClick(group221_361Href);
    }


    public boolean isCurrentDayHighlighted() {
        DayOfWeek currentDay = LocalDate.now().getDayOfWeek();
        String currentDayName = currentDay.getDisplayName(TextStyle.FULL, new Locale("ru"));
        WebElement currentDayElement = driver.findElement(
                By.xpath("//div[@class='schedule-day schedule-day_today']"));
        return currentDayElement != null && currentDayElement.isDisplayed();
    }

}
