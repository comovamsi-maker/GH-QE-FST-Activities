package seleniumAct;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.appium.java_client.AppiumBy.ById;


public class FlipKart2 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.thesouledstore.com/men/polo-tshirts");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement profile = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/nav/div/div[3]/div/ul/li[2]/span/span/img"));
                                                           

        profile.click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/ul/li[2]/span")).click();
 
        WebElement firstName = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/form/div[1]/div[1]/input"));
        firstName.sendKeys("vamsi");

        WebElement lastName = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/form/div[1]/div[2]/input"));
        lastName.sendKeys("veera");

        WebElement email = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/form/div[2]/div/input"));
        email.sendKeys("como.vamsi@gmail.com");
       
        WebElement newPassword = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/form/div[3]/div/div[1]/div/input"));
        newPassword.sendKeys("Vamsi@100");

        WebElement conformPassword = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/form/div[4]/div/div[1]/div/input"));
        conformPassword.sendKeys("Vamsi@100");
        
        // Step 1: Click Date of Birth field
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/form/div[5]/div[1]/div[1]/div[1]/input")).click();

        String targetMonthYear = "Mar 2002";

        while(true)
        {
            String displayedMonthYear = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/form/div[5]/div[1]/div[1]/div[2]/header/span[2]")).getText();

            if(displayedMonthYear.equals(targetMonthYear))
            {
                break;
            }
            else
            {
                // click previous arrow
                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/form/div[5]/div[1]/div[1]/div[2]/header/span[1]")).click();
            }
        }

        // select date
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/form/div[5]/div[1]/div[1]/div[2]/div/span[20]")).click();

        WebElement phone = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/form/div[6]/div/div/input"));
        phone.sendKeys("8867075103");        

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/form/div[7]/label/label[1]")).click();


        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/form/button")).click();
       



    }
    
}


 