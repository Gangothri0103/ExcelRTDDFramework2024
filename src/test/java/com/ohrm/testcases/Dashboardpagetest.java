package com.ohrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.pages.Dashboardpage;
import com.ohrm.pages.Loginpage;

public class Dashboardpagetest {
Dashboardpage dp;
Loginpage lp;
@BeforeMethod
public void browsersetup() {
	lp=new Loginpage();
	dp.initialization();
}@Test
public void validatetimeworksectiontest() {
	 dp=lp.Login();
	Assert.assertTrue(dp.getdashboardlabel());
}@AfterMethod
public void closebrowser() {
	dp.teardown();
}
}
