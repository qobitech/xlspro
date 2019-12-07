package com.flexipgroup.parser.doctype.body;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flexipgroup.parser.doctype.header.SFU_XLS_Header;
import com.flexipgroup.parser.xmlreader.XMLReader;
import com.flexipgroup.parser.xmlreader.XMLReaderModel;

public class SFU_XLS_Body_Test {
	
	/**
	 * Test to make sure node / node values representing the body are arranged according to SFU headers
	 */

	String xmlFilePath,xmlFilePath2;
	List<XMLReaderModel> xmlData,xmlData2;
	static List<String> sfuHeaderData;
	
	@Before
	public void init () {
		
		xmlFilePath = System.getProperty("user.home")+File.separator+"Downloads/ds.xml";
		xmlFilePath2 = System.getProperty("user.home")+File.separator+"Downloads/sfu.xml";	
		xmlData = XMLReader.xmlReading(xmlFilePath);
		xmlData2 = XMLReader.xmlReading(xmlFilePath2);
		sfuHeaderData = SFU_XLS_Header.getSFU_Header;
	}
	
	@Test
	public void sfu_body_xml_test() {
		for(ArrayList<String> s : SFU_XLS_Body.mSFUBodyFormat(xmlData2)) {
			for(String d : s) {
				Assert.assertFalse(d.equals(""));
				Assert.assertFalse(d.equals(null));
			}
		}
	}


}
