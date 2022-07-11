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

Mobile.tap(findTestObject('Menu/Left Menu/Body/android.widget.CheckedTextView - Make a Deposit'), 0)

Mobile.verifyElementVisible(findTestObject('Deposit/Make a deposit/android.widget.TextView - Select an Account to Deposit to'), 
    0)

Mobile.verifyElementVisible(findTestObject('Deposit/Make a deposit/spinner'), 0)

Mobile.verifyElementVisible(findTestObject('Deposit/Make a deposit/text_spinner'), 0)

Mobile.verifyElementVisible(findTestObject('Deposit/Make a deposit/android.widget.EditText - Enter Deposit Amount ()'), 
    0)

Mobile.verifyElementVisible(findTestObject('Deposit/Make a deposit/android.widget.Button - CANCEL'), 0)

Mobile.verifyElementVisible(findTestObject('Deposit/Make a deposit/android.widget.Button - DEPOSIT'), 0)

Mobile.tap(findTestObject('Deposit/Make a deposit/spinner'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

Mobile.verifyElementVisible(findTestObject('Deposit/Make a deposit/android.widget.CheckedTextView - account1 (500.00)'), 
    0)

Mobile.tap(findTestObject('Deposit/Make a deposit/android.widget.CheckedTextView - account1 (500.00)'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Deposit/Make a deposit/android.widget.EditText - Enter Deposit Amount ()'), deposit, 0)

Mobile.tap(findTestObject('Deposit/Make a deposit/android.widget.Button - DEPOSIT'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

Mobile.verifyElementVisible(findTestObject('Accounts/Body/Have account/android.view.ViewGroup'), 0)

// ==============================
// Get Account1 current balance
// ==============================
String currentBalance = Mobile.getText(findTestObject('Accounts/Body/Have account/account_balance'), 
    0)


String[] currentBalanceString = currentBalance.split("(?<=\\D)(?=\\d)")

Integer currentBalanceNums = (currentBalanceString[1]).toInteger()

Integer inputBalanceNums = deposit.toInteger()

Integer updatedBalanceNums = currentBalanceNums + inputBalanceNums

String updatedBalanceString = ((currentBalanceString[0]) + '$') + updatedBalanceNums.toString() + '.00'

Mobile.verifyElementText(findTestObject('Accounts/Body/Have account/account_balance'), updatedBalanceString)

driver.terminateApp(GlobalVariable.bundleID)

