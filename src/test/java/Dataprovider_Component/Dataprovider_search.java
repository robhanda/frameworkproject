package Dataprovider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_component.ExcelReadWrite;

public class Dataprovider_search {
	
	//private static Setsheet ;

	@DataProvider(name="dp_InvalidSearch")
	public static Iterator<Object[]> getinvalidsearchdata() throws IOException
	
	{
	
		List<Object[]> obj = flagrowcount("InvalidSearch" );
		//return flagrowcount("scenario_search","InvalidSearch"); 
		return obj.iterator();
		
		// Iterator will return each element of list one by one. Infact each element of list has one object array.This object array
		//has map which has kay and value pair.like Tc_id,GB_01 etc
		
		
	}
	
	/*
	@DataProvider(name="dp_validSearch")
	public static Iterator<Object[]> getvalidsearchdata() throws IOException
	
	{
		
		List<Object[]> obj = flagrowcount("validSearch");
		return obj.iterator();
	}

	*/
	//static List<Object[]> arr_list = new ArrayList<Object[]>();
	
	public static  List<Object[]> flagrowcount(String scriptname) throws IOException
	
	{
		
		ExcelReadWrite xl = new ExcelReadWrite("D:\\BB_Project\\TestData\\TestData.xls");
		  HSSFSheet scenario_search = xl.Setsheet("scenario_search");
		  int rowcount = xl.getrowcount(scenario_search);
		 int colcount = xl.getcolcount(scenario_search, 0);
		 
		 
		  
		 List<Object[]> arr_list = new ArrayList<Object[]>();
		 
		  for(int i=1;i<=rowcount;i++)
		  {
			  String execute_flag = xl.Readvalue(scenario_search, i, "Execute_Flag");
			  String Script_name = xl.Readvalue(scenario_search, i, "Script_name");
			  
			  
			 // if(execute_flag=="Y"&&Script_name==scriptname)
				  
				  if((execute_flag.equals("Y")) &&(Script_name.equals(scriptname)))  
			  {
					  
				  Map<String,String> dsmap = new HashMap<String,String>();
				  
				  for(int j=0;j<colcount;j++)
				  {
					  String key = xl.Readvalue(scenario_search,0 ,j);
					  String value = xl.Readvalue(scenario_search, i, j);
					  
					  dsmap.put(key, value);
					  
					  				  
					  
				  } // end of for loop
				  
				  Object[] x = new Object[1];
				  x[0]=dsmap;
				  arr_list.add(x);
				  
			  }
			  
			  
			  
		  }// end of i for loop
		
		
		return arr_list;
		
	}
	
	
		
}
