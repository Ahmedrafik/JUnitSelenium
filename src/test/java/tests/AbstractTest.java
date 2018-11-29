package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;

public class AbstractTest {
    WebDriver driver;

    String urlToGo = "http://pc-jmf:8080/iovision/go?openPage=-94mbeq8hwf1hq6e7he3h2p25xt94bh9alkj6lg5lbfi00i9ykb27q5v6obp3unjjmi5ijyaloyteab9ogykke52vaogbi78yv3mk";

    @Before
    public void setUp() {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
    }

    @After
    public void tearDown() {
        WebElement element = driver.findElement(xpath("(.//*[normalize-space(text()) and normalize-space(.)='Import'])[1]/following::span[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        EnvironmentManager.shutDownDriver();
    }

}
