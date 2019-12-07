package com.flexipgroup.parser.xslx;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.flexipgroup.parser.doctype.body.NAPS_XLS_Body;
import com.flexipgroup.parser.doctype.header.ACH_XLS_Header;
import com.flexipgroup.parser.doctype.header.NAPS_XLS_Header;
import com.flexipgroup.parser.doctype.header.NEFT_XLS_Header;
import com.flexipgroup.parser.doctype.header.SFU_XLS_Header;
import com.flexipgroup.parser.xls.Excel;
import com.flexipgroup.parser.xmlreader.XMLReader;

public class XLSFormatRepoImpl {//implements XLSFormatRepo{

	private Excel excel;
	private List<String> header;
	private List<String> body;
	private int columnNumber;
	private int rowNumber;
	private final int CELL_SIZE = 600;
	
	public String [] ges(String name,String address,String gender,String email) {
		return new String[] {name,address,gender,email};
	}

	private String saveDirectory = System.getProperty("user.home")+File.separator+"SFTPFOLDER/";
	
//	@Override
//	public Excel get_SFU_File(){
//		
//		header = SFU_XLS_Header.getSFU_Header;
//		body = SFU_XLS_Body.mSFUBodyFormat(XMLReader.xmlReading(System.getProperty("user.home")+File.separator+"SFTPFOLDER/sfu.xml"
//				));
//		
//		columnNumber = header.size();
//		rowNumber = body.size();
//			
//		try {
//			excel = new Excel("SFU_XLS_FILE","BISCUIT",columnNumber,CELL_SIZE,"Calibri",header,rowNumber,body,saveDirectory);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		return excel;
//	}
//	
//	public static void main (String [] args)
//	{
//		new XLSFormatRepoImpl().get_SFU_File();
//	}
//
//	
//	@Override
//	public Excel get_MDMC_File(MDMC_XLS_Body file) {
//		
//		header = ACH_XLS_Header.getMDMC_Header;
//		body = MDMC_XLS_Body.getMDMC_Body;
//		
//		columnNumber = header.size();
//		rowNumber = body.size();
//			
//		try {
//			excel = new Excel("MDMC_XLS_FILE","",columnNumber,CELL_SIZE,"Calibri",header,rowNumber,body,saveDirectory);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		return excel;
//	}
//
//	@Override
//	public Excel get_NAPS_File(NAPS_XLS_Body file) {
//		
//		header = NAPS_XLS_Header.getNAPS_Header;
//		body = NAPS_XLS_Body.getNAPS_Body;
//		
//		columnNumber = header.size();
//		rowNumber = body.size();
//			
//		try {
//			excel = new Excel("NAPS_XLS_FILE","",columnNumber,CELL_SIZE,"Calibri",header,rowNumber,body,saveDirectory);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		return excel;
//	}
//
//	@Override
//	public Excel get_NEFT_File(NEFT_XLS_Body file) {
//		
//		header = NEFT_XLS_Header.getNEFT_Header;
//		body = NEFT_XLS_Body.getNEFT_Body;
//		
//		columnNumber = header.size();
//		rowNumber = body.size();
//			
//		try {
//			excel = new Excel("NEFT_XLS_FILE","",columnNumber,CELL_SIZE,"Calibri",header,rowNumber,body,saveDirectory);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		return excel;
//	}

}
