package Pages;

import org.openqa.selenium.By;

public class DarkSkyLogin extends DarkSkyAPI {

    By loginSubmit = By.xpath("//button[@type='submit']");

    public void clickLoginSubmit()
    {
        clickOn(loginSubmit);
    }


}
