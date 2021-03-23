package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static StepDefinition.SharedSD.getDriver;

public class HotelsHomePage extends Base{

    By searchCity = By.xpath("//input[@id='qf-0q-destination']");

    public void setCity(String city)
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement txtCity = webAction(searchCity);

        js.executeScript("arguments[0].setAttribute('value','"+city+"')",txtCity);

  }
}
