package com.flexipgroup.parser.xls;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Excel {
	
	private HSSFFont xlsfont;
	private Row row;
	private Cell cell;
	private Workbook workbook;
	private Row rowheader;
	private Cell headerCell;
	private CellStyle headerStyle;
	private CellStyle style;

	private Excel() {}
	
	private Workbook runXLSHeader(String pageName,int setWidthLoop ,int numberNWidth,int cellwidth,int headerRowIndex,String fontName,
			int headerRowPosition,List <String> headercellValue,int numHeaderColumns,int bodyrowiterate,int bodycelliterate,
			List <String> bodycellValue)
	{
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = setXLSSheet (workbook,pageName,setWidthLoop,numberNWidth,cellwidth); 				
		this.rowheader = sheet.createRow(headerRowIndex); 
		this.headerStyle = workbook.createCellStyle();
		this.headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		this.headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
		this.xlsfont = setXLSFont (workbook, fontName);
		this.headerStyle.setFont(xlsfont);
		//HEADER
		this.headerCell = this.rowheader.createCell(headerRowPosition);
		createHeader(numHeaderColumns, this.headerStyle,this.rowheader,this.headerCell,headercellValue);
		//Write content of table
		this.style = workbook.createCellStyle();
		this.style.setWrapText(true);	
		createRow(bodyrowiterate, bodycelliterate, sheet, style, row, cell,bodycellValue);		
		return workbook;
	}
	
	private void prepareXLSExcelFile (String fileName,String pageName,int N,int cellwidth,String fontName,List<String>cellValue,
			int bodyrowiterate,List<String>bodycellValue,String saveDirectory) throws IOException {
		
		//HEADER		
		workbook = runXLSHeader(pageName,0,N,cellwidth,0,fontName,0,cellValue,N,bodyrowiterate,N,bodycellValue);
		
		//write content to file
		File currDir = new File(saveDirectory);
		String path = currDir.getAbsolutePath();
		String fileLocation = path.substring(0, path.length()) + "/"+fileName+".xls";
		 
		FileOutputStream outputStream = new FileOutputStream(fileLocation);
		workbook.write(outputStream);
		workbook.close();		
	}
	
	public Excel(String fileName,String pageName,int N,int cellwidth,String fontName,List<String>cellValue,
			int bodyrowiterate,List<String>bodycellValue,String saveDirectory) throws IOException {
		prepareXLSExcelFile (fileName,pageName,N,cellwidth,fontName,cellValue,bodyrowiterate,bodycellValue,saveDirectory);
	}
	
	private HSSFSheet setXLSSheet (HSSFWorkbook workbook,String pageName,int loop,int n,int width)
	{
		HSSFSheet sheet = workbook.createSheet(pageName);
		while(loop < n)
		{
			sheet.setColumnWidth(loop, width);
			loop++;
		}
		return sheet;
	}	
	
	private HSSFFont setXLSFont (Workbook workbook, String fontName)
	{
		HSSFFont font = ((HSSFWorkbook) workbook).createFont();
		font.setFontName(fontName);
		font.setFontHeightInPoints((short) 16);
		font.setBold(true);
		return font;
	}
	
	private void createHeader(int iterate,CellStyle headerStyle,Row header,Cell headerCell,List <String> cellValue)
	{
		for(int i=0; i < iterate; i++)
		{
			headerCell = header.createCell(i);
			headerCell.setCellValue(cellValue.get(i));				
//			headerCell.setCellStyle(headerStyle);
		}
		
	}
	
	private Row createRow(int rowiterate,int celliterate,Sheet sheet,CellStyle style,Row row,Cell cell,List<String>cellValue)
	{
		for(int i=1;i<rowiterate+1;i++) 
		{
			row = sheet.createRow(i);
			
			for(int j=0;j<celliterate+1;j++) 
			{		 
				cell = row.createCell(j);
				cell.setCellValue(cellValue.get(j));
				cell.setCellStyle(style);
			}			
		}
		return row;
	}

	
}
