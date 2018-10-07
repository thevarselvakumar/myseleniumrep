package com.demo.reports;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	public static String screenshotFoldherPath;

	public static ExtentReports getInstance(String reportPath) {
		if (extent == null) {
			// generate report folder
			String fileName = "Report.html";
			Date d = new Date();
			String folderName = d.toString().replace(":", "_")
					.replace(" ", "_");

			// directory of the report folder
			new File(reportPath + folderName + "//screenshots").mkdirs();
			reportPath = reportPath + folderName + "//";
			screenshotFoldherPath = reportPath + "screenshots//";
			System.out.println(reportPath + fileName);
			createInstance(reportPath + fileName);

		}
		return extent;

	}

	private static ExtentReports createInstance(String fileName) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Reports");
		htmlReporter.config().setEncoding("utf=8");
		htmlReporter.config().setReportName("Reports - Automation Testing");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;

	
	}
}
