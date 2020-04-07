package com.tm.Libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tm.BaseClass.Config;

public class UtilitiesLib extends Config{
	
	//=================================			
		static FileInputStream inpstr = null;
		static XSSFWorkbook wb1 = null;		
		
	//=================================	 
		public static String ReadCellData(int r, int c) throws IOException
		{
			String exlTCName = null;
			try{	
				
				File f1 = new File(TestDataPath);
				inpstr = new FileInputStream(f1);
				wb1 = new XSSFWorkbook(inpstr);					
				
				XSSFSheet ws1 = wb1.getSheet("Sheet1");	
				Row r1 = ws1.getRow(r);
				exlTCName = r1.getCell(c).getStringCellValue();
				//System.out.println("Test Name: " + exlTCName);							
			}				
			
			catch(IOException e)	{
				System.out.println("File not found or unable to read/write data..");
			}
			
			catch(Exception e)	{
				System.out.println(e.getMessage());
				System.out.println("unknown exception");
			}	
			
			return exlTCName;
			
		}
	//=================================	
		public static String[] ReadRowData(String TCName)
		{
			boolean bTag = false;
			String[] arr = new String[10];
			try{					
				File f1 = new File(TestDataPath);
				inpstr = new FileInputStream(f1);
				wb1 = new XSSFWorkbook(inpstr);
									
				XSSFSheet ws1 = wb1.getSheet("Sheet1");	
				
				int rowcount = ws1.getLastRowNum()+1;
				for(int i=1; i<rowcount; i++)
				{
					Row r1 = ws1.getRow(i);
					String exlTCName = r1.getCell(1).getStringCellValue();					
					if(TCName.equals(exlTCName))						
					{
						int colCount = r1.getLastCellNum();
						for(int j=2; j<=colCount; j++)
						{
							arr[j-2]  = r1.getCell(j).getStringCellValue();
						}		
													
						bTag = true;
						break;
					}						
				}
				
				if(bTag==false)
				{
					System.out.println("Test case Name not found in test data sheet");
				}
				
							
			}				
			
			catch(IOException e)	{
				System.out.println("File not found or unable to read/write data..");
			}
			
			catch(Exception e)	{
				System.out.println("unknown exception");
			}	
			
			return arr;
		}	
			
	
	//=================================		

}
