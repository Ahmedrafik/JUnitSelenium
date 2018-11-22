package environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EnvironmentManager {


    public static void initWebDriver() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER") + "/chromedriver");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:8081/"), capability);

//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("useAutomationExtension", false);
//        WebDriver driver = new ChromeDriver(options);
        RunEnvironment.setWebDriver(driver);
    }

    public static void shutDownDriver() {
        RunEnvironment.getWebDriver().quit();
    }
}
