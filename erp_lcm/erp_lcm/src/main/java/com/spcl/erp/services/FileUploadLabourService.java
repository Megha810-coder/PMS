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

import com.spcl.erp.dao.LabourDao;
import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.City;
import com.spcl.erp.model.Department_type;
import com.spcl.erp.model.Labour;

public class FileUploadLabourService {
	
	@Autowired
	private LabourDao labourDao;
	
	@Autowired
	private Helper helper;
	
	
	public void setHelper(Helper helper) {
		this.helper = helper;
	}

	public void setLabourDao(LabourDao labourDao) {
		this.labourDao = labourDao;
	}

	public void uploadLabourFileData(File inputFile, Helper helper){
		Workbook workbook = null;
		Sheet sheet = null;
		try
		{

			workbook = getWorkBook(inputFile);
			sheet = workbook.getSheetAt(0);

			/*Build the header portion of the Output File*/
			String methodDetails= "Lab_title,"
					+ "Lab_fname,Lab_mname,"
					+ "Lab_lname,Lab_gender,"
					+ "Enq_city,Lab_marital_status,Lab_dob,"
					+"Lab_join_date,Lab_mobile_no,Department";
			
			
			String inputDetails= "java.lang.String"
					+ ",java.lang.String,java.lang.String"
					+ ",java.lang.String,java.lang.Integer"
					+ ",java.lang.String,java.lang.Integer,java.util.Date"
					+",java.util.Date,java.lang.String,java.lang.String";
			
			String methodNames[] = methodDetails.split(",");
			String inputNames[] = inputDetails.split(",");

			/*Read and process each Row*/
			ArrayList<Labour> labourList = new ArrayList<>();
			
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
				Integer count1=0;
				Labour labour = new Labour();
				labour.setLab_code(helper.getLabourCode()+count1++);
				labour.setLab_active(1);
				Date dat=new Date(new java.util.Date().getTime());
				labour.setLab_created_date(dat);
				int count=0;
				while(count<methodNames.length){
					String methodName = "set"+methodNames[count];
					String inputName = inputNames[count];
					String inputCellValue = getCellValueBasedOnCellType(row,count++);
					if(count==5)
					{
						if(inputCellValue.equals(helper.GENDER_FEMALE))
						{
							inputCellValue="2";
						}
						else if(inputCellValue.equals(helper.GENDER_MALE))
						{
								inputCellValue="1";
						}
					}
					if(count==6)
					{
						if(inputCellValue!=null&&!inputCellValue.equals(""))
						{
							City lab_city=helper.getCityByName(inputCellValue);
							labour.setEnq_city(lab_city);
						}
						
					}
					if(count==7)
					{
						if(inputCellValue.equals(helper.MARITAL_SINGLE))
						{
							inputCellValue="1";
						}
						else if(inputCellValue.equals(helper.MARITAL_MARRIED))
						{
							inputCellValue="2";
						}
						else if(inputCellValue.equals(helper.MARITAL_DIVORCE))
						{
							inputCellValue="3";
						}
						else if(inputCellValue.equals(helper.MARITAL_WIDWOE))
						{
							inputCellValue="4";
						}
						else if(inputCellValue.equals(helper.MARITAL_LEGAL_COHABITANT))
						{
							inputCellValue="5";
						}
					}
					if(count==11)
					{
						Department_type dept_id = helper.getDeptByName(inputCellValue);
						labour.setDepartment(dept_id);
					}
					if (count!=6 && count!=11) {
						setValueIntoObject(labour, Labour.class, methodName, inputName, inputCellValue);
					}	
					
					
				}
				labourList.add(labour);
			}
		labourDao.saveFileDataInDB(labourList);

		}
		catch(Exception ex){
			ex.printStackTrace();
		}

		return;
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

	private static <T> void setValueIntoObject(
			Object obj, 
			Class<T> clazz, 
			String methodNameForField, 
			String dataType, 
			String inputCellValue)
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
