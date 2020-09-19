package com.netBankingTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import netBankingUtilities.BaseClass;

public class Listeners extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		
		
	}

	public void onTestSuccess(ITestResult result) {
//		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result);
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
//		extentTest.get().fail(result.getThrowable());
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			
			getScreenShotPath(testMethodName, driver);
			
//			getScreenShotPath(testMethodName ,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
	}

}
