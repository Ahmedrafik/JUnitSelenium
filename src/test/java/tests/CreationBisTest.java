package tests;

import org.junit.Test;
import org.openqa.selenium.By;

public class CreationBisTest extends AbstractTest {

  @Test
  public void CreationBisOpportunites() {
      driver.get(urlToGo);
      driver.findElement(By.id("ds_saisie_connexion-lb_login-0")).clear();
      driver.findElement(By.id("ds_saisie_connexion-lb_login-0")).sendKeys("ioceanuser");
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Mot de passe'])[1]/following::button[1]")).click();
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Recherche avancée'])[1]/preceding::input[1]")).click();
      driver.findElement(By.id("ext-comp-1044")).click();
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Import'])[1]/following::span[2]")).click();
  }

}
