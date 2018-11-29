package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class RechercheTest extends AbstractTest {

  @Test
  public void rechercheOpportunites() {
      driver.get(urlToGo);
      driver.findElement(By.id("ds_saisie_connexion-lb_login-0")).clear();
      driver.findElement(By.id("ds_saisie_connexion-lb_login-0")).sendKeys("ioceanuser");
      driver.findElement(By.id("ds_saisie_connexion-lb_pass-0")).clear();
      driver.findElement(By.id("ds_saisie_connexion-lb_pass-0")).sendKeys("iocean");
      driver.findElement(xpath("(.//*[normalize-space(text()) and normalize-space(.)='Mot de passe'])[1]/following::button[1]")).click();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.findElement(xpath("(.//*[normalize-space(text()) and normalize-space(.)='Recherche avancée'])[1]/preceding::input[1]")).click();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      Assert.assertTrue(driver.findElements(By.id("ext-comp-1044")).size() > 0);
      driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  }

}
