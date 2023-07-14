package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;

public class DriverListener {
    public DriverListener() {}

    private static WebDriver driver;

    public static WebDriver getDriver()
    {
        return driver;
    }

    public static WebDriver initDriver() {
        String browser = System.getProperty("browser");

        switch (browser.toUpperCase())
        {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeDriverService chromeService = new ChromeDriverService.Builder()
                        .withLogOutput(System.out)
                        .build();
                driver = new ChromeDriver(chromeService);
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                EdgeDriverService edgeService = new EdgeDriverService.Builder()
                        .withLogOutput(System.out)
                        .build();
                driver = new EdgeDriver(edgeService);
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                FirefoxDriverService firefoxService = new GeckoDriverService.Builder()
                        .withLogOutput(System.out)
                        .build();
                driver = new FirefoxDriver(firefoxService);
                break;
            default:
                System.out.println("Unknown browser specified, defaulting to 'Google Chrome'...)");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(Constants.WEB_URL);
        return driver;
    }
    public WebElement getWebElement(By value){
        return driver.findElement(value);
    }
}
