package mosPolytech.page;

import baseConfig.BasePage;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MosPolytechPage extends BasePage {
    @Getter
    @FindBy(xpath = "//button[@class = 'hamburger']")
    WebElement buttonMenu;

    @Getter
    @FindBy(xpath = "/html/body/header/nav/div[2]/div/ul[1]/li[2]/ul/li[3]/a")
    WebElement buttonSchedule;

    @Getter
    @FindBy(xpath = "/html/body/header/nav/div[2]/div/ul[1]/li[2]/a")
    WebElement buttonForStudents;

    @Getter
    @FindBy(xpath = "//a[@href='https://rasp.dmami.ru/session']")
    WebElement buttonSeeScheduleOnWebsite;

    public MosPolytechPage() {
        driver.get("https://mospolytech.ru/ ");
        PageFactory.initElements(driver,this);
    }

    public void openScheduleTab(){
        logAndClick(buttonMenu);
        waitToClickable(buttonForStudents);
        moveToElement(buttonForStudents);
        logAndClick(buttonSchedule);
    }

    public void openScheduleInNewWindow(){
        moveToElement(buttonSeeScheduleOnWebsite);
        logAndClick(buttonSeeScheduleOnWebsite);
    }
//    //*[@id="bx_3777608605_2854"]/div[3]/div/div[1]/a
    //a[@title = "Обучающимся" ]
    //a[@title = "Расписания"] && class="main-nav__item-link"
    //<a href="/obuchauschimsya/raspisaniya/" class="main-nav__item-link active" title="Расписания" target="_self">Расписания</a>
}
