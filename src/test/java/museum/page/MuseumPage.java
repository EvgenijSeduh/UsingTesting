package museum.page;

import baseConfig.BasePage;
import lombok.Getter;
import museum.DataConvertor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MuseumPage extends BasePage {
    private LocalDate currenDate = LocalDate.now();
    @Getter
    @FindBy(xpath = "//a[@class = 'dropdown-toggle' and @href='#mm2']")
    private WebElement buttonForVisitors;

    @Getter
    @FindBy(xpath = "//a[@href='/projects/exhibition' and text() = 'Выставки 2024']")
    private WebElement buttonAllExhibition;

    @Getter
    @FindBy(xpath = "/html/body/div[3]/div/div[1]/div[2]/div")
    private List<WebElement> exhibitionList;

    @Getter
    @FindBy(xpath = "//a[@href='/projects/constant-exp/info#path' and text() = 'КАК ДО НАС ДОБРАТЬСЯ?']")
    private WebElement buttonHowToReachUs;

    @Getter
    @FindBy(xpath = "//div[@id='home']")
    private WebElement TextWithTel;

    @Getter
    @FindBy(xpath = "//a[@class = 'dropdown-toggle' and @href='#mm4']")
    private WebElement buttonAboutMuseum;

    @Getter
    @FindBy(xpath = "//a[@href='/section/godovye-otchety' and text() = 'Годовые отчеты']")
    private WebElement buttonAnnualReports;

    @Getter
    @FindBy(xpath = "//a//h3[contains(text(),'2013')]")
    private WebElement buttonReport;

    @Getter
    @FindBy(xpath = "//a[@href='/docs/2013/report-2013.pdf']")
    private WebElement linkOnDocument;





    public MuseumPage() {
        driver.get("https://www.darwinmuseum.ru/");
        PageFactory.initElements(driver, this);
    }

    public LocalDate exhibitionGetDate(WebElement exhibitionCard) {
        String strDataAndName = exhibitionCard.findElement(By.xpath(".//div[@class='view_thum_date']")).getText();
        String[] arrStrDatePeriod = strDataAndName.split("\n");
        String[] arrStrDate = arrStrDatePeriod[0].split("—");
        String[] arrDate = arrStrDate[1].trim().split(" ");
        return convertStringArrToDate(arrDate);
    }


    private LocalDate convertStringArrToDate(String[] arrDate) {
        return LocalDate.of(Integer.parseInt(arrDate[2]), DataConvertor.getNumberMonth(arrDate[1].trim()), Integer.parseInt(arrDate[0]));
    }

    public boolean itLaterToday(LocalDate date) {
        return date.isAfter(LocalDate.now());

    }

    public void openExhibition() {
        logAndClick(buttonForVisitors);
        logAndClick(buttonAllExhibition);
    }

    public void openHowToReachUs() {
        logAndClick(buttonForVisitors);
        logAndClick(buttonHowToReachUs);
    }

    public boolean checkTel(String nameAndNumber) {
        if(TextWithTel.getText().indexOf(nameAndNumber)==-1)
            return false;
        return true;
    }

    public void openAnnualReports(){
        logAndClick(buttonAboutMuseum);
        logAndClick(buttonAnnualReports);
    }

    public void openReport(){
        logAndClick(buttonReport);
    }

    public void openLinkReport(){
        logAndClick(linkOnDocument);
    }

}
