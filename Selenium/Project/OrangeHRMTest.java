package OrangeHRM;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;



import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

public class OrangeHRMTest {

    WebDriver driver;
    WebDriverWait wait;
    String baseUrl = "https://alchemy.hguy.co/orangehrm/";

    

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    // 1. Verify website title
    @Test
    public void verifyTitle() {
        String title = driver.getTitle();
        System.out.println("Title:  VerifyTheWebsiteTitle.java:36 - OrangeHRMTest.java:41" + title);
        Assert.assertEquals(title, "OrangeHRM");
    }

    // 2. Get header image URL
    @Test
    public void getHeaderImageUrl() {
        WebElement logo = driver.findElement(By.xpath("//img[contains(@src,'logo')]"));
        String src = logo.getAttribute("src");
        System.out.println("Header Image URL:  VerifyTheWebsiteTitle.java:45 - OrangeHRMTest.java:50" + src);
    }

    // login method
    public void login() {
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
    }

    // 3. Login test
    @Test
    public void loginTest() {
        login();
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

@Test
public void addEmployee() throws InterruptedException {

    login();
/* */
    driver.findElement(By.id("menu_pim_viewPimModule")).click();
    driver.findElement(By.id("menu_pim_viewEmployeeList")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Step 1: Enter name
    WebElement input = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("empsearch_employee_name_empName"))
    );
    input.click();
    input.clear();
    input.sendKeys("Veera");

    // Step 2: Wait for dropdown and select
    WebElement option = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='ac_results']//li")
            )
    );
    option.click();

    // Step 3: Wait until value is populated
    wait.until(ExpectedConditions.attributeContains(
            By.id("empsearch_employee_name_empName"),
            "value",
            "Veera"
    ));

    // Step 4: Click Search
    wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn"))).click();

    // Step 5: Validate from TABLE (correct locator)
    WebElement table = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("resultTable"))
    );

    String tableText = table.getText();
    System.out.println("Table Data: - OrangeHRMTest.java:111" + tableText);

    Assert.assertTrue(tableText.contains("Veera"));


    }

    
}



