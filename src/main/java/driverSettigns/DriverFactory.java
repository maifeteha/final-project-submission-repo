package driverSettigns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static fileReaderManager.ReadFromFiles.getPropertyByKey;

public class DriverFactory {
    static WebDriver driver = null ;
    static String runMode = null;
    static String browser = null;
    static final String PROPERTIES_FILE_NAME = "execution.properties" ;
    public static WebDriver getDriver ()
    {
        runMode = getPropertyByKey(PROPERTIES_FILE_NAME, "RUN_MODE");
        if (runMode.equalsIgnoreCase("local"))
        {
            browser = getPropertyByKey(PROPERTIES_FILE_NAME, "BROWSER");
            if (browser.equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().setup() ;
                driver = new ChromeDriver();
            }
            else if (browser.equalsIgnoreCase("edge"))
            {
                WebDriverManager.edgedriver().setup() ;
                driver = new EdgeDriver();
            }
            else if (browser.equalsIgnoreCase("firefox"))
            {
                WebDriverManager.firefoxdriver().setup() ;
                driver = new FirefoxDriver();
            }
            else {
                System.out.println("Not supported browser");
            }
        }
        else if (runMode.equalsIgnoreCase("docker"))
        {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName(getPropertyByKey(PROPERTIES_FILE_NAME, "BROWSER"));
            caps.setPlatform(Platform.LINUX);
            try {
                driver = new RemoteWebDriver(new URL(getPropertyByKey(PROPERTIES_FILE_NAME, "DOCKER_ADDRESS")), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else if (runMode.equalsIgnoreCase("browserstack"))
        {
            String URL = "https://" + getPropertyByKey(PROPERTIES_FILE_NAME, "BROWSER_STACK_USERNAME") + ":" +
                    getPropertyByKey(PROPERTIES_FILE_NAME, "BROWSER_STACK_ACCESS_KEY") + "@hub-cloud.browserstack.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "100");

        caps.setCapability("name", "AbdElAziz First Test");
            try {
                driver = new RemoteWebDriver(new URL(URL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;

    }

}
