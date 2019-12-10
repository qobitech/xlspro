package com.flexipgroup.parser.fileformat;

import java.io.File;

public class FileFormat {
	/**
	 * To verify file extension of client files
	 * 
	 * @param fileExtension
	 * @return
	 */
	
	private static String extension;
	
	private FileFormat() {}
	
	public static boolean isFileType (File filePath) {
		if(!filePath.exists()) {
			//LOG
			System.out.println("file not exist");
		}else {
			extension = filePath.getAbsolutePath().substring(filePath.getAbsolutePath().lastIndexOf(".")+1);
			if(FileType.match(extension)!=null)return true;
		}
			return false;
	}
	
	private enum FileType {
		
		XML("xml"),
		TEXT("txt"),
		XSL("xls"),
		XSLX("xlsx"),
		CSV("csv");
		
		String fileExtension;
		
		FileType(String fileExtension){
			this.fileExtension = fileExtension;
		}
		
		private static FileType match(String fileExtension) {
			for(FileType f : FileType.values()) {
				if(f.fileExtension.equalsIgnoreCase(fileExtension))return f; 
			}
			return null;
		}
		
	}
	
}
