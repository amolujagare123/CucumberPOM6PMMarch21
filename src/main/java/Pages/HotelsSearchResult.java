package Pages;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static StepDefinition.SharedSD.getDriver;

public class HotelsSearchResult extends Base{

    By starText = By.xpath("//span[contains(@class,'star-rating-text')]");

    By distancetextRow = By.xpath("//ul[@class='property-landmarks']//li[2]");

    By hotelsNames = By.xpath("//a[@class='property-name-link']");

    By dealPricetext = By.xpath("//ins");


    public ArrayList<Integer> getDealPriceList()
    {
       ArrayList<String> priceTextRowList = getElementTextList(dealPricetext); // Rs3,200

        ArrayList<Integer> numberList = new ArrayList<>();
        for(String priceTextRow : priceTextRowList)
        {
            System.out.println(priceTextRow);
           
            //String priceTextRow = "Rs3,200";

            String priceWithoutRs = priceTextRow.substring(2); // 3,200

            String[] numberParts = priceWithoutRs.split(","); // {"3","200"}

            String numberFinalStr ="";

            for(String number : numberParts)
            {
                numberFinalStr = numberFinalStr +number;
            }

            int numberFinal = Integer.parseInt(numberFinalStr) ; // 3200
            System.out.println(numberFinal);
            
            numberList.add(numberFinal);
        }
        return  numberList;
    }


    public  ArrayList<String> getHotelNames()
    {
        return getElementTextList(hotelsNames);
    }

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
