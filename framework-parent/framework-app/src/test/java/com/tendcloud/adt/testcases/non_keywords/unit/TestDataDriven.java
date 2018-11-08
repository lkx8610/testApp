package com.tendcloud.adt.testcases.non_keywords.unit;

import static framework.base.Verify.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.base.LoggerManager;
import framework.base.dataparser.excel.ExcelSheetData;
import test.base.TestGroups;

public class TestDataDriven{
	Logger logger = LoggerManager.getLogger(TestDataDriven.class);
	ExcelSheetData sheetData;
	ExcelReader reader;
	String sheetName = "CreateProductTest";
	
	@BeforeClass
	public void setup(){
		String filePath = "excel_test_data/Test-Data.xls";
		
		reader = new ExcelReader(filePath);
		
		sheetData = reader.getSheetDataBySheetName(sheetName);
	}

	@Test(groups=TestGroups.UNIT)
	@SuppressWarnings("all")
	public void testGetSigleRowData(){
		
		//String[] rowData = reader.getRowData("CreateProductTest", 2);
		for(int k=0; k<sheetData.getRowCount(); k++){
			int rowCount = 0;
			int colCount = 0;
			
			String[] rowData = reader.getSingleRowDataByRowIndex("CreateProductTest", k);
			for(int i=0; i<rowData.length; i++){
				String cellData = rowData[i];
			}
		}
	}
	
	@Test(groups=TestGroups.UNIT)
	public void testGetAllRowData(){
		List<String[]> rowDataList = new ArrayList<>();
		
		rowDataList = reader.getAllRowDataBySheetName(sheetName);
		
		verifyEquals(rowDataList.size(), 4, "第一行为标题栏，不应读取");
	}
}
