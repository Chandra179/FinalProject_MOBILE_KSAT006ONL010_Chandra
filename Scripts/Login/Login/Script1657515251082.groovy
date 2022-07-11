import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.startExistingApplication(GlobalVariable.bundleID, FailureHandling.STOP_ON_FAILURE)

driver = MobileDriverFactory.getDriver()

WebUI.delay(5)

Mobile.verifyElementVisible(findTestObject('Landing Screen/Body/username'), 0)

Mobile.verifyElementVisible(findTestObject('Landing Screen/Body/password'), 0)

Mobile.verifyElementVisible(findTestObject('Landing Screen/Body/Remember Credentials'), 0)

Mobile.verifyElementVisible(findTestObject('Landing Screen/Body/btn_LOGIN'), 0)

Mobile.verifyElementVisible(findTestObject('Landing Screen/Body/text_Dont have a profile'), 0)

Mobile.verifyElementVisible(findTestObject('Landing Screen/Body/btn_CREATE A PROFILE'), 0)

Mobile.tap(findTestObject('Landing Screen/Body/username'), 0)

Mobile.clearText(findTestObject('Landing Screen/Body/username'), 0)

Mobile.setText(findTestObject('Landing Screen/Body/username'), username, 0)

WebUI.delay(5)

Mobile.tap(findTestObject('Landing Screen/Body/password'), 0)

Mobile.clearText(findTestObject('Landing Screen/Body/password'), 0)

Mobile.setEncryptedText(findTestObject('Landing Screen/Body/password'), password, 0)

WebUI.delay(5)

Mobile.tap(findTestObject('Landing Screen/Body/btn_LOGIN'), 0, FailureHandling.STOP_ON_FAILURE)

driver.terminateApp(GlobalVariable.bundleID)

