package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

//import P_DDF1_Github.XLUtility;

public class DataProviders { 
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException {
		
		String path = System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		AXLUtility xlutil = new AXLUtility(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1",1);
		
		String apidata[][]=new String[totalrows][totalcols]; 
		
		for(int i=1;i<=totalrows;i++) 
		 {
			for(int j=0;j<totalcols;j++) 
			{
				apidata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return apidata;  
} 
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException {
		
		String path = System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		AXLUtility xlutil = new AXLUtility(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		
		String apidata[]=new String[totalrows]; 
		
		for(int i=1;i<=totalrows;i++) 
		 {
			
				apidata[i-1] = xlutil.getCellData("Sheet1", i, 1);
		}
		
		return apidata;  
} 

}
