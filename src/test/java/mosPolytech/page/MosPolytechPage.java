package mosPolytech.page;

import baseConfig.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MosPolytechPage extends BasePage {
    @Getter
    WebElement buttonMenu;

    @Getter
    WebElement buttonSchedule;

    @Getter
    WebElement buttonForStudents;
    public MosPolytechPage() {
        driver.get("https://mospolytech.ru/ ");
        buttonMenu = driver.findElement(By.xpath("//button[@class = 'hamburger']"));
        buttonSchedule = driver.findElement(By.xpath("//a[@title = 'Расписания']"));
        buttonForStudents = driver.findElement(By.xpath("//a[@title = 'Обучающимся' ]"));
    }
    //a[@title = "Обучающимся" ]
    //a[@title = "Расписания"]
    //<a href="/obuchauschimsya/raspisaniya/" class="main-nav__item-link active" title="Расписания" target="_self">Расписания</a>
}
