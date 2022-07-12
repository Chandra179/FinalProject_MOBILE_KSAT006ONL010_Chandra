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
import com.chandra.LoopXpath as loopXpath

WebUI.callTestCase(findTestCase('Login/Login - 01'), [('username') : 'sum4', ('password') : 'Arw5ITtbyA4='], FailureHandling.STOP_ON_FAILURE)

driver = MobileDriverFactory.getDriver()

WebUI.delay(5)

Mobile.tap(findTestObject('Menu/btn_Left menu'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Menu/Left Menu/Body/android.widget.CheckedTextView - Make a Payment'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Payment/Body/android.widget.TextView - Select an Account to Pay from'), 0)

Mobile.verifyElementVisible(findTestObject('Payment/Body/android.widget.Spinner'), 0)

Mobile.verifyElementVisible(findTestObject('Payment/Body/android.widget.TextView - tes1 (12.00)'), 0)

Mobile.verifyElementVisible(findTestObject('Payment/Body/Select payee/android.widget.TextView - Select a Payee'), 0)

Mobile.verifyElementVisible(findTestObject('Payment/Body/Select payee/spinner_Payee'), 0)

Mobile.verifyElementVisible(findTestObject('Payment/Body/Select payee/text_Spinner payee'), 0)

Mobile.verifyElementVisible(findTestObject('Payment/Body/Select payee/android.widget.EditText - Amount'), 0)

Mobile.verifyElementVisible(findTestObject('Payment/Body/Select payee/android.widget.Button - Make Payment'), 0)

Mobile.tap(findTestObject('Payment/Body/Select payee/spinner_Payee'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Payment/Body/Select payee/android.widget.CheckedTextView - john (P1)'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Payment/Body/Select payee/android.widget.EditText - Amount'), 0)

Mobile.setText(findTestObject('Payment/Body/Select payee/android.widget.EditText - Amount'), amount, 0)

//======================
// Before transfer money
//======================
String payFrom = Mobile.getText(findTestObject('Object Repository/Payment/Body/android.widget.TextView - tes1 (12.00)'), 
    0)

//======================
// After transfer money
//======================
Mobile.tap(findTestObject('Payment/Body/Select payee/android.widget.Button - Make Payment'), 0)

Integer inputAmount = amount.toInteger()

String[] amountString = payFrom.split('(?<=\\D)(?=\\d)')

Integer amountNums = (amountString[2]).replace('.', '').toInteger()

Integer updatedAmountNums = amountNums - inputAmount

String updatedAmountString = ((((amountString[0]) + (amountString[1])) + updatedAmountNums.toString()) + '.00') + ')'

Mobile.verifyElementText(findTestObject('Object Repository/Payment/Body/android.widget.TextView - tes1 (12.00)'), updatedAmountString)

driver.terminateApp(GlobalVariable.bundleID)

