package com.test;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.AdminDashboardPage;
import com.pages.LoginPage;
import com.pages.PatientDetailsPage;
import com.pages.RegisterPage;
import com.pages.VitalPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ApplicationUnderTest extends BaseClass {

	static ExtentTest test;
	static ExtentReports report;
	LoginPage loginPage;
	AdminDashboardPage admin;
	RegisterPage register;
	PatientDetailsPage patient;
	VitalPage vital;

	@BeforeTest
	public static void reportSetup() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReport\\ExtentReportResults.html");
		test = report.startTest("Knila");
	}

	@BeforeClass
	public void setup() throws Throwable {
		getDriver("chrome");
		test.log(LogStatus.PASS, "Chrome Browser", "Browser lauched successfully");
		maximizeWindow();
		getUrl(getPropertyFileValue("Url"));
		test.log(LogStatus.PASS, "Application Launch", "Navigated to the URL");
		implicitlyWait();
	}

	@Test(priority = 1)
	public void login() throws Throwable {
		loginPage = new LoginPage();
		enterText(loginPage.getUsernameInput(), getPropertyFileValue("Username"));
		enterText(loginPage.getPasswordInput(), getPropertyFileValue("Password"));
		click(loginPage.getLocationButton());
		click(loginPage.getLoginButton());
		test.log(LogStatus.PASS, "Login", "Login clicked Successfully");
	}

	@Test(priority = 2, dependsOnMethods = "login")
	public void dashboard() throws Throwable {
		admin = new AdminDashboardPage();
		Assert.assertTrue(admin.getNameVerify().getText().equalsIgnoreCase(getPropertyFileValue("Username")));
		test.log(LogStatus.PASS, "Verify Dashboard name contains Username ignores case", "Expected Username: "
				+ getPropertyFileValue("Username") + " Actual Username: " + admin.getNameVerify().getText());
//		try {
//			click(admin.getRegisterPatientButton());
//		} catch (Exception e) {
//		}
		click(admin.getRegisterPatientButton1());
	}

	@Test(priority = 3, dependsOnMethods = "dashboard")
	public void registerPatient() throws Throwable {
		test.log(LogStatus.INFO, "Register Patient");
		register = new RegisterPage();
		enterText(register.getGivenNameInput(), getPropertyFileValue("Given"));
		enterText(register.getLastNameInput(), getPropertyFileValue("Last"));
		click(register.getGenderQuestion());
		String maleOption = register.getMaleOption().getText();
		click(register.getMaleOption());
		click(register.getBirthdateLabel());
		enterText(register.getBirthdateDayInput(), getPropertyFileValue("Date"));
		selectByText(register.getBirthdateMonthDropdown(), getPropertyFileValue("Month"));
		enterText(register.getBirthdateYearInput(), getPropertyFileValue("Year"));
		click(register.getAddressLabel());
		enterText(register.getAddress1Input(), getPropertyFileValue("Address"));
		click(register.getPhoneNumberLabel());
		enterText(register.getPhoneNumberInput(), getPropertyFileValue("Phone"));
		click(register.getConfirmationLabel());

		Assert.assertTrue(register.getVerifyName().getText().contains(getPropertyFileValue("Given")));
		test.log(LogStatus.PASS, "Verify GivenName", "Expected name: " + getPropertyFileValue("Given")
				+ " Actual name: " + register.getVerifyName().getText());
		Assert.assertTrue(register.getVerifyGender().getText().contains(maleOption));
		test.log(LogStatus.PASS, "Verify Gender",
				"Expected gender: " + maleOption + " Actual gender: " + register.getVerifyGender().getText());
		Assert.assertTrue(register.getVerifyBirthdate().getText().contains(getPropertyFileValue("Year")));
		test.log(LogStatus.PASS, "Verify Birthyear", "Expected year: " + getPropertyFileValue("Year") + " Actual year: "
				+ register.getVerifyBirthdate().getText());
		Assert.assertTrue(register.getVerifyAddress().getText().contains(getPropertyFileValue("Address")));
		test.log(LogStatus.PASS, "Verify Address", "Expected address: " + getPropertyFileValue("Address")
				+ " Actual address: " + register.getVerifyAddress().getText());
		Assert.assertTrue(register.getVerifyPhoneNumber().getText().contains(getPropertyFileValue("Phone")));
		test.log(LogStatus.PASS, "Verify Phone number", "Expected phone: " + getPropertyFileValue("Phone")
				+ " Actual Phone: " + register.getVerifyPhoneNumber().getText());
		click(register.getConfirmButton());
		test.log(LogStatus.INFO, "Patient registered Successfully");
	}

	@Test(priority = 4, dependsOnMethods = "registerPatient")
	public void patientDetails() throws Throwable {
		test.log(LogStatus.INFO, "Patient details page");
		patient = new PatientDetailsPage();
		Assert.assertTrue(driver.getCurrentUrl().contains(getPropertyFileValue("PatientPage")));
		test.log(LogStatus.PASS, "Verify patient page name is in URL", "Verifying url page contains Patient.page: "
				+ driver.getCurrentUrl().contains(getPropertyFileValue("PatientPage")));
		int birthDay = Integer.parseInt(getPropertyFileValue("Date"));
		String birthMonthName = getPropertyFileValue("Month");
		int birthYear = Integer.parseInt(getPropertyFileValue("Year"));
		Month birthMonth = Month.valueOf(birthMonthName.toUpperCase());
		LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
		LocalDate currentDate = LocalDate.now();
		Period period = Period.between(birthDate, currentDate);
		int years = period.getYears();
		Assert.assertTrue(patient.getAge().getText().contains(String.valueOf(years)));
		test.log(LogStatus.PASS, "Verify age from DOB",
				"Verifying age: " + patient.getAge().getText().contains(String.valueOf(years)));
	}

	@Test(priority = 5, dependsOnMethods = "patientDetails")
	public void startVisit() throws Throwable {
		test.log(LogStatus.INFO, "Start patient vist");
		click(patient.getStartVisitButton());
		click(patient.getStartVisitConfirmButton());
		test.log(LogStatus.INFO, "Upload file");
		click(patient.getAttachmentButton());
		click(patient.getAttachmentUploadButton());

		Thread.sleep(10000);
		Robot robot = new Robot();
		StringSelection str = new StringSelection(
				System.getProperty("user.dir") + "\\ExtentReport\\ExtentReportResults.html");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, str);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);
		enterText(patient.getCaptionTextArea(), getPropertyFileValue("Caption"));
		click(patient.getUploadButton());

		Assert.assertEquals(patient.getSuccessfulMessage().getText(), getPropertyFileValue("VerifyMessage"));
		test.log(LogStatus.PASS, "Verify upload", "Expected successful msg: " + getPropertyFileValue("VerifyMessage")
				+ " Actual successful msg: " + patient.getSuccessfulMessage().getText());

		click(patient.getPatientPage());

		try {
			Assert.assertTrue(patient.getUploaded().isDisplayed());
			test.log(LogStatus.PASS, "Verify attachments uploaded",
					"Actual msg: " + patient.getUploaded().isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread.sleep(3000);
		String dateEntry = patient.getLastEntry().getText();
		SimpleDateFormat sim = new SimpleDateFormat("dd.MMM.yyyy");
		Date date = new Date();
		Assert.assertEquals(sim.format(date), dateEntry);
		test.log(LogStatus.PASS, "Last entry date", "Expected last entry date: " + sim.format(date)
				+ " Acutal last entry date: " + patient.getLastEntry().getText());
		click(patient.getEndVisitButton());
		click(patient.getConfirmEndVisitButton());
		test.log(LogStatus.INFO, "End patient visit");
	}

	@Test(priority = 6, dependsOnMethods = "startVisit")
	public void captureVitals() throws Throwable {
		test.log(LogStatus.INFO, "Start patient visit again");
		click(patient.getStartVisitButton());
		click(patient.getStartVisitConfirmButton());
		click(patient.getCaptureVitals());
		test.log(LogStatus.INFO, "Capture vitals");
		vital = new VitalPage();
		enterText(vital.getHeight(), getPropertyFileValue("Height"));
		click(vital.getNextButton());
		enterText(vital.getWeight(), getPropertyFileValue("Weight"));
		click(vital.getNextButton());
		double weightInKg = Double.parseDouble(getPropertyFileValue("Weight"));
		double heightInCm = Double.parseDouble(getPropertyFileValue("Height"));
		double heightInM = heightInCm / 100.0;
		double bmi = weightInKg / (heightInM * heightInM);
		int bmi1 = (int) bmi;
		Assert.assertTrue(vital.getBmi().getText().contains((String.valueOf(bmi1))));
		test.log(LogStatus.PASS, "Verify bmi",
				"Expected bmi: " + String.valueOf(bmi) + " Actual bmi: " + vital.getBmi().getText());
		click(vital.getSaveForm());
		click(vital.getSaveButton());
		click(patient.getEndVisit());
		click(patient.getConfirmEndVisitButton());
		test.log(LogStatus.INFO, "End visit");
		Thread.sleep(3000);
		click(patient.getPatientPage());
		try {
			Assert.assertEquals(getPropertyFileValue("Height"), patient.getHeight().getText());
			test.log(LogStatus.PASS, "Verify height", "Expected height: " + getPropertyFileValue("Height")
					+ " Acutual height: " + patient.getHeight().getText());
			Assert.assertEquals(getPropertyFileValue("Weight"), patient.getWeight().getText());
			test.log(LogStatus.PASS, "Verify weight", "Expected weight: " + getPropertyFileValue("Weight")
					+ " Acutual weight: " + patient.getWeight().getText());
			Assert.assertTrue(patient.getBmi().getText().contains(String.valueOf(bmi1)));
			test.log(LogStatus.PASS, "Verify bmi",
					"Verifying bmi contains: " + patient.getBmi().getText().contains(String.valueOf(bmi1)));
			Assert.assertTrue(patient.getVitalsAttachment().getText().contains("Vitals"));
			test.log(LogStatus.PASS, "Verify attachment", "Expected status that contains Vitals in attachment: "
					+ patient.getVitalsAttachment().getText().contains("Vitals"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 7, dependsOnMethods = "captureVitals")
	public void mergeVisit() throws IOException, Throwable {
		test.log(LogStatus.INFO, "Merge Visit");
		click(patient.getMergeVisit());
		click(patient.getMergeVisit1());
		click(patient.getMergeVisit2());
		click(patient.getMergeVisitBtn());
		click(patient.getReturnBtn());
		test.log(LogStatus.INFO, "Patient visit merged");
	}

	@Test(priority = 8, dependsOnMethods = "mergeVisit")
	public void pastVisit() {
		click(patient.getPastVisit());
		test.log(LogStatus.INFO, "Past visit clicked and verifying future date is not clickable");
		LocalDate currentDate = LocalDate.now();
		int dayOfMonth = currentDate.getDayOfMonth();
		List<WebElement> datePicker = patient.getDatePicker();
		for (WebElement webElement : datePicker) {
			String dateText = webElement.getText();
			if (dayOfMonth <= Integer.parseInt(dateText)) {
				Assert.assertFalse(webElement.isSelected());
				test.log(LogStatus.PASS, "Future date",
						"Verifying future date: " + webElement.getText() + " is not clickable");
			}
		}
		click(patient.getCancelbtn());
		test.log(LogStatus.INFO, "Patient past visit ended");
	}

	@Test(priority = 9, dependsOnMethods = "pastVisit")
	public void deletePatient() throws IOException, Throwable {
		test.log(LogStatus.INFO, "Delete patient visit");
		click(patient.getDeletePatientButton());
		enterText(patient.getReasonForDeleteInput(), getPropertyFileValue("Reason"));
		click(patient.getConfirmDeleteButton());
		test.log(LogStatus.PASS, "Patient deleted successfully");
		((JavascriptExecutor) driver).executeScript("arguments[0].click", admin.getLogout());
		test.log(LogStatus.INFO, "User logout");
	}

	@AfterMethod
	public void after(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.SUCCESS) {
			screenShot();
		}
	}

	@AfterTest
	public void tearDown() throws Throwable {
		driver.quit();
		test.log(LogStatus.INFO, "Browser Closed");
		report.endTest(test);
		report.flush();
	}

}