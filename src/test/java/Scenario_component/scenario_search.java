package Scenario_component;

import java.net.MalformedURLException;
import java.util.Map;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_component.base_class;
import Pageobject_component.Pageobject_search;



public class scenario_search extends base_class {
	
	
	public static Logger log = Logger.getLogger(scenario_search.class);
	
	SoftAssert sAssert = new SoftAssert();
	

	// with this no need to create object of class, cn be accessed throgh dataprovider name only
	@Test(dataProvider="dp_InvalidSearch",dataProviderClass=Dataprovider_Component.Dataprovider_search.class)
	public void testInvalidSearch(Map search) throws Exception
	{
		System.out.println("1");
		String TC_ID= search.get("TC_ID").toString();
		String Order= search.get("Order").toString();
		String search_item= search.get("search_item").toString();
		String expected_result= search.get("expected_result").toString();
		System.out.println(TC_ID);
		System.out.println("2");
		appiumStart();
		Thread.sleep(10000);
		
		log.info("executing the test case"+TC_ID+"order is"+Order);
		Init_app();
		System.out.println("3");
		Pageobject_search BS_pob = new Pageobject_search(driver);
		
		ExplicitWait(Pageobject_search.Search_btn, 25);
		BS_pob.click_searchbtn();
		
		BS_pob.sendvalues(search_item);
		
		ExplicitWait(BS_pob.invalid_search,25);
		 String actual_result= BS_pob.getInvalidmsg();
		
		
		if(actual_result.equals(expected_result))
			
			
{
		
			
	log.info(" Passed as actual result is"+actual_result+"and expected reult is"+expected_result);		
			
	//System.out.println("pass");
}
		 
else
{
	log.info(" failed as actual result is"+actual_result+"and expected reult is"+expected_result);	
	//System.out.println("fail");
	sAssert.fail(" failed as actual result is"+actual_result+"and expected reult is"+expected_result);
}
		 
		 sAssert.assertAll();
		appiumStop();	 
		 
		 
	}
	
	
	
	
	/*
	@Test
	public void testValidSearch()
	{
		
	}
	
	*/
	
}
