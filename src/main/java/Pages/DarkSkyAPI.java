package Pages;

import org.openqa.selenium.By;

public class DarkSkyAPI extends DarkskyHomePage {
    By login = By.xpath("//a[@class='button']");

    public void clickLogin()
    {
        clickOn(login);
    }

}
