import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory

driver = MobileDriverFactory.getDriver()

Mobile.tap(findTestObject('Menu/Left Menu/Body/android.widget.CheckedTextView - Make a Transfer'), 0)

WebUI.delay(5)

Mobile.verifyElementVisible(findTestObject('Transfer/Transfer Error/android.widget.TextView - Transfer Error'), 0)

Mobile.verifyElementVisible(findTestObject('Transfer/Transfer Error/android.widget.TextView - You do not have enough accounts to make a Transfer. Add another account if you want to make a transfer'), 
    0)

Mobile.verifyElementVisible(findTestObject('Transfer/Transfer Error/android.widget.Button - ADD ACCOUNT'), 0)

Mobile.verifyElementVisible(findTestObject('Transfer/Transfer Error/android.widget.Button - CANCEL'), 0)

Mobile.tap(findTestObject('Transfer/Transfer Error/android.widget.Button - CANCEL'), 0)

driver.terminateApp(GlobalVariable.bundleID)

