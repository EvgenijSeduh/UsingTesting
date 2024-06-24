package mosPolytech.page;

import baseConfig.BasePage;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MosPolytechPage extends BasePage {
    @Getter
    @FindBy(xpath = "//a[@href='/obuchauschimsya/raspisaniya/']//i[@class='icon is-large']")
    WebElement buttonSchedule;

    @Getter
    @FindBy(xpath = "//a[@href='https://rasp.dmami.ru/session']")
    WebElement buttonSeeScheduleOnWebsite;

    public MosPolytechPage() {
        driver.get("https://mospolytech.ru/ ");
        PageFactory.initElements(driver, this);
    }

    @Step("Open new tabs")
    public void openScheduleTab() {
        logAndClick(buttonSchedule);
    }

    @Step("Open new window")
    public void openScheduleInNewWindow() {
        moveToElement(buttonSeeScheduleOnWebsite);
        logAndClick(buttonSeeScheduleOnWebsite);
    }
}
