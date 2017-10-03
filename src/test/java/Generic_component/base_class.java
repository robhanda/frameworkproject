package Generic_component;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class base_class
  
{
	
	 static String Appium_Node_Path="D:\\Appium\\node.exe";
    static String Appium_JS_Path="D:\\Appium\\node_modules\\appium\\bin\\appium.js";
    static AppiumDriverLocalService service;
     static String service_url;

    public static void appiumStart() throws Exception{
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
                usingPort(4723).usingDriverExecutable(new File(Appium_Node_Path)).
                withAppiumJS(new File(Appium_JS_Path)));
        service.start();
        Thread.sleep(25000);
        service_url = service.getUrl().toString();
	
	
    }
	
	
	

    public static void appiumStop() throws Exception{
        service.stop();

    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static AndroidDriver driver;
	public static void Init_app() throws InterruptedException, MalformedURLException
	{
DesiredCapabilities capabilities = new DesiredCapabilities();
	
	//mobile details
	
	capabilities.setCapability("deviceName","Lenovo A6020a46");
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("platformVersion", "5.1.1");
	
	//app details
	capabilities.setCapability("appPackage","com.bigbasket.mobileapp");
	capabilities.setCapability("appActivity","com.bigbasket.mobileapp.activity.SplashActivity");
	
	
	// Appium server details
	
	 driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	Thread.sleep(3000);
	}
	
	
	public static void ExplicitWait(WebElement ele,int T1)
	
	{
		
		WebDriverWait wait = new WebDriverWait(driver,T1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
