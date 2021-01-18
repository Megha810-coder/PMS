package com.spcl.erp.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.LabourDao;
import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Contractor;

public class ExportContractor {
	
	@Autowired
	private LabourDao labourDao;
	
	@Autowired
	private Helper helper;
	

	public void setLabourDao(LabourDao labourDao) {
		this.labourDao = labourDao;
	}
	
	 private static String[] columns = {"Sr no","Contractor code","Title","FirstName", "MiddleName", "LastName", "Gender","Marital status","Date of birth","Mobile","Date of Joining"};
	    
	    
	    public File buildExcelFile() throws IOException, InvalidFormatException {
	    	
	        List<Contractor> Cons = new ArrayList<Contractor>();
	        Cons = labourDao.getContractor_list();
	        
	        File dwnfile = new File(helper.EMP_EXCEl_PATH+"contractor_list.xlsx");
	        		
	        // Create a Workbook
	        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

	        /* CreationHelper helps us create instances of various things like DataFormat, 
	           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
	        	CreationHelper createHelper = workbook.getCreationHelper();

	        // Create a Sheet
	        Sheet sheet = workbook.createSheet("Contractor");

	        org.apache.poi.ss.usermodel.Font headerFont = null;
			// Create a Font for styling header cells
	        headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setFontHeightInPoints((short) 14);
	        headerFont.setColor(IndexedColors.BLACK.getIndex());

	        // Create a CellStyle with the font
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFont(headerFont);

	        // Create a Row
	        Row header = sheet.createRow(0);

	     // Create cells
	        for(int i = 0; i < columns.length; i++) {
	            Cell cell = header.createCell(i);
	            cell.setCellValue(columns[i]);
	            cell.setCellStyle(headerCellStyle);
	        }

	        // Create Cell Style for formatting Date
	        CellStyle dateCellStyle = workbook.createCellStyle();
	        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

	        // Create Other rows and cells with employees data
	        int rowNum = 1;
	        int no=1;
	        for(Contractor con: Cons) {
	        	Row userRow =  sheet.createRow(rowNum++);
	        	userRow.createCell(0).setCellValue(no++);
	        	userRow.createCell(1).setCellValue(con.getCd_code());
	            userRow.createCell(2).setCellValue(con.getCd_title());
	            userRow.createCell(3).setCellValue(con.getCd_fname());
	            userRow.createCell(4).setCellValue(con.getCd_mname());
	            userRow.createCell(5).setCellValue(con.getCd_lname());
	            Integer value=con.getCd_gender();
	            if(value==1)
	            {
	            		userRow.createCell(6).setCellValue("Male");
	            }
	            else if(value==2) 
	            {
	            	
	            	userRow.createCell(6).setCellValue("Female");
	            }
	            else if(value==3)
	            {
	            	userRow.createCell(6).setCellValue("Transgender");
	            }
	            Integer value1=con.getCd_marital_status();
	            if(value1==1)
	            {
	            	userRow.createCell(7).setCellValue("Single");
	            }
	            else if(value1==2)
	            {
	            	userRow.createCell(7).setCellValue("Married");
	            }
	            else if(value1==3)
	            {
	            	userRow.createCell(7).setCellValue("Divorce");
	            }
	            else if(value1==4)
	            {
	            	userRow.createCell(7).setCellValue("Widowe");
	            }
	            else if(value1==5)
	            {
	            	userRow.createCell(7).setCellValue("Legal Cohabitant");
	            }
	            Cell dateOfBirthCell = userRow.createCell(8);
	            dateOfBirthCell.setCellValue(con.getCd_dob());
	            dateOfBirthCell.setCellStyle(dateCellStyle);
	            userRow.createCell(9).setCellValue(con.getCd_mobile_no());
	            Cell dateOfJoiningCell = userRow.createCell(10);
	            dateOfJoiningCell.setCellValue(con.getCd_join_date());
	            dateOfJoiningCell.setCellStyle(dateCellStyle);
	        }

	         // Resize all columns to fit the content size
	            for(int i = 0; i < columns.length; i++) {
	                sheet.autoSizeColumn(i);
	            }
	            
	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream(dwnfile);
	        workbook.write(fileOut);
	        fileOut.close();

	        // Closing the workbook
	        ((XSSFWorkbook) workbook).close();
	        return dwnfile;
	    }
	    
}
