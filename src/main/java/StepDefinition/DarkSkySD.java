package StepDefinition;

import Pages.DarkskyHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;

import static StepDefinition.SharedSD.getDriver;

public class DarkSkySD {


    DarkskyHomePage darkskyHomePage = new DarkskyHomePage();


    @Given("^I am on Darksky Home Page$")
    public void i_am_on_darksky_home_page() {

        Assert.assertEquals("This is not darksky home page",
               "Dark Sky - Sansad Marg, New Delhi, Delhi",
                getDriver().getTitle());

    }

    @Then("^I verify current temp is equal to Temperature from Daily Timeline$")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline()
            {

                int expected = darkskyHomePage.getCurrentTemp();

                System.out.println("current temp="+expected);

                int actual = darkskyHomePage.getTimeLineTemp();

                System.out.println("Timeline temp="+actual);


                Assert.assertEquals("Both temperatures are not equal",expected,actual);

    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented()
             {

                 ArrayList<Integer> timeList = darkskyHomePage.getTimeList();

                 ArrayList<Integer> timeDiffList = new ArrayList<>();

                 //boolean flag;
                 for(int i=0;i<timeList.size()-1;i++)
                 {
                     int time1 = timeList.get(i);
                     int time2 = timeList.get(i+1);
                     int timeDiff = 0;

                     if(time1<time2)
                        timeDiff = time2-time1;
                     if(time1> time2)
                         timeDiff = (time2+12)-time1;

                    /* if(timeDiff !=2)
                         flag =false;*/

                    timeDiffList.add(timeDiff);

                 }

                 System.out.println(timeDiffList);

                 int size = timeDiffList.size(); //10

                 int occarance = Collections.frequency(timeDiffList,2);

                 boolean result = (size==occarance) ; // true / false

                 Assert.assertTrue("all the differnces are not 2",result);

    }


    @Then("^I verify today's lowest and highest temp is displayed correctly$")
    public void i_verify_todays_lowest_and_highest_temp_is_displayed_correctly()
            {

                darkskyHomePage.clickToggleDay1();

                ArrayList<String> expected = darkskyHomePage.getBarTempList();
                System.out.println("expected="+expected);
                ArrayList<String> actual = darkskyHomePage.getTimeLineTempList();
                System.out.println("Actual="+actual);

                Assert.assertEquals("temperatures are not correct",expected,actual);

            }

}
