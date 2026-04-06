package seleniumAct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class FlipKart {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.flipkart.com/account/login?ret=...");
        System.out.println(driver.getTitle());




        // use CSS selector for both classes
        //driver.findElement(By.cssSelector(".c3Bd2c.yXUQVt")).sendKeys("6372028930");

        // use CSS selector for both classes
       //driver.findElement(By.cssSelector(".c3Bd2c.yXUQVt")).sendKeys("6372028930");

       //driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input")).sendKeys("6372028930");

       ////input[contains(@class,'c3Bd2c') and contains(@class,'yXUQVt')]

       // wait until button is clickable, then click
       //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Request OTP']"))).click();



        //System.out.print(driver.getCurrentUrl());

        //WebElement element = driver.findElement(By.id("seo--footernull"));
        //System.out.println(element.getText()); 

        //driver.manage().window().maximize();


        //driver.quit();


    
    }
}
