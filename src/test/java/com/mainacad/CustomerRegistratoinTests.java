package com.mainacad;

/**
 * Created by Gennadii on 14-Jun-17.
 */
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerRegistratoinTests extends TestBase {

    @Test
    public void canRegisterCustomerTest(){
        String email = "adam"+System.currentTimeMillis()+"@smith.me";
        driver.get("http://litecart-2.0.1/en/create_account");
        driver.findElement(By.name("firstname")).sendKeys("Adam");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("address1")).sendKeys("Hidden Place");
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("city")).sendKeys("New City");

        driver.findElement(By.cssSelector("[name=country_code]")).click();
        driver.findElement(By.cssSelector(".form-control [value='US']")).click();
        wait.until((WebDriver d) -> d.findElement(By.cssSelector("select[name=zone_code] option[value=KS]")));
        new Select(driver.findElement(By.name("zone_code"))).selectByValue("KS");

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("+0123456789");
        driver.findElement(By.name("password")).sendKeys("qwerty");
        driver.findElement(By.name("confirmed_password")).sendKeys("qwerty");
        driver.findElement(By.name("create_account")).click();
    }
}



