package multiBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class NopCommerce {
    static String browser="Chrome";
    static String baseUrl="https://demo.nopcommerce.com/";
    static WebDriver driver;
    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver=new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            driver=new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
            driver=new InternetExplorerDriver();
        }else {
            System.out.println("Wrong Browser name");
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("The Page Resource: "+driver.getPageSource());
        String title = driver.getTitle();
        System.out.println("Title of the Page:" + title);
        System.out.println("Current Url:" + driver.getCurrentUrl());
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl);
        WebElement emailField = driver.findElement(By.id("Email"));
        System.out.println(emailField);
        emailField.sendKeys("xyz@yahoo.co.uk");
        WebElement passwordField = driver.findElement(By.name("Password"));
        System.out.println(passwordField);
        passwordField.sendKeys("Happy");
        driver.close();
    }
}
