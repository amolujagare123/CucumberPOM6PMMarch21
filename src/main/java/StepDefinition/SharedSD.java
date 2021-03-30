package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ConfigReader;

import java.io.IOException;

public class SharedSD {

    public static WebDriver driver;

    @Before
    public void openUrl() throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());
    }

    @After
    public void closeBrowser()
    {
      //  driver.close();
    }

    public static  WebDriver getDriver()
    {
        return driver;
    }

}
