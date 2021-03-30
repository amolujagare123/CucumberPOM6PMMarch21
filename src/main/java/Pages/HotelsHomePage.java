package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static StepDefinition.SharedSD.getDriver;

public class HotelsHomePage extends Base {

    By searchCity = By.xpath("//input[@id='qf-0q-destination']");
    By btnSearch = By.xpath("//button[@type='submit']");

    By roomDropDown = By.xpath("//select[@id='qf-0q-rooms']");

    By dropDownRows = By.xpath("//div[contains(@class,'widget-query-room-options')]");

    public int getNumberOfDropDowns()
    {
       return getDriver().findElements(dropDownRows).size();
    }


    public void setRoomDropDwon(String rooms)
    {
        selectFromDropdown(roomDropDown,rooms);
    }

    public void clickBtnSearch()
    {
        clickOn(btnSearch);
    }

    public void setCity(String city)
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement txtCity = webAction(searchCity);

        js.executeScript("arguments[0].setAttribute('value','"+city+"')",txtCity);

  }
}
