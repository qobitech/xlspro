package com.flexipgroup.parser.fileformat;

public class FileFormat {
	/**
	 * To verify file extension of client files
	 * 
	 * @param fileExtension
	 * @return
	 */
	
	private FileFormat() {}
	
	public static boolean isFileType (String fileExtension) {
		if(FileType.match(fileExtension)!=null)return true;
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
