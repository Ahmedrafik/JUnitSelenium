package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class IoceanTest {
  private WebDriver driver;

  @Before
  public void setUp() {
      EnvironmentManager.initWebDriver();
      driver = RunEnvironment.getWebDriver();
  }

  @Test
  public void test2() {
      driver.get("http://wikipedia.fr/index.php");
      driver.findElement(By.id("Search")).clear();
      driver.findElement(By.id("Search")).sendKeys("software");
      driver.findElement(By.id("Search")).sendKeys(Keys.ENTER);
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Wikiwix'])[1]/following::p[1]")).click();
      driver.findElement(By.linkText("Brøderbund Software")).click();
//      assertEquals("Brøderbund Software", driver.findElement(By.id("firstHeading")).getText());

  }

  @After
  public void tearDown() {
      EnvironmentManager.shutDownDriver();
  }

}
