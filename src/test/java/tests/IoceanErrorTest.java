package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IoceanErrorTest {
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
      Assert.assertEquals("Wikipedia.fr - Résultats pour « software » sur Wikipédia en français", driver.getTitle());
  }

  @After
  public void tearDown() {
      EnvironmentManager.shutDownDriver();
  }

}
