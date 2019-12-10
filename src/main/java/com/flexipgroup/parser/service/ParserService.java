package com.flexipgroup.parser.service;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.flexipgroup.parser.fileformat.FileFormat;
import com.flexipgroup.parser.xmlreader.XMLReader;
import com.flexipgroup.parser.xmlreader.XMLReaderModel;

public class ParserService {
	
	private File FILE;
	
	public ParserService(File file) {
		this.FILE = file;
	}
	
	public void run() {
		if(!FileFormat.isFileType(FILE)) {
			//Log();
			//move to error folder
			//FileUtils.move(FILE);
		} else {
			
		}
	}
	
	public static void main (String [] args) {
		
		String xmlFilePath;
		List<XMLReaderModel> list;
		Set<String>set = new HashSet<String>();
		
		xmlFilePath = System.getProperty("user.home")+File.separator+"SFTPFOLDER/sfu.xml";
		list = XMLReader.xmlReading(xmlFilePath);
		
		for(XMLReaderModel l: list) {
			set.add(l.getNode());
		}
		
		set.forEach(s->{
			System.out.println(s);
		});
		
	}

}
