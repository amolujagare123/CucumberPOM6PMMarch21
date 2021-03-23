package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

import static StepDefinition.SharedSD.getDriver;

public class DarkskyHomePage extends Base{

    By currentTempText = By.xpath("//span[@class='summary swap']");
    By timelineTempText = By.xpath("//span[@class='first']//span");

    By timeRowList = By.xpath("//span[@class='hour']/span");

    By toggleButton1 = By.xpath("//a[@data-day='0']//span[@class='toggle']");

    By barMaxTemp = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");
    By barMinTemp = By.xpath("//a[@data-day='0']//span[@class='minTemp']");

    By timeLineMaxTemp = By.xpath("//div[contains(@class,'revealed')]//span[contains(@class,'lowTemp')]//span[@class='temp']");
    By timeLineMinTemp = By.xpath("//div[contains(@class,'revealed')]//span[contains(@class,'highTemp')]//span[@class='temp']");
    By lnkDarkskyAPI = By.xpath("//a[normalize-space()='Dark Sky API']");

    public void clickDarkskyAPI()
    {
        clickOn(lnkDarkskyAPI);
    }


    public ArrayList<String> getTimeLineTempList()
    {
       ArrayList<String> tempList = new ArrayList<>();

       tempList.add(getTextFromElement(timeLineMinTemp).split("˚")[0]); // 77˚min temp
       tempList.add(getTextFromElement(timeLineMaxTemp).split("˚")[0]); //97˚  max temp

        return tempList;
    }


    public ArrayList<String> getBarTempList()
    {
        ArrayList<String> tempList = new ArrayList<>();

        tempList.add(getTextFromElement(barMinTemp).split("˚")[0]); // min temp
        tempList.add(getTextFromElement(barMaxTemp).split("˚")[0]); // max temp

        return tempList;
    }

    public  void  clickToggleDay1()
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,800)");

        clickOn(toggleButton1);
    }


    public ArrayList<Integer> getTimeList()
    {
        ArrayList<String> timeListRow = getElementTextList(timeRowList);
        System.out.println(timeListRow);

        ArrayList<Integer> timeList = new ArrayList<>();

        for(int i=0; i<timeListRow.size();i++)
        {

            String timeRow = timeListRow.get(i);

            int l = timeRow.length();

            String timeStr = timeRow.substring(0,l-2);

            int time = Integer.parseInt(timeStr);

            timeList.add(time);
        }

        System.out.println(timeList);

        return timeList;
    }


    public int getCurrentTemp()
    {
        String tempRowStr = getTextFromElement(currentTempText);
        // 90˚ Overcast.

        String tempStr=tempRowStr.split("˚")[0];

        int temp = Integer.parseInt(tempStr);

        return temp;
    }

    public int getTimeLineTemp()
    {
        String tempRowStr = getTextFromElement(timelineTempText);
        // 93°

        String tempStr=tempRowStr.split("°")[0];

        int temp = Integer.parseInt(tempStr);

        return temp;
    }

}
