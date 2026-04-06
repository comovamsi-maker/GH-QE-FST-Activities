package Appium;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions; // Recommended for use with wait
import java.time.Duration; // Necessary for Duration.ofSeconds()
import java.util.Map;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;



public class Activity4 {
    AndroidDriver driver;

@BeforeClass
public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
UiAutomator2Options options = new UiAutomator2Options();
options.setPlatformName("android");
options.setAutomationName("UiAutomator2");
options.setAppPackage("com.google.android.contacts");
options.setAppActivity("com.android.contacts.activities.PeopleActivity");

// Server Address
        URL serverURL = new URI("http://127.0.0.1:4723/").toURL();
// Driver Initialization
driver = new AndroidDriver(serverURL, options);
    }


@Test
public void addNew() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

    // Click Create Contact
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.accessibilityId("Create contact"))).click();

    // First Name
    wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.xpath("//android.widget.EditText[@text='First name']")))
            .sendKeys("shrenu");

    // Last Name
    wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.xpath("//android.widget.EditText[@text='Last name']")))
            .sendKeys("MS");

    // Company
    wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[4]/android.widget.EditText")))
            .sendKeys("IBM");

    // Click on country dropdown (USA flag)
    wait.until(ExpectedConditions.elementToBeClickable(
        AppiumBy.xpath("//android.widget.TextView[@text='🇺🇸']")))
        .click();
wait.until(ExpectedConditions.elementToBeClickable(
    driver.findElement(AppiumBy.androidUIAutomator(
    "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\"))" +
    ".setMaxSearchSwipes(20)" +
    ".scrollIntoView(new UiSelector().description(\"India +91\"))")))).click();

   // driver.findElement(AppiumBy.accessibilityId("India +91")).click();

    

    // Enter Phone Number

    wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.xpath("//android.widget.EditText[@text='+91']")))
            .sendKeys("6372028930");

    // Click Save
    wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button")))
            .click();
}

@AfterClass
public void tearDown() {
    driver.quit();
}
}

