package com.ohrm.testcases;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ohrm.pages.Dashboardpage;
import com.ohrm.pages.Loginpage;
import com.ohrm.utility.ExcelReaderUtility;

public class Loginpagetest {
	Loginpage lp;
	Dashboardpage dp;
	@BeforeMethod
	public void browsersetup() {
		lp=new Loginpage();
		lp.initialization() ;
	}
	@Test
	public void validatetitletest() {
		String exptitle="OrangeHRM";
		String acttitle=lp.getTitle();
		Assert.assertEquals(acttitle, exptitle);
	}@Test
	public void validateLogintest() {
		 dp=lp.Login();
		Assert.assertTrue( dp.getdashboardlabel());

	}@Test(dataProvider="getLogindata")
	public void validateloginmultipledata(String username,String password) {
		dp=lp.Login(username,password);
		Assert.assertTrue(dp.getdashboardlabel());
	}@DataProvider
	public Object[][] getLogindata() {
	String	path="/Seleniumframework/src/test/resources/demo1.xlsx";
	String sheetname="Sheet1";
	 return ExcelReaderUtility.getData(path, sheetname);
	}
	@AfterMethod
	public void closebrowser() {
		lp.teardown();
	}
}

	