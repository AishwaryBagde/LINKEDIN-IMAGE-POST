package demo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import org.apache.hc.core5.http.nio.entity.NoopEntityConsumer;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01()throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        
        // 1. Launch Browser (Chrome) :ChromeDriver()
        // 1.2 Maximize Window :driver.windows().manage().maximize();
        // 1.5 Handle Sync issue using implicitlyWait() :driver.windows().timeouts().implicitlyWait(30,TimeUnit.SECONDS)
        // 2. Load URL :https://www.linkedin.com/home
        driver.get("https://www.linkedin.com/home");
        Thread.sleep(3000);
	//IF YOU ARE TRYING TO RUN THIS CODE PLEASE ENTER YOUR
        // 3. Locate the Email text Box & Enter Email "PLEASE ENTER YOUR EMAIL ID"  Using Locator "ID":"session_key" / sendKeys("lszaxs@gmail.com");
        WebElement emailTxtBox = driver.findElementById("session_key");
        emailTxtBox.click();
        emailTxtBox.sendKeys("PLEASE ENTER YOUR EMAIL ID");
        Thread.sleep(2000);
	//IF YOU ARE TRYING TO RUN THIS CODE PLEASE ENTER YOUR PASS
        // 4. Locate the Password text Box & Enter Password "PLEASE ENTER YOUR PASS"  Using Locator "ID":"session_password" / sendKeys("bqfDMBxp!bMS658");
        WebElement passTxtBox = driver.findElementById("session_password");
        passTxtBox.click();
        passTxtBox.sendKeys("PLEASE ENTER YOUR PASS");
        Thread.sleep(2000);
        // 5. Click on Sign in button Using Locator "XPath":"//button[@data-id='sign-in-form__submit-btn']" / click();
        WebElement signIn =  driver.findElementByXPath("//button[@data-id='sign-in-form__submit-btn']");
        signIn.click();
        Thread.sleep(2000);
        // 6. Locate the name Present on the page And Print it Using Locator "XPath":"//div[@class='t-16 t-black t-bold']" / getText();
        WebElement name = driver.findElementByXPath("//div[@class='t-16 t-black t-bold']");
        System.out.println("The Username is : "+ name.getText());
        Thread.sleep(1000);
       
        // 7. Click on "Start Post"  Using Locator "XPath":"//span[text()='Start a post']" / click();
        WebElement startPostBtn = driver.findElementByXPath("//span[text()='Start a post']");
        startPostBtn.click();
        Thread.sleep(1000);
        // 8. Locate the Text Box And Write "Posting Image By Using Selenium code!" Using Locator "XPath":"//div[@role='textbox']" / sendKeys("This Post Is Written using Selenium Code!")
        WebElement textBox = driver.findElementByXPath("//div[@role='textbox']");
        textBox.click();
        textBox.sendKeys("Posting Image By Using Selenium code!");
        Thread.sleep(1000);

        //9. Verify if the Drop down Already has "Connection Only" Option Selected IF selected move to Step 14 Using Locator "XPath":"(//span[@class='share-state-change-button__label'])[1]"
        WebElement verifyDropDownOption = driver.findElementByXPath("(//span[@class='share-state-change-button__label'])[1]");
        if(!verifyDropDownOption.getText().equals("Connections only")) {
            System.out.println("Selecting Connections Option");
            
        // 10. Locate the DropDown and click on it Using Locator "XPath":"(//li-icon[@class='share-state-change-button__icon'])[2]" / click();
        WebElement dropDwon = driver.findElementByXPath("(//li-icon[@class='share-state-change-button__icon'])[2]");
        dropDwon.click();
        Thread.sleep(1000);
        // 11. Locate the "CONNECTIONS_ONLY" Option and click on it Using Locator "ID":"CONNECTIONS_ONLY" / click();
        WebElement selectOption = driver.findElementById("CONNECTIONS_ONLY");
        selectOption.click();
        Thread.sleep(1000);
       
        // 12. Locate the "Save" button and Click on it Using Locator "XPath":"(//button[@type='button'])[5]" / click();
        WebElement saveBtn = driver.findElementByXPath("(//button[@type='button'])[5]");
        saveBtn.click();
        Thread.sleep(1000);

        } else{
            System.out.println("Connection Only Option Already Selected ");
        }

       // 13. Locate the Image button and click on it Using Locator "XPath":"(//li-icon[@class='artdeco-button__icon'])[3]" / click():
       WebElement imageBtn = driver.findElementByXPath("(//li-icon[@class='artdeco-button__icon'])[3]");
       //imageBtn.click();
       Thread.sleep(1000);

      // 14. If normal click button does not work we can use Actions Class 
       Actions action = new Actions(driver);
       action.moveToElement(imageBtn).click().perform();
       Thread.sleep(1000);

       //15. Initializing Robot class to interact with window 
       Robot robot;
    try {
        robot = new Robot();
    
       robot.delay(250);

       //16. Initializng StringSelection class to Copy the Image file to Clipboard 
       StringSelection ss = new StringSelection("D:\\CRIO QA WORKSHOP\\Day 3 12-3-23\\Day 3 Activity\\3. ACTIVITY LINKEDIN IMAGE POST\\SELENIUM IMAGE.jpg");
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        // Perform ctrl + V action to paste the file
        robot.keyPress(KeyEvent.VK_CONTROL); 
        robot.keyPress(KeyEvent.VK_V); 

        robot.keyRelease(KeyEvent.VK_CONTROL); 
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(3000);
    } catch (AWTException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

        //17.  After uploading Image click on done button Using Locator "XPath":"(//button[@type='button'])[5]" / click():
        WebElement doneButton = driver.findElementByXPath("(//button[@type='button'])[5]");
        doneButton.click();
        Thread.sleep(3000);
       

         // 18. Locate the "Post" button and Click on it Using Locator "XPath":"//div[@class='share-box_actions']" / click();
         WebElement postBtn = driver.findElementByXPath("//div[@class='share-box_actions']");
         postBtn.click();
         Thread.sleep(3000);

         //19 Printing the Name of the User Using Locator "XPath":"(//div[@class='update-components-actor__meta relative'])[1]/span/span/span/span[@dir='ltr']" / getText();
         WebElement userName = driver.findElementByXPath("(//div[@class='update-components-actor__meta relative'])[1]/span/span/span/span[@dir='ltr']");
         System.out.println("The UserName who Posted the Image is : " + userName.getText());
         Thread.sleep(500);

        // 19. Verify That The post is Successfull by Printing the text Using Locator "XPath":"(//div[@class='update-components-text relative feed-shared-update-v2__commentary '])[1]"
        WebElement postTxt = driver.findElementByXPath("(//div[@class='update-components-text relative feed-shared-update-v2__commentary '])[1]");
        System.out.println("The Post Text is : " + postTxt.getText());
        Thread.sleep(500);

         // 20. Verify That The post is Successfull by Printing img src link   Using Locator "XPath":"//img[@class='ivm-view-attr__img--centered update-components-image__image lazy-image ember-view']" / getAttribute("src"); 
        WebElement imagePost = driver.findElementByXPath("//img[@class='ivm-view-attr__img--centered update-components-image__image lazy-image ember-view']");
        System.out.println("The Posted Image source is :"+ imagePost.getAttribute("src"));
        System.out.println("The Image is Successfully uploaded");
        


     
    }


}

