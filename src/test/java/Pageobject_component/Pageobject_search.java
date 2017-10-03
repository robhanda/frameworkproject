package Pageobject_component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Pageobject_search {
	
	public AndroidDriver driver;
	
	//FindBy is equal to find element by id/xpath findby should not be closed by ; as below line is part of same statement
	
	
	
	// 2nd section with FindBy annotations
	
	@FindBy(id="com.bigbasket.mobileapp:id/homePageSearchBox")
	public
	static WebElement Search_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgSearchTermAction")
	public WebElement Search_btn2;
	
	@FindBy(id="com.bigbasket.mobileapp:id/bbBottomNavItemIcon")
	public WebElement invalid_search;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductCount")
	public WebElement valid_search;
	
	
	
	
	
	// ist section-initializing pagefactory through constructor
	
	public Pageobject_search (AndroidDriver driver)
	
	
	{
				
		PageFactory.initElements(driver, this);		
		
	}
	
	
	//3rd section-methods
	
	public static void click_searchbtn()
	
	{
		Search_btn.click();
	}
	
	public static void sendvalues(String value)
	{
		Search_btn.sendKeys(value+"/n");
	}

		
	public String getInvalidmsg()
	{
	 return	invalid_search.getText();
	}
	
	
	public String getvalidmsg()
	{
	 return	valid_search.getText();
	}
	
	
	}
	
	

