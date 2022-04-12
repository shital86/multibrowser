package multiBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class HerokuApp {
    static String browser="Chrome";
    static String baseUrl="http://the-internet.herokuapp.com/login";
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
        String title= driver.getTitle();
        System.out.println(title);
        System.out.println("Current Url:" +driver.getCurrentUrl());
        WebElement usernameField= driver.findElement(By.id("username"));
        System.out.println(usernameField);
        usernameField.sendKeys("tomsmith");
        WebElement passwordField= driver.findElement(By.name("password"));
        System.out.println(passwordField);
        passwordField.sendKeys("SuperSecretPassword!");
        System.out.println(driver.getPageSource());
        driver.close();
    }
}
