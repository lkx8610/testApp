package com.tendcloud.adt.testcases.non_keywords.unit;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import framework.base.LoggerManager;
import framework.base.dataparser.excel.ExcelPaser;
import framework.base.dataparser.excel.ExcelSheetData;

/**
 * @description TODO
 * @author James Guo
 **/
public class ExcelReader {
	private Logger logger = LoggerManager.getLogger(ExcelReader.class.getSimpleName());

	private static ExcelSheetData sheetData;
	//private static Map<String, ExcelSheetData> sheetDataMap = null;
	
	ExcelPaser excelPaser = null;

	private String fileName = null;

	public ExcelReader(String filePath) {
		fileName = filePath;
		
		loadExcel(filePath);
	}

	private void loadExcel(String filePath) {//在生成ExcelParser对象的时候，就已经将指定的Excel文件加载成功了。
		try {
			excelPaser = new ExcelPaser(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] getCallList() {
		return sheetData.getCallData(0);
	}
	/**
	 * 获取指定Sheet中的指定行的行数据
	 * @author James Guo
	 * @param sheetName
	 * @param rowIndex
	 * @return
	 */
	public String[] getSingleRowDataByRowIndex(String sheetName, int rowIndex) {
		//return sheetData.getSheetDataSet().get(rowIndex);
		return getSheetDataBySheetName(sheetName).getRowData(rowIndex);
	}
	
	/**
	 * 根据传入的SheetName取出该Sheet中所有的行数据
	 */
	public List<String[]> getAllRowDataBySheetName(String sheetName){
		List<String[]> rowDataList = new ArrayList<>();
		
		for(int k=0; k<sheetData.getRowCount(); k++){
			String[] rowData = getSingleRowDataByRowIndex(sheetName, k);
			rowDataList.add(rowData);
			}
		
		return rowDataList;
	}
	/**
	 * 根据SheetName取出该Sheet中的数据；
	 * @author James Guo
	 * @param sheetName
	 * @return
	 */
	public ExcelSheetData getSheetDataBySheetName(String sheetName){
		return excelPaser.getSheetDataByName(sheetName);
	}
}

	
