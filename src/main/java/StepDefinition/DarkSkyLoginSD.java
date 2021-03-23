package StepDefinition;

import Pages.DarkSkyAPI;
import Pages.DarkSkyLogin;
import Pages.DarkskyHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static StepDefinition.SharedSD.getDriver;

public class DarkSkyLoginSD {

    DarkskyHomePage darkskyHomePage = new DarkskyHomePage();
    DarkSkyAPI darkSkyAPI = new DarkSkyAPI();
    DarkSkyLogin darkSkyLogin = new DarkSkyLogin();

    @Given("^I am on the darksky Login page$")
    public void i_am_on_the_darksky_login_page()  {
       darkskyHomePage.clickDarkskyAPI();
       darkSkyAPI.clickLogin();
    }

    @When("^I click on Login button$")
    public void i_click_on_login_button() {
        darkSkyLogin.clickLoginSubmit();
    }

    @Then("^I verify I am on Login page by asserting Login page title$")
    public void i_verify_i_am_on_login_page_by_asserting_login_page_title()  {

        String expected = "Dark Sky API: Log In";
        String actual = getDriver().getTitle();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals("this is not a login page",expected,actual);

    }

}
