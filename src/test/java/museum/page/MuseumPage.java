package museum.page;

import baseConfig.BasePage;
import org.openqa.selenium.support.PageFactory;

public class MuseumPage extends BasePage {
    public MuseumPage() {
        driver.get("https://mospolytech.ru/ ");
        PageFactory.initElements(driver,this);
    }
}
