package com.ohrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ohrm.base.OrangeHRMBase;

public class Loginpage extends OrangeHRMBase {
	public String getTitle() {
		return driver.getTitle();
	}

public Dashboardpage Login() {
	driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
	driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	return new Dashboardpage();
}
public Dashboardpage Login(String username,String password) {
	driver.findElement(By.name("Username")).sendKeys("username");
	driver.findElement(By.name("Password")).sendKeys("password");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	return new Dashboardpage();
}


}
