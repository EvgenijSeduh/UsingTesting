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
    @FindBy(xpath = "*[@id='bx_3777608605_2854']/div[3]/div/div[1]/a")
    private WebElement buttonSeeScheduleOnWebsite;

    @Getter
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/div[3]/input[1]")
    private WebElement GroupInput;

    @Getter
    @Setter
    private WebElement Group221_361Href;

    @Getter
    @Setter
    WebElement ScheduleTodays;

    public SchedulePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isCurrentDayHighlighted() {
        DayOfWeek currentDay = LocalDate.now().getDayOfWeek();
        String currentDayName = currentDay.getDisplayName(TextStyle.FULL, new Locale("ru"));
        WebElement currentDayElement = driver.findElement(
                By.xpath("//div[contains(@class, 'day') and contains(text(), '" + currentDayName + "') and contains(@class, 'highlighted')]"));
        return currentDayElement != null && currentDayElement.isDisplayed();
    }

}
