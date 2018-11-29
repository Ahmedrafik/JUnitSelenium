package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class CreationTest extends AbstractTest{

    @Test
    public void demo() {
        driver.get(urlToGo);
        driver.findElement(By.id("ds_saisie_connexion-lb_login-0")).clear();
        driver.findElement(By.id("ds_saisie_connexion-lb_login-0")).sendKeys("ioceanuser");
        driver.findElement(By.id("ds_saisie_connexion-lb_pass-0")).clear();
        driver.findElement(By.id("ds_saisie_connexion-lb_pass-0")).sendKeys("iocean");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Mot de passe'])[1]/following::button[1]")).click();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Résultat'])[1]/following::span[2]")).click();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        Assert.assertEquals("  Nouvelle opportunité", driver.findElement(By.cssSelector("td[class=\"zone_titre\"]")).getText());

    }

 }