package com.github.cstroe.cosmind;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    @Test
    public void test() throws MalformedURLException {
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new FirefoxOptions());
        driver.get("http://cosmind:8080");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        assertEquals("Sign In", loginButton.getAttribute("value"));

        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("password");
        loginButton.click();

        driver.findElement(By.id("ideas-link")).click();
        assertEquals("Ideas:", driver.findElement(By.id("ideas-header")).getText());
        driver.close();
    }
}
