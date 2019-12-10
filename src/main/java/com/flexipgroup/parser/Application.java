package com.flexipgroup.parser;

import java.io.File;

import com.flexipgroup.parser.fileformat.FileFormat;

public class Application {
	
	private static String FILE_PATH_XML = "tmp/payment.xml";
	private static String FILE_PATH_XLS = "tmp/payment.xml";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File xmlfile = new File(FILE_PATH_XML);
		File xmlfile2 = new File(FILE_PATH_XLS);
		
		if(xmlfile.exists()) {
			
			String extension1 = xmlfile.getAbsolutePath().substring(xmlfile.getAbsolutePath().lastIndexOf(".")+1);
			String extension2 = xmlfile2.getAbsolutePath().substring(xmlfile2.getAbsolutePath().lastIndexOf(".")+1);
			
			System.out.println(extension1);
						
			System.out.println(FileFormat.isFileType(xmlfile));
						
			System.out.println(extension2);
			
			System.out.println(FileFormat.isFileType(xmlfile2));
		
		}
	}

}
