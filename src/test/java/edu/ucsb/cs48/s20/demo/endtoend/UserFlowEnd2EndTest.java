package edu.ucsb.cs48.s20.demo.endtoend;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.ucsb.cs48.s20.demo.CommandLineRunner;

/**
 * This test runs a complete end-to-end test on the project as a single test.
 * Starts by logging in as a student, submitting a review, and reviewing 5 ideas
 *
 * If you are trying to duplicate this test in a project, make sure to copy the
 * html template under the test/resources/__files/ directory!
 */
@RunWith(SpringRunner.class)
// NOTE: properties="spring.datasource.name=XYZ" forces Spring Boot to run this test class with a fresh instance of the database.
// XYZ can be anything - just make it unique from other test classes for a fresh test db (loaded from data.sql)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties="spring.datasource.name=userflowend2endtest")
public class UserFlowEnd2EndTest {

    /**
     * Sets up custom environment variables for this test class. This is the information for our fake oauth provider.
     */
    static {
        System.setProperty("spring.security.oauth2.client.provider.wiremock.authorization-uri", "http://localhost:8077/oauth/authorize");
        System.setProperty("spring.security.oauth2.client.provider.wiremock.token-uri", "http://localhost:8077/oauth/token");
        System.setProperty("spring.security.oauth2.client.provider.wiremock.user-info-uri", "http://localhost:8077/userinfo");
        System.setProperty("spring.security.oauth2.client.provider.wiremock.user-name-attribute", "sub");
        System.setProperty("spring.security.oauth2.client.registration.wiremock.provider", "wiremock");
        System.setProperty("spring.security.oauth2.client.registration.wiremock.authorization-grant-type", "authorization_code");
        System.setProperty("spring.security.oauth2.client.registration.wiremock.scope", "email");
        System.setProperty("spring.security.oauth2.client.registration.wiremock.redirect-uri", "http://localhost:8080/login/oauth2/code/{registrationId}");
        System.setProperty("spring.security.oauth2.client.registration.wiremock.clientId", "wm");
        System.setProperty("spring.security.oauth2.client.registration.wiremock.clientSecret", "whatever");
        System.setProperty("newCity.googleMapKey","1");
    }

    private WebDriver webDriver;

    @Autowired
    private CommandLineRunner cmr;

    @Before
    public void setUp() {
        // Setup ChromeDriver (aided by the WebDriverManager)
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        webDriver = new ChromeDriver(options);

        // Setup the database
        cmr.loadDataFromFile("sheet.csv");
    }

    /**
     * Tear down the webDriver (the automated clicker)
     */
    @After
    public void reset() {
        if (webDriver != null) {
            webDriver.close();
        }
    }

    @Test
    public void testMapExists() {
        // Navigate to home page
        webDriver.get("http://localhost:8080/");
        // Make sure we are not redirected
        assert(webDriver.getCurrentUrl().equalsIgnoreCase("http://localhost:8080/"));

        // Click map button
        webDriver.findElement(By.linkText("Map")).click();

        // Make sure we are on map page
        assert(webDriver.getCurrentUrl().equalsIgnoreCase("http://localhost:8080/map"));
    }

    @Test
    public void testFiltering() {
        // Navigate to home page
        webDriver.get("http://localhost:8080/");
        // Make sure we are not redirected
        assert(webDriver.getCurrentUrl().equalsIgnoreCase("http://localhost:8080/"));

        // Click filter button
        webDriver.findElement(By.linkText("Filter")).click();

        // Make sure we are on filter page
        assert(webDriver.getCurrentUrl().equalsIgnoreCase("http://localhost:8080/county/search"));

        // Fill out filters (using .sendKeys)

        
        // Submit the form

        // Check the values in the resulting table...
    }

}