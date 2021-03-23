package StepDefinition;

import Pages.HotelsHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static StepDefinition.SharedSD.getDriver;

public class HotelsSD {

    HotelsHomePage hotelsHomePage = new HotelsHomePage();

    @Given("^I am on hotels.com home page$")
    public void i_am_on_hotelscom_home_page() throws Throwable {

        Assert.assertEquals("This is not hotels.com page",
                "Hotels.com India",
                getDriver().getTitle());

    }

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen()  {

        hotelsHomePage.setCity("Mumbai, India");

    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars) throws Throwable {

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {

    }

}
