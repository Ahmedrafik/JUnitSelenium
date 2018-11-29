package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
      driver.get("https://www.iocean.fr/nous.html");
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contactez-nous'])[1]/following::img[1]")).click();
      driver.findElement(By.linkText("Clients")).click();
      driver.findElement(By.linkText("En savoir +")).click();
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Outils'])[2]/following::a[1]")).click();
      driver.findElement(By.linkText("IOcean à l’avant-garde du droit à la déconnexion")).click();
  }

  @After
  public void tearDown() {
      EnvironmentManager.shutDownDriver();
  }

}
