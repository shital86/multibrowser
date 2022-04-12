package multiBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class UltimatEqa {
    static String browser="Chrome";
    static String baseUrl="https://courses.ultimateqa.com/users/sign_in";
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
        System.out.println("Page Title: " +title);
        System.out.println("Page Resource: " +driver.getPageSource());
        System.out.println("Current Url:" + driver.getCurrentUrl());
        WebElement emailField = driver.findElement(By.id("user[email]"));
        System.out.println(emailField);
        emailField.sendKeys("ab@yahoo.com");
        WebElement passwordField = driver.findElement(By.name("user[password]"));//sending password to password field element
        System.out.print(passwordField);
        passwordField.sendKeys("Welcome1");
        driver.close();

    }
}
