package Pages;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static StepDefinition.SharedSD.getDriver;

public class HotelsSearchResult extends Base{

    By starText = By.xpath("//span[contains(@class,'star-rating-text')]");

    By distancetextRow = By.xpath("//ul[@class='property-landmarks']//li[2]");

    public ArrayList<Double> getAirposrDistances()
    {
        List<String> distRowList = getElementTextList(distancetextRow);

        ArrayList<Double> distList = new ArrayList<>();
        for(int i=0;i<distRowList.size();i++)
        {
          String distStr =   distRowList.get(i).split(" ")[0]; //3.5 km to Chhatrapati Shivaji International Airport (BOM)
            double dist = Double.parseDouble(distStr);
            distList.add(dist);
        }

        return distList;
    }


    public ArrayList<String> getStarTextList()
    {
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       return getElementTextList(starText);

    }


    public void clickStarRatings(String starNumber)
    {
        getDriver().findElement(By.xpath("//input[@id='f-star-rating-"+starNumber+"']")).click();
    }
}
