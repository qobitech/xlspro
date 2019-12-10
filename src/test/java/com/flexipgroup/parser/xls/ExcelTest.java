package com.flexipgroup.parser.xls;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.flexipgroup.parser.doctype.ACH_DOC_TYPE;
import com.flexipgroup.parser.doctype.NAPS_DOC_TYPE;
import com.flexipgroup.parser.doctype.NEFT_DOC_TYPE;
import com.flexipgroup.parser.doctype.SFU_DOC_TYPE;
import com.flexipgroup.parser.doctype.body.ACH_XLS_Body;
import com.flexipgroup.parser.doctype.body.NAPS_XLS_Body;
import com.flexipgroup.parser.doctype.body.NEFT_XLS_Body;
import com.flexipgroup.parser.doctype.body.SFU_XLS_Body;
import com.flexipgroup.parser.doctype.header.ACH_XLS_Header;
import com.flexipgroup.parser.doctype.header.NAPS_XLS_Header;
import com.flexipgroup.parser.doctype.header.NEFT_XLS_Header;
import com.flexipgroup.parser.doctype.header.SFU_XLS_Header;
import com.flexipgroup.parser.fileformat.FileFormat;
import com.flexipgroup.parser.xmlreader.XMLReader;
import com.flexipgroup.parser.xmlreader.XMLReaderModel;

public class ExcelTest {
	
	/**
	 * Test parsing of data (header data and body data) gotten from (xml, csv, txt) files to Excel File
	 *  
	 */
	public static void main (String []args) throws Exception{
	
		
	int columnNumber;
	int cellWidth = 6000;

	List<String>body;
	ArrayList<ArrayList<String>>ach;
	ArrayList<ArrayList<String>>naps;
	ArrayList<ArrayList<String>>neft;
	ArrayList<ArrayList<String>>sfu;
	
	System.out.println("reading file");
		
	String filePath = System.getProperty("user.home")+File.separator+"SFTPFOLDER/UBA_FILE_FORMAT/ach.xml";
	
	String saveDirectory = System.getProperty("user.home")+File.separator+"SFTPFOLDER/EXPORT";
	
	String fileType = null;
	
	File file = new File(filePath);
	
		if(!FileFormat.isFileType(file)) {
			//LOG
		}else {
		
			//read node and node value from file and store in a list
			List<XMLReaderModel> xmlData = XMLReader.xmlReading(filePath);
			
			//compare with uba file format
			if(ACH_DOC_TYPE.match2(xmlData) == ACH_XLS_Header.getACH_Header.size()) 
			{
				fileType = "ach";
				
			}else if(SFU_DOC_TYPE.match2(xmlData) == SFU_XLS_Header.getSFU_Header.size()) 
			{
				fileType = "sfu";
				
			}else if(NEFT_DOC_TYPE.match2(xmlData) == NEFT_XLS_Header.getNEFT_Header.size()) 
			{
				fileType = "neft";
				
			}else if(NAPS_DOC_TYPE.match2(xmlData) == NAPS_XLS_Header.getNAPS_Header.size()) 
			{
				fileType = "naps";
			}
			
		try {
			switch(fileType) {
			
				case "ach" : 
					//group body (node values) according to header
					ach = ACH_XLS_Body.mACHBodyFormat(xmlData);
					
					//store body (node values) to a list
					body = ExcelDetails.getbody(ach);
					
					//get number of columns per row
					columnNumber=ACH_XLS_Header.getACH_Header.size();
					
					//convert to xls file and output file to saveDirectory
					new Excel("ACH","OYOYO",columnNumber,cellWidth,"Calibri",ACH_XLS_Header.getACH_Header,
							body.size()/columnNumber,body,saveDirectory);
					break;
					
				case "sfu" : 
					
					sfu = SFU_XLS_Body.mSFUBodyFormat(xmlData);
					body = ExcelDetails.getbody(sfu);
					columnNumber=SFU_XLS_Header.getSFU_Header.size();
					
					new Excel("SFU","OYOYO",columnNumber,cellWidth,"Calibri",SFU_XLS_Header.getSFU_Header,
							body.size()/columnNumber,body,saveDirectory);
					break;
					
				case "neft" : 
					
					neft = NEFT_XLS_Body.mNEFTBodyFormat(xmlData);
					body = ExcelDetails.getbody(neft);
					columnNumber=NEFT_XLS_Header.getNEFT_Header.size();
					
					new Excel("NEFT","OYOYO",columnNumber,cellWidth,"Calibri",NEFT_XLS_Header.getNEFT_Header,
							body.size()/columnNumber,body,saveDirectory);
					break;
					
				case "naps" : 
					
					naps = NAPS_XLS_Body.mNAPSBodyFormat(xmlData);
					body = ExcelDetails.getbody(naps); 
					columnNumber=NAPS_XLS_Header.getNAPS_Header.size();
					
					new Excel("NAPS","OYOYO",columnNumber,cellWidth,"Calibri",NAPS_XLS_Header.getNAPS_Header,
							body.size()/columnNumber,body,saveDirectory);
					break;
					
				default : break;
			}
		}catch(NullPointerException nec) {
			
		}
		
		
		
		
	}
	
	
	
	
	
		
		//xmlData = XMLReader.xmlReading(xmlFilePath);
//		xmlData2 = XMLReader.xmlReading(filePath);
//		
//		neftHeaderData = NEFT_XLS_Header.getNEFT_Header;
//		
//		neft = NEFT_XLS_Body.mNEFTBodyFormat(xmlData2);		
//		
//		body = ExcelDetails.getbody(neft);
				
		
	
		//System.out.println(neft.size()/neftHeaderData.size());
		
		//System.out.println("BODY: "+body.size());
		
//		body.forEach(e->{System.out.println(e);});
//		
//		//System.out.println("HEADER : "+neftHeaderData.size());
//		
//		//System.out.println("HEADER : "+achHeaderData.size());
//		
//		
//		new Excel("BIZZLE","OYOYO",columnNumber,cellWidth,"Calibri",neftHeaderData,
//				body.size()/columnNumber,body,saveDirectory);
	}
	
	
	
}
