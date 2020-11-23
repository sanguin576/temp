package com.dummy.controller.security;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.hssf.usermodel.HSSFCellStyle;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractExcelView;



/**
 * Creates a User InformationExcel File
 * 
 * @author FXG7019 Fabian Gargaglione
 * 
 */
public class ExcelBuilderUserInfo extends AbstractExcelView{
		
	private static final String USER_ID = "UserID";
	private List<String> roleList;
	private List<String> businessList;
	private String environment;
	private String sessionID;
	private JSONObject userInfo;
	private String userID;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Excel Settings
		XSSFWorkbook excel = new XSSFWorkbook();
		Sheet excelSheet = excel.createSheet( "User Info" );
		excelSheet.setDefaultColumnWidth(30);

		// Load Data into class properties
		if(model.containsKey("userInfo")){
        	userInfo = (JSONObject)model.get("userInfo");
        }
		if(model.containsKey("sessionID")){
			sessionID = model.get("sessionID").toString();
		}
		if(model.containsKey("environment")){
        	environment = model.get("environment").toString();
        }
		if(model.containsKey("roles")){
        	roleList = (List<String>) model.get("roles");
        }
        if(model.containsKey("business")){
        	businessList = (List<String>) model.get("business");
        }
        
        // Populate Excel
        fillExcel(excel, excelSheet);
        
        // File Settings
        String fileName = userID + "_Information";
        
        // Save Properties
        OutputStream out = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream( );
		excel.write(baos);
		
		// Set File Headers
        int length = baos.size( );
        response.setHeader("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + ".xlsx\"");
        response.setHeader( "Content-Length", length + "" );
        
        // Send File typOf ByteArray
		out = response.getOutputStream();
		out.write(baos.toByteArray());
		out.close();		        
	}
	
	private void fillExcel(Workbook excel, Sheet excelSheet){
		// Start Settings
		int startX = 0;
		int startY = 0;
		int maxColumns = 4; // Max Columns Starts at 0
		
		Row row;
						
		// Header Styles
		CellStyle styleHeader = excel.createCellStyle();
		Font font = excel.createFont();
		font.setColor(HSSFColor.WHITE.index);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		styleHeader.setFillForegroundColor(HSSFColor.BLUE.index);
		styleHeader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);		
		styleHeader.setFont(font);
		
		// Label Styles
		CellStyle labelStyle = excel.createCellStyle();
		Font fontLabel = excel.createFont();
		fontLabel.setColor(HSSFColor.BLACK.index);
		labelStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		labelStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		labelStyle.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);				
		labelStyle.setFont(fontLabel);
		setBorder(labelStyle);
		
		// Text Style
		CellStyle textStyle = excel.createCellStyle();
		textStyle.setWrapText(true);
		textStyle.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
		setBorder(textStyle);
		
		// Populate Environment
		row = excelSheet.createRow(startY);
		createCellAndSetValue(startX, "User Environment", row, styleHeader); // Header
		excelSheet.addMergedRegion(new CellRangeAddress(startY, startY, startX, startX + 1));
		row = excelSheet.createRow(++startY);
		createCellAndSetValue(startX, "Environment", row, labelStyle);
		createCellAndSetValue(startX + 1, environment, row, textStyle);

		// Populate User Data
		if(userInfo.length() != 0){
			startX = 0;
			
			// Header
			row = excelSheet.createRow(++startY);
			createCellAndSetValue(startX, "User Information", row, styleHeader); 
			excelSheet.addMergedRegion(new CellRangeAddress(startY, startY, startX, startX + 1));
			// Full Name
			row = excelSheet.createRow(++startY);
			createCellAndSetValue(startX, "Name", row, labelStyle);
			createCellAndSetValue(startX + 1, userInfo.get("FirstName") 
					+ " " +userInfo.get("LastName"), row, textStyle);			
			// Set User ID
			row = excelSheet.createRow(++startY);
			userID = userInfo.get(USER_ID).toString(); 
			createCellAndSetValue(startX, "User ID", row, labelStyle);
			createCellAndSetValue(startX + 1, userInfo.get(USER_ID).toString(), row, textStyle);
			// AkaName
			row = excelSheet.createRow(++startY);
			createCellAndSetValue(startX, "AkaName", row, labelStyle);
			createCellAndSetValue(startX + 1, userInfo.get("AkaName").toString(), row, textStyle);
			// Domain User
			row = excelSheet.createRow(++startY);
			createCellAndSetValue(startX, "Domain User", row, labelStyle);
			createCellAndSetValue(startX + 1, userInfo.get(USER_ID).toString(), row, textStyle);
			// Session ID
			row = excelSheet.createRow(++startY);
			createCellAndSetValue(startX, "Session ID", row, labelStyle);
			createCellAndSetValue(startX + 1, sessionID, row, textStyle);
			startX = 0;			
		}
		
		// Populate Roles		
		if( !roleList.isEmpty()){
			row = excelSheet.createRow(++startY);
			createCellAndSetValue(0, "User Roles", row, styleHeader); // Header
			excelSheet.addMergedRegion(new CellRangeAddress(startY, startY, startX, startX + 3));
			row = excelSheet.createRow(++startY);
			for(int i = 0; i < roleList.size(); i++){
				// Jump to new Row [maxColumns]
				if( i % maxColumns == 0 && i != 0 ){
					row = excelSheet.createRow(++startY);
					startX = 0;
				}
				createCellAndSetValue(startX, roleList.get(i), row, textStyle);
				startX++;
			}
			// Reset Column
			startX = 0;			
		}
		
		// Populate Business Functions		
		if(!businessList.isEmpty()){
			row = excelSheet.createRow(++startY);
			createCellAndSetValue(0, "Business Functions", row, styleHeader); // Header
			excelSheet.addMergedRegion(new CellRangeAddress(startY, startY, startX, startX + 3));
			row = excelSheet.createRow(++startY);
			for(int i = 0; i < businessList.size(); i++){
				if( i % maxColumns == 0 && i != 0){
					row = excelSheet.createRow(++startY);
					startX = 0;					
				}
				createCellAndSetValue(startX, businessList.get(i), row, textStyle);
				startX++;
			}
			// Reset Column
		}		
	}
	
	private void createCellAndSetValue(int columnIndex, String value, Row row, CellStyle style) {

		if (StringUtils.isEmpty(value) || "-".equals(value)) {
			value = "N/A";
		}

		Cell cell = row.createCell(columnIndex, Cell.CELL_TYPE_STRING);
		cell.setCellValue(value);
		
		// Adding Styles to Cell if is necessary
		if( style != null){
			cell.setCellStyle(style);
		}
	}
	
	private void setBorder(CellStyle style){
		// Top Border		
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(HSSFColor.BLACK.index);
		// Right Border
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(HSSFColor.BLACK.index);
		// Bottom Border
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		// Left Border
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(HSSFColor.BLACK.index);		
	}
}
