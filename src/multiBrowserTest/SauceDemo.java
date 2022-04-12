package multiBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class SauceDemo {
    static String browser="Chrome";
    static String baseUrl="https://www.saucedemo.com/";
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
        String title = driver.getTitle();//get the title for
        System.out.println("Page Title: " + title);
        System.out.println("Page Resource: " + driver.getPageSource());
        System.out.println("Current Url:" + driver.getCurrentUrl());
        WebElement usenameField = driver.findElement(By.id("user-name"));
        System.out.println(usenameField);
        usenameField.sendKeys("standard_user");
        // driver.close();//Close the browser
        WebElement passwordField = driver.findElement(By.name("password"));//sending password to password field element
        System.out.println(passwordField);
        passwordField.sendKeys("secret_sauce");
        driver.close();

    }
}
