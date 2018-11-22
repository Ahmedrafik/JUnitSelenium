package environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnvironmentManager {


    public static void initWebDriver() {
        System.setProperty("webdriver.gecko.driver", System.getenv("FIREFOX_DRIVER") + "/geckodriver");
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("useAutomationExtension", false);
        WebDriver driver = new FirefoxDriver();
        RunEnvironment.setWebDriver(driver);
    }

    public static void shutDownDriver() {
        RunEnvironment.getWebDriver().quit();
    }
}
