package com.spcl.erp.services;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.EHSDao;
import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Contractor;
import com.spcl.erp.model.HIRA;

public class ImportHira {
	
	@Autowired
	private EHSDao ehsDao;
	
	@Autowired
	private Helper helper;
	
	public void setEhsDao(EHSDao ehsDao) {
		this.ehsDao = ehsDao;
	}
	
	public String uploadHiraFileData(File inputFile, Helper helper){
		Workbook workbook = null;
		Sheet sheet = null;
		try
		{

			workbook = getWorkBook(inputFile);
			sheet = workbook.getSheetAt(0);

			/*Build the header portion of the Output File*/
			String methodDetails= "Activity,"
					+ "Land,Air,"
					+ "Water,Human,"
					+ "Resource,Land1,Air1,"
					+"Water1,Human1,Resource1,Total_rating"
					+",Legal,Frequency,Impact_rating";
			
			
			String inputDetails= "java.lang.String"
					+ ",java.lang.String,java.lang.String"
					+ ",java.lang.String,java.lang.String"
					+ ",java.lang.String,java.lang.Integer,java.lang.Integer"
					+ ",java.lang.Integer,java.lang.Integer,java.lang.Integer,java.lang.Integer"
					+",java.lang.Integer,java.lang.Integer,java.lang.Integer";
			
			String methodNames[] = methodDetails.split(",");
			String inputNames[] = inputDetails.split(",");

			/*Read and process each Row*/
			ArrayList<HIRA> hiraList = new ArrayList<>();
			
			Iterator<Row> rowIterator = sheet.iterator();
			int row_count=0;
			while(rowIterator.hasNext())
			{	
				Row row = rowIterator.next();
				if (row_count==0) {
					row = rowIterator.next();
					row_count++;
				}
				
				//Read and process each column in row
				HIRA hira = new HIRA();
				hira.setHira_active(1);
				hira.setHira_active(1);
				int count=0;
				while(count<methodNames.length){
					String methodName = "set"+methodNames[count];
					String inputName = inputNames[count];
					String inputCellValue = getCellValueBasedOnCellType(row,count++);
					setValueIntoObject(hira, HIRA.class, methodName, inputName, inputCellValue);
					
				}
				hiraList.add(hira);
			}
		ehsDao.saveHiraFileDataInDB(hiraList);

		}
		catch(Exception ex){
			ex.printStackTrace();
		}

		return "Success";
	}
	
	public static Workbook getWorkBook(File fileName)
	{
		Workbook workbook = null;
		try {
			String myFileName=fileName.getName();
			String extension = myFileName.substring(myFileName.lastIndexOf("."));
			if(extension.equalsIgnoreCase(".xls")){
				workbook = new HSSFWorkbook(new FileInputStream(fileName));
			}
			else if(extension.equalsIgnoreCase(".xlsx")){
				workbook = new XSSFWorkbook(new FileInputStream(fileName));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return workbook;
	}
	
	public static String getCellValueBasedOnCellType(Row rowData,int columnPosition)
	{
		String cellValue=null;
		Cell cell = rowData.getCell(columnPosition);
		if(cell!=null){
			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			{
				String inputCellValue=cell.getStringCellValue();
				if(inputCellValue.endsWith(".0")){
					inputCellValue=inputCellValue.substring(0, inputCellValue.length()-2);
				}
				cellValue=inputCellValue;
			}
			else if (cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
			{
				Double doubleVal = new Double(cell.getNumericCellValue());
				cellValue= Integer.toString(doubleVal.intValue());
			}
		}
		return cellValue;
	}

	private static <T> void setValueIntoObject(Object obj, Class<T> clazz, String methodNameForField, String dataType, String inputCellValue)
			throws SecurityException, NoSuchMethodException, ClassNotFoundException, NumberFormatException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{

		Method meth = clazz.getMethod(methodNameForField, Class.forName(dataType));
		T t = clazz.cast(obj);

		if("java.lang.Double".equalsIgnoreCase(dataType))
		{
			meth.invoke(t, Double.parseDouble(inputCellValue));
		}else if("java.lang.Integer".equalsIgnoreCase(dataType))
		{
			meth.invoke(t, Integer.parseInt(inputCellValue));
		}
		else if("java.util.Date".equalsIgnoreCase(dataType))
		{
			meth.invoke(t, new Date(inputCellValue));
		}
		else if("java.util.Long".equalsIgnoreCase(dataType))
		{
			meth.invoke(t, Long.parseLong(inputCellValue));
		}
		else
		{
			meth.invoke(t, inputCellValue);
		}
	}


}
