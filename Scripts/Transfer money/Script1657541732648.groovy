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

WebUI.callTestCase(findTestCase('Login/Login - 01'), [('username') : 'sum4', ('password') : 'Arw5ITtbyA4='], FailureHandling.STOP_ON_FAILURE)

driver = MobileDriverFactory.getDriver()

WebUI.delay(5)

Mobile.tap(findTestObject('Menu/btn_Left menu'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Menu/Left Menu/Body/android.widget.CheckedTextView - Make a Transfer'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Transfer/Body/Sending account/android.widget.TextView - Select Sending Account'), 
    0)

Mobile.verifyElementVisible(findTestObject('Transfer/Body/Sending account/spinner_Sending account'), 0)

Mobile.verifyElementVisible(findTestObject('Transfer/Body/Sending account/text_Spinner sending account'), 0)

Mobile.verifyElementVisible(findTestObject('Transfer/Body/Sending account/android.widget.EditText - Transfer Amount'), 0)

Mobile.verifyElementVisible(findTestObject('Transfer/Body/Receiving account/android.widget.TextView - Select Receiving Account'), 
    0)

Mobile.verifyElementVisible(findTestObject('Transfer/Body/Receiving account/spinner_Receiving account'), 0)

Mobile.verifyElementVisible(findTestObject('Transfer/Body/Receiving account/text_Spinner receiving acccount'), 0)

Mobile.verifyElementVisible(findTestObject('Transfer/Body/btn_Confirm Transfer'), 0)

Mobile.tap(findTestObject('Transfer/Body/Sending account/android.widget.EditText - Transfer Amount'), 0)

Mobile.setText(findTestObject('Transfer/Body/Sending account/android.widget.EditText - Transfer Amount'), moneyToTransfer, 
    0)

//======================
// Before transfer money
//======================
String receiver = Mobile.getText(findTestObject('Transfer/Body/Receiving account/text_Spinner receiving acccount'), 0)

String sender = Mobile.getText(findTestObject('Transfer/Body/Sending account/text_Spinner sending account'), 0)

//======================
// After transfer money
//======================
Mobile.tap(findTestObject('Transfer/Body/btn_Confirm Transfer'), 0, FailureHandling.STOP_ON_FAILURE)

//======================
// Verify transfer
//======================
Integer inputBalanceNums = moneyToTransfer.toInteger()

String[] receiverBalanceString = receiver.split('(?<=\\D)(?=\\d)')

Integer receiverBalanceNums = (receiverBalanceString[1]).replace('.', '').toInteger()

Integer updatedBalanceReceiverNums = receiverBalanceNums + inputBalanceNums

String updatedBalanceReceiverString = ((receiverBalanceString[0]) + updatedBalanceReceiverNums.toString()) + '.00'

String[] senderBalanceString = sender.split('(?<=\\D)(?=\\d)')

Integer senderBalanceNums = (senderBalanceString[1]).replace('.', '').toInteger()

Integer updatedBalanceSenderNums = senderBalanceNums - inputBalanceNums

String updatedBalanceSenderString = ((senderBalanceString[0]) + updatedBalanceSenderNums.toString()) + '.00'

Mobile.verifyElementText(findTestObject('Object Repository/Transfer/Body/Receiving account/text_Spinner receiving acccount'), 
    updatedBalanceReceiverString)

Mobile.verifyElementText(findTestObject('Object Repository/Transfer/Body/Sending account/text_Spinner sending account'), 
    updatedBalanceSenderString)

driver.terminateApp(GlobalVariable.bundleID)

