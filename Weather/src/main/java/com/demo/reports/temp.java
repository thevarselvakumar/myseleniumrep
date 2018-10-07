package com.demo.reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date d = new Date();
		System.out.println(d.toString().replaceAll(":", "_"));

		ExtentReports rep = ExtentManager.getInstance("D:\\Browser\\");

		ExtentTest test = rep.createTest("Test A");
		test.log(Status.INFO, "starting Test A");
		test.log(Status.INFO, "Executing A");
		test.log(Status.FAIL, "Failed");

		rep.flush();

		// new File ("D:\\A").mkdir();

	}

}
