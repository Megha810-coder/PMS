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

import com.spcl.erp.dao.EHSDao;
import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Contractor;
import com.spcl.erp.model.HIRA;

public class ExportHira {
	
	@Autowired
	private EHSDao ehsDao;
	
	@Autowired
	private Helper helper;
	
	public void setEhsDao(EHSDao ehsDao) {
		this.ehsDao = ehsDao;
	}
	
	 private static String[] columns = {"Sr no","Activity","Aspect On Land","Aspect On Air", "Aspect On Water", "Aspect On Human Being", "Aspect On Resources","Imapct on Land","Imapct on Air", "Imapct on Water", "Imapct on Human Being", "Imapct on Resources","Total Rating","Legal Exposure","Frequency of Occurrence","Overall Impact Rating"};
	    
	    
	    public File buildExcelFile() throws IOException, InvalidFormatException {
	    	
	        List<HIRA> hira = new ArrayList<HIRA>();
	        hira = ehsDao.getHira_list();
	        
	        File dwnfile = new File(helper.EMP_EXCEl_PATH+"HIRA_list.xlsx");
	        		
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
	        for(HIRA hiras: hira) {
	        	Row userRow =  sheet.createRow(rowNum++);
	        	userRow.createCell(0).setCellValue(no++);
	        	userRow.createCell(1).setCellValue(hiras.getActivity());
	            userRow.createCell(2).setCellValue(hiras.getLand());
	            userRow.createCell(3).setCellValue(hiras.getAir());
	            userRow.createCell(4).setCellValue(hiras.getWater());
	            userRow.createCell(5).setCellValue(hiras.getHuman());
	            userRow.createCell(6).setCellValue(hiras.getResource());
	            userRow.createCell(7).setCellValue(hiras.getLand1());
	            userRow.createCell(8).setCellValue(hiras.getAir1());
	            userRow.createCell(9).setCellValue(hiras.getWater1());
	            userRow.createCell(10).setCellValue(hiras.getHuman1());
	            userRow.createCell(11).setCellValue(hiras.getResource1());
	            userRow.createCell(12).setCellValue(hiras.getTotal_rating());
	            userRow.createCell(13).setCellValue(hiras.getLegal());
	            userRow.createCell(14).setCellValue(hiras.getFrequency());
	            userRow.createCell(15).setCellValue(hiras.getImpact_rating());
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
