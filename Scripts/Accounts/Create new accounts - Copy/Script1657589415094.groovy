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

Mobile.tap(findTestObject('Menu/Left Menu/Body/android.widget.CheckedTextView - Accounts'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Accounts/Bottom/btn_Add account'), 0)

WebUI.delay(5)

Mobile.verifyElementVisible(findTestObject('Accounts/Add an Account/text_Add an Account'), 0)

Mobile.verifyElementVisible(findTestObject('Accounts/Add an Account/android.widget.EditText - Account Name'), 0)

Mobile.verifyElementVisible(findTestObject('Accounts/Add an Account/android.widget.EditText - Initial Balance (Optional)'), 
    0)

Mobile.verifyElementVisible(findTestObject('Accounts/Add an Account/android.widget.Button - ADD'), 0)

Mobile.verifyElementVisible(findTestObject('Accounts/Add an Account/android.widget.Button - CANCEL'), 0)

Mobile.tap(findTestObject('Accounts/Add an Account/android.widget.EditText - Account Name'), 0)

Mobile.setText(findTestObject('Accounts/Add an Account/android.widget.EditText - Account Name'), account_name, 0)

Mobile.tap(findTestObject('Accounts/Add an Account/android.widget.EditText - Initial Balance (Optional)'), 0)

Mobile.setText(findTestObject('Accounts/Add an Account/android.widget.EditText - Initial Balance (Optional)'), balance, 
    0)

Mobile.tap(findTestObject('Accounts/Add an Account/android.widget.Button - ADD'), 0)

WebUI.delay(5)


// =============================
// Defined Xpath
// =============================
Integer index = 1

String xpath = '\n//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ListView[1]/android.view.ViewGroup[\n'

String xpath2 = ']'

String fullXpath = (xpath + index) + xpath2

String viewImage1 = '/android.widget.ImageView[1]'

String viewText1 = '/android.widget.TextView[1]'

String viewText2 = '/android.widget.TextView[2]'

String viewText3 = '/android.widget.TextView[3]'


// =============================
// Get TestObject from Xpath
// =============================

def testObject = loopXpath.getTestObjectWithXpath(fullXpath)

def testObjectImage1 = loopXpath.getTestObjectWithXpath(fullXpath + viewImage1)

def testObjectText1 = loopXpath.getTestObjectWithXpath(fullXpath + viewText1)

def testObjectText2 = loopXpath.getTestObjectWithXpath(fullXpath + viewText2)

def testObjectText3 = loopXpath.getTestObjectWithXpath(fullXpath + viewText3)

boolean flag = true

while (flag) {
    // Check test object if its not exist
    if (!(Mobile.verifyElementExist(testObject, 0, FailureHandling.OPTIONAL))) {
        flag = false
        break
    }
    
    // Check test object if its not exist, after index + 1
    if (!(Mobile.verifyElementExist(loopXpath.getTestObjectWithXpath((xpath + (index + 1)) + xpath2), 0, FailureHandling.OPTIONAL))) {
        flag = false
        break
    }
    
	
	// Update Xpath and testObject
    index += 1

    fullXpath = ((xpath + index) + xpath2)

    testObject = loopXpath.getTestObjectWithXpath(fullXpath)
	
	testObjectText1 = loopXpath.getTestObjectWithXpath(fullXpath + viewText1)
	
	testObjectText2 = loopXpath.getTestObjectWithXpath(fullXpath + viewText2)
	
	testObjectText3 = loopXpath.getTestObjectWithXpath(fullXpath + viewText3)
	
}

Mobile.verifyElementText(testObjectText1, account_name)

Mobile.verifyElementText(testObjectText2, ('Account balance: $' + balance) + '.00')

Mobile.verifyElementText(testObjectText3, 'Account no: A' + index)

driver.terminateApp(GlobalVariable.bundleID)

