package com.ohrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ohrm.base.OrangeHRMBase;

public class Dashboardpage extends OrangeHRMBase {
	
	public boolean getdashboardlabel() {
		 return driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
	}
	public boolean gettimeworksection() {
		return driver.findElement(By.xpath("//p[text()='Time at Work']")).isDisplayed();
	
	}
}
