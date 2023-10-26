package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class AdminDashboardPage extends BaseClass {

	public AdminDashboardPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Abc Def']")
	private WebElement patientName;

	public WebElement getPatientName() {
		return patientName;
	}

	@FindBy(xpath = "//li[@class='nav-item logout']")
	private WebElement logout;

	public WebElement getLogout() {
		return logout;
	}

	public void setLogout(WebElement logout) {
		this.logout = logout;
	}

	public void setPatientName(WebElement patientName) {
		this.patientName = patientName;
	}

	@FindBy(xpath = "//a[@id='referenceapplication-vitals-referenceapplication-vitals-extension']")
	private WebElement captureVitals;

	@FindBy(xpath = "//i[@class='icon-arrow-right']")
	private WebElement recordVitals;

	public WebElement getRecordVitals() {
		return recordVitals;
	}

	public void setRecordVitals(WebElement recordVitals) {
		this.recordVitals = recordVitals;
	}

	public WebElement getCaptureVitals() {
		return captureVitals;
	}

	public void setCaptureVitals(WebElement captureVitals) {
		this.captureVitals = captureVitals;
	}

	@FindBy(xpath = "//li[@class=\"nav-item identifier\"]")
	private WebElement nameVerify;

	public WebElement getNameVerify() {
		return nameVerify;
	}

	public void setNameVerify(WebElement nameVerify) {
		this.nameVerify = nameVerify;
	}

	@FindBy(xpath = "(//a[@class='btn btn-default btn-lg button app big align-self-center'])[3]")
	private WebElement listBox;

	@FindBy(xpath = "(//a[@type='button']/child::i[@class='icon-user'])[2]")
	private WebElement registerPatientButton;

	@FindBy(xpath = "//a[@type='button']/child::i[@class='icon-user']")
	private WebElement registerPatientButton1;

	public WebElement getRegisterPatientButton1() {
		return registerPatientButton1;
	}

	public void setRegisterPatientButton1(WebElement registerPatientButton1) {
		this.registerPatientButton1 = registerPatientButton1;
	}

	public WebElement getRegisterPatientButton() {
		return registerPatientButton;
	}

	public void setRegisterPatientButton(WebElement registerPatientButton) {
		this.registerPatientButton = registerPatientButton;
	}

	public WebElement getListBox() {
		return listBox;
	}

	public void setListBox(WebElement listBox) {
		this.listBox = listBox;
	}
}