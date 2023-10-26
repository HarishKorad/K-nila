package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class PatientDetailsPage extends BaseClass {

	public PatientDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='retrospectiveVisitStopDate']/parent::p/following-sibling::button[@class='cancel']")
	private WebElement cancelbtn;

	public WebElement getCancelbtn() {
		return cancelbtn;
	}

	public void setCancelbtn(WebElement cancelbtn) {
		this.cancelbtn = cancelbtn;
	}

	@FindBy(xpath = "//a[text()=' End Visit']")
	private WebElement endVisit;

	public WebElement getEndVisit() {
		return endVisit;
	}

	public void setEndVisit(WebElement endVisit) {
		this.endVisit = endVisit;
	}

	@FindBy(xpath = "//a[text()=' Capture Vitals']")
	private WebElement captureVitals;

	public WebElement getCaptureVitals() {
		return captureVitals;
	}

	public void setCaptureVitals(WebElement captureVitals) {
		this.captureVitals = captureVitals;
	}

	@FindBy(xpath = "(//label[contains(text(),'Start')]/ancestor::div/preceding-sibling::div/child::div[@class='datetimepicker-days']/table/tbody)[1]/tr/td[@class='day disabled']")
	private List<WebElement> datePicker;

	public List<WebElement> getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(List<WebElement> datePicker) {
		this.datePicker = datePicker;
	}

	@FindBy(xpath = "//div[contains(text(),'Merge')]")
	private WebElement mergeVisit;

	public WebElement getMergeVisit() {
		return mergeVisit;
	}

	public void setMergeVisit(WebElement mergeVisit) {
		this.mergeVisit = mergeVisit;
	}

	@FindBy(xpath = "//div[contains(text(),'Past')]")
	private WebElement pastVisit;

	public WebElement getPastVisit() {
		return pastVisit;
	}

	public void setPastVisit(WebElement pastVisit) {
		this.pastVisit = pastVisit;
	}

	@FindBy(xpath = "//div[text()='Vitals']")
	private WebElement vitalsAttachment;

	public WebElement getVitalsAttachment() {
		return vitalsAttachment;
	}

	public void setVitalsAttachment(WebElement vitalsAttachment) {
		this.vitalsAttachment = vitalsAttachment;
	}

	@FindBy(xpath = "(//span[@class='value'])[4]")
	private WebElement height;

	@FindBy(xpath = "(//span[@class='value'])[5]")
	private WebElement weight;

	@FindBy(xpath = "//span[@id='calculated-bmi']")
	private WebElement bmi;

	@FindBy(xpath = "//div[@class='logo']")
	private WebElement homePage;

	public WebElement getHeight() {
		return height;
	}

	public void setHeight(WebElement height) {
		this.height = height;
	}

	public WebElement getWeight() {
		return weight;
	}

	public void setWeight(WebElement weight) {
		this.weight = weight;
	}

	public WebElement getBmi() {
		return bmi;
	}

	public void setBmi(WebElement bmi) {
		this.bmi = bmi;
	}

	public WebElement getHomePage() {
		return homePage;
	}

	public void setHomePage(WebElement homePage) {
		this.homePage = homePage;
	}

	@FindBy(xpath = "//span[contains(text(),'23 year')]")
	private WebElement age;

	public WebElement getAge() {
		return age;
	}

	@FindBy(xpath = "//p[text()='AttachementUploaded']")
	private WebElement uploaded;

	public WebElement getUploaded() {
		return uploaded;
	}

	public void setUploaded(WebElement uploaded) {
		this.uploaded = uploaded;
	}

	public void setAge(WebElement age) {
		this.age = age;
	}

	@FindBy(xpath = "//em[text()='Patient ID']")
	private WebElement patientId;

	public WebElement getPatientId() {
		return patientId;
	}

	public void setPatientId(WebElement patientId) {
		this.patientId = patientId;
	}

	public WebElement getStartVisitButton() {
		return startVisitButton;
	}

	public void setStartVisitButton(WebElement startVisitButton) {
		this.startVisitButton = startVisitButton;
	}

	public WebElement getStartVisitConfirmButton() {
		return startVisitConfirmButton;
	}

	public void setStartVisitConfirmButton(WebElement startVisitConfirmButton) {
		this.startVisitConfirmButton = startVisitConfirmButton;
	}

	public WebElement getAttachmentButton() {
		return attachmentButton;
	}

	public void setAttachmentButton(WebElement attachmentButton) {
		this.attachmentButton = attachmentButton;
	}

	public WebElement getAttachmentUploadButton() {
		return attachmentUploadButton;
	}

	public void setAttachmentUploadButton(WebElement attachmentUploadButton) {
		this.attachmentUploadButton = attachmentUploadButton;
	}

	public WebElement getCaptionTextArea() {
		return captionTextArea;
	}

	public void setCaptionTextArea(WebElement captionTextArea) {
		this.captionTextArea = captionTextArea;
	}

	public WebElement getUploadButton() {
		return uploadButton;
	}

	public void setUploadButton(WebElement uploadButton) {
		this.uploadButton = uploadButton;
	}

	public WebElement getSuccessfulMessage() {
		return successfulMessage;
	}

	public void setSuccessfulMessage(WebElement successfulMessage) {
		this.successfulMessage = successfulMessage;
	}

	public WebElement getAttachmentSection() {
		return attachmentSection;
	}

	public void setAttachmentSection(WebElement attachmentSection) {
		this.attachmentSection = attachmentSection;
	}

	public WebElement getLastEntry() {
		return lastEntry;
	}

	public void setLastEntry(WebElement lastEntry) {
		this.lastEntry = lastEntry;
	}

	public WebElement getEndVisitButton() {
		return endVisitButton;
	}

	public void setEndVisitButton(WebElement endVisitButton) {
		this.endVisitButton = endVisitButton;
	}

	public WebElement getConfirmEndVisitButton() {
		return confirmEndVisitButton;
	}

	public void setConfirmEndVisitButton(WebElement confirmEndVisitButton) {
		this.confirmEndVisitButton = confirmEndVisitButton;
	}

	public WebElement getDeletePatientButton() {
		return deletePatientButton;
	}

	public void setDeletePatientButton(WebElement deletePatientButton) {
		this.deletePatientButton = deletePatientButton;
	}

	public WebElement getReasonForDeleteInput() {
		return reasonForDeleteInput;
	}

	public void setReasonForDeleteInput(WebElement reasonForDeleteInput) {
		this.reasonForDeleteInput = reasonForDeleteInput;
	}

	public WebElement getConfirmDeleteButton() {
		return confirmDeleteButton;
	}

	public void setConfirmDeleteButton(WebElement confirmDeleteButton) {
		this.confirmDeleteButton = confirmDeleteButton;
	}

	public WebElement getDeleteMessage() {
		return deleteMessage;
	}

	public void setDeleteMessage(WebElement deleteMessage) {
		this.deleteMessage = deleteMessage;
	}

	@FindBy(xpath = "//div[contains(text(), 'Start Visit')]")
	private WebElement startVisitButton;

	@FindBy(xpath = "//a[contains(text(),' H')]")
	private WebElement patientPage;

	@FindBy(xpath = "(//input[@name='mergeVisits'])[1]")
	private WebElement mergeVisit1;

	@FindBy(xpath = "(//input[@name='mergeVisits'])[2]")
	private WebElement mergeVisit2;

	@FindBy(xpath = "(//input[@name='mergeVisits'])[3]")
	private WebElement mergeVisit3;

	@FindBy(id = "mergeVisitsBtn")
	private WebElement mergeVisitBtn;

	@FindBy(xpath = "//input[@class='cancel']")
	private WebElement returnBtn;

	public WebElement getReturnBtn() {
		return returnBtn;
	}

	public void setReturnBtn(WebElement returnBtn) {
		this.returnBtn = returnBtn;
	}

	public WebElement getMergeVisit3() {
		return mergeVisit3;
	}

	public void setMergeVisit3(WebElement mergeVisit3) {
		this.mergeVisit3 = mergeVisit3;
	}

	public WebElement getMergeVisit1() {
		return mergeVisit1;
	}

	public WebElement getMergeVisitBtn() {
		return mergeVisitBtn;
	}

	public void setMergeVisitBtn(WebElement mergeVisitBtn) {
		this.mergeVisitBtn = mergeVisitBtn;
	}

	public void setMergeVisit1(WebElement mergeVisit1) {
		this.mergeVisit1 = mergeVisit1;
	}

	public WebElement getMergeVisit2() {
		return mergeVisit2;
	}

	public void setMergeVisit2(WebElement mergeVisit2) {
		this.mergeVisit2 = mergeVisit2;
	}

	public WebElement getPatientPage() {
		return patientPage;
	}

	public void setPatientPage(WebElement patientPage) {
		this.patientPage = patientPage;
	}

	@FindBy(xpath = "//button[@id='start-visit-with-visittype-confirm']")
	private WebElement startVisitConfirmButton;

	@FindBy(xpath = "//a[@id='attachments.attachments.visitActions.default']")
	private WebElement attachmentButton;

	@FindBy(id = "visit-documents-dropzone")
	private WebElement attachmentUploadButton;

	@FindBy(xpath = "//textarea[@placeholder='Enter a caption']")
	private WebElement captionTextArea;

	@FindBy(xpath = "//button[text()='Upload file']")
	private WebElement uploadButton;

	@FindBy(xpath = "//*[text()='The attachment was successfully uploaded.']")
	private WebElement successfulMessage;

	@FindBy(xpath = "//div[@ng-if='active']")
	private WebElement attachmentSection;

	@FindBy(xpath = "//div[text()='Attachment Upload']//preceding-sibling::a")
	private WebElement lastEntry;

	@FindBy(xpath = "(//div[contains(text(),'End Visit')])[2]")
	private WebElement endVisitButton;

	@FindBy(xpath = "//div[@id='end-visit-dialog']/child::div[@class='dialog-content']/child::button[@class='cancel']/preceding-sibling::button[text()='Yes']")
	private WebElement confirmEndVisitButton;

	@FindBy(xpath = "//a[@id='org.openmrs.module.coreapps.deletePatient']")
	private WebElement deletePatientButton;

	@FindBy(xpath = "//input[@id='delete-reason']")
	private WebElement reasonForDeleteInput;

	@FindBy(xpath = "(//button[text()='Confirm'])[4]")
	private WebElement confirmDeleteButton;

	@FindBy(xpath = "//*[text()='Patient has been deleted successfully']")
	private WebElement deleteMessage;

}
