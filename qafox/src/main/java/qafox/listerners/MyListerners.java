package qafox.listerners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListerners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String testname = result.getName();
		System.out.println(testname + "got executed!");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname = result.getName();
		System.out.println(testname + "successfully executed!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getName();
		System.out.println(testname + "got failure!");
		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname = result.getName();
		System.out.println(testname + "got skipped!");
		System.out.println(result.getThrowable());
		// exceptions details will printed

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test get Started!");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test got Ended!");

	}

}
