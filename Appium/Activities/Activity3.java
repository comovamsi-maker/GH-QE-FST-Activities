package Appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class Activity3 {
    
     AndroidDriver driver;
     
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setApp("C:\\Users\\VamsiVeera\\Downloads\\Calculator.apk");
        options.noReset();

        // Server Address
        URL serverURL = new URI("http://127.0.0.1:4723/").toURL();

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

//Calculate 5 + 9 and print the result to the console.
@Test
public void addition() {
    // 1. Perform the clicks
    driver.findElement(AppiumBy.accessibilityId("clear")).click();
    driver.findElement(AppiumBy.accessibilityId("5")).click();
    driver.findElement(AppiumBy.accessibilityId("plus")).click();
    driver.findElement(AppiumBy.accessibilityId("9")).click();
    driver.findElement(AppiumBy.accessibilityId("equals")).click();

    // 2. Capture the result as a String
    // Note: Replaced accessibilityId with className for the generic TextView
    String result = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();

    // 3. Validation (Standard Assertions)
    Assertions.assertEquals(result, "14", "Addition Test Failed at ! Expected 14 but got: "+ result);
    System.out.println("Addition Test Passed: 5 + 9 = 14 - Activity3.java:52" + result);
    
    
}



//Calculate 10 - 5 and print the result to the console.
@Test
public void subtraction() {
    driver.findElement(AppiumBy.accessibilityId("clear")).click();
    // 1. Perform the clicks
    driver.findElement(AppiumBy.accessibilityId("1")).click();
    driver.findElement(AppiumBy.accessibilityId("0")).click();
    driver.findElement(AppiumBy.accessibilityId("minus")).click();
    driver.findElement(AppiumBy.accessibilityId("5")).click();
    driver.findElement(AppiumBy.accessibilityId("equals")).click();

    // 2. Capture the result as a String
    String result = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();

    // 3. Validation (Standard Assertions)
    Assertions.assertEquals(result, "5", "Subtraction Test Failed at ! Expected 5 but got: "+ result);
    System.out.println("Subtraction Test Passed: 10  5 = 5 - Activity3.java:75" + result);
    
}

//Calculate 5 * 100 and print the result to the console.
@Test
public void multiplication() {
    driver.findElement(AppiumBy.accessibilityId("clear")).click();
    // 1. Perform the clicks
    driver.findElement(AppiumBy.accessibilityId("5")).click();
    driver.findElement(AppiumBy.accessibilityId("multiply")).click();
    driver.findElement(AppiumBy.accessibilityId("1")).click();
    driver.findElement(AppiumBy.accessibilityId("0")).click();
    driver.findElement(AppiumBy.accessibilityId("0")).click();
    driver.findElement(AppiumBy.accessibilityId("equals")).click();

    // 2. Capture the result as a String
    String result = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();

    // 3. Validation (Standard Assertions)
    Assertions.assertEquals(result, "500", "Multiplication Test Failed at ! Expected 500 but got: "+ result);
    System.out.println("Multiplication Test Passed: 5 * 100 = 500 - Activity3.java:96" + result);
}

//Calculate 50 / 2 and print the result to the console.
@Test
public void division() {
    driver.findElement(AppiumBy.accessibilityId("clear")).click();
    // 1. Perform the clicks
    driver.findElement(AppiumBy.accessibilityId("5")).click();
    driver.findElement(AppiumBy.accessibilityId("0")).click();
    driver.findElement(AppiumBy.accessibilityId("divide")).click();
    driver.findElement(AppiumBy.accessibilityId("2")).click();
    driver.findElement(AppiumBy.accessibilityId("equals")).click();


    // 2. Capture the result as a String
    String result = driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
    
    // 3. Validation (Assertions standard)
    Assertions.assertEquals(result, "25", "Division Test Failed at ! Expected 25 but got: "+ result);
    System.out.println("Division Test Passed: 50 / 2 = 25 - Activity3.java:116");
   
}
 @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
