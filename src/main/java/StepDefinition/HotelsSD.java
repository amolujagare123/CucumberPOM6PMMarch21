package StepDefinition;

import Pages.HotelsHomePage;
import Pages.HotelsSearchResult;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;

import static StepDefinition.SharedSD.getDriver;

public class HotelsSD {

    HotelsHomePage hotelsHomePage = new HotelsHomePage();
    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Given("^I am on hotels.com home page$")
    public void i_am_on_hotelscom_home_page() throws Throwable {

        Assert.assertEquals("This is not hotels.com page",
                "Hotels.com India",
                getDriver().getTitle());

    }

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen()  {

        hotelsHomePage.setCity("Mumbai, India");
        hotelsHomePage.clickBtnSearch();

    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars) throws Throwable {

        // star -> "5 stars" ---> 5 |

        String starNumber = stars.split(" ")[0];

        hotelsSearchResult.clickStarRatings(starNumber);

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) // 5 stars
            {

                ArrayList<String> starTextList = hotelsSearchResult.getStarTextList();
                System.out.println(starTextList);

                // [5-star, 5-star, 5-star, 5-star, 5-star, 5-star, 5-star, 5-star, 5-star, 5-star, 5-star, 5-star]

                String starText = stars.split(" ")[0]+"-star";

                int occurance = Collections.frequency(starTextList,starText);
                int size = starTextList.size();

                boolean result = (occurance==size);

                Assert.assertTrue("All the ratings are not:"+starText,result);




    }


    @When("^I select (.+) from room dropdown$")
    public void i_select_from_room_dropdown(String selectrooms) {

        hotelsHomePage.setRoomDropDwon(selectrooms);

    }

    @Then("^I verify (.+) room drop downs are/ is displayed$")
    public void i_verify_room_drop_downs_are_is_displayed(String numberofroomdropdown) throws Throwable {

        int expectedDropDowns = Integer.parseInt(numberofroomdropdown);

        int actualDropDowns = hotelsHomePage.getNumberOfDropDowns();

        System.out.println("expected="+expectedDropDowns);
        System.out.println("actual="+actualDropDowns);


        Assert.assertEquals("Wrong number of room dropdowns",expectedDropDowns,actualDropDowns);



    }

    @Then("^I verify system displays all hotels within \"([^\"]*)\" Km radius of airport$")
    public void i_verify_system_displays_all_hotels_within_something_km_radius_of_airport(String expectedDistStr)
             {
                 double expectedDist = Double.parseDouble(expectedDistStr);

                 ArrayList<Double> distList = hotelsSearchResult.getAirposrDistances();

                 System.out.println(distList);

                 boolean flag = true;

                 for(int i=0;i<distList.size();i++)
                 {
                     if(distList.get(i)>expectedDist)
                     {
                          flag = false;
                     }

                 }

                 Assert.assertTrue("some distances are greater than:"+expectedDistStr,flag);


    }

    @And("^I verify \"([^\"]*)\" is within radius$")
    public void i_verify_something_is_within_radius(String expectedHotel)
    {

        ArrayList<String> hotelsList = hotelsSearchResult.getHotelNames();

        /*for(int i=0;i<hotelsList.size();i++)
        {
            System.out.println(hotelsList.get(i));
        }*/

        boolean flag = false;

        for(String hotelName : hotelsList) // for each
        {
            System.out.println(hotelName);

            if(hotelName.contains(expectedHotel))
                flag =true;
        }

        Assert.assertTrue(expectedHotel+": this hotel is not there in the search result",flag);
    }

    @Then("^I verify todays deal is less than \"([^\"]*)\" rs$")
    public void i_verify_todays_deal_is_less_than_something_rs(String expectedDealPriceStr)  {

        int expectedDealPrice =Integer.parseInt(expectedDealPriceStr); // 5000

        ArrayList<Integer> priceList = hotelsSearchResult.getDealPriceList();
        System.out.println(priceList);

        boolean flag = true;

        for(Integer actualDealPrice : priceList)
        {
            if(actualDealPrice>expectedDealPrice)
                flag = false;
        }

        Assert.assertTrue("some deal prices are greater than:"+expectedDealPriceStr,flag);

    }

}
