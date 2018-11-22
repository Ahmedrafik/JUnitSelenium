package environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnvironmentManager {


    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER") + "/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
        RunEnvironment.setWebDriver(driver);
    }


    public static void shutDownDriver() {
        RunEnvironment.getWebDriver().quit();
    }
}
