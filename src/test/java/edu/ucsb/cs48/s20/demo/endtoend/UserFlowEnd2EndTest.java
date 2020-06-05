package edu.ucsb.cs48.s20.demo.endtoend;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void testFiltering() {
        // Navigate to home page
        webDriver.get("http://localhost:8080/county/search");
        // Make sure we are not redirected
        assert(webDriver.getCurrentUrl().equalsIgnoreCase("http://localhost:8080/county/search"));

        // Fill out filters (using .sendKeys)
        webDriver.findElement(By.id("minincome")).sendKeys("1000");
        webDriver.findElement(By.id("maxincome")).sendKeys("10000");
        webDriver.findElement(By.id("minhousecost")).sendKeys("100000");
        webDriver.findElement(By.id("maxhousecost")).sendKeys("1000000");

        // Submit the form
        webDriver.findElement(By.id("submitid")).click();

        // Check the values in the resulting table...
        List<WebElement> rows = webDriver.findElements(By.cssSelector("[class='bootstrap-table table table-bordered table-hover'] tr"));
        
        assertEquals(5,rows.size());

        assertTrue(rows.get(1).getText().contains("Marin"));
        assertTrue(rows.get(2).getText().contains("San Francisco"));
        assertTrue(rows.get(3).getText().contains("San Mateo"));
        assertTrue(rows.get(4).getText().contains("Santa Clara"));
    }

    @Test
    public void testSurvey() {
        // Navigate to home page
        webDriver.get("http://localhost:8080/survey");
        // Make sure we are not redirected
        assert(webDriver.getCurrentUrl().equalsIgnoreCase("http://localhost:8080/survey"));

        // Fill out survey
        webDriver.findElement(By.id("slabel1")).click();
        webDriver.findElement(By.id("slabel11")).click();
        webDriver.findElement(By.id("slabel21")).click();
        webDriver.findElement(By.id("slabel33")).click();
        webDriver.findElement(By.id("slabel43")).click();
        webDriver.findElement(By.id("slabel53")).click();
        webDriver.findElement(By.id("slabel63")).click();

        // Submit the form
        webDriver.findElement(By.id("submitid2")).click();

        // Check the values in the resulting table...
        List<WebElement> rows2 = webDriver.findElements(By.cssSelector("[class='bootstrap-table table table-bordered table-hover'] tr"));

        assertEquals(4,rows2.size());
        
        assertTrue(rows2.get(1).getText().contains("Santa Clara"));
        assertTrue(rows2.get(2).getText().contains("Los Angeles"));
        assertTrue(rows2.get(3).getText().contains("Modoc"));
        
    }
    

}