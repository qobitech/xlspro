package com.flexipgroup.parser.doctype.body;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flexipgroup.parser.doctype.header.ACH_XLS_Header;
import com.flexipgroup.parser.xmlreader.XMLReader;
import com.flexipgroup.parser.xmlreader.XMLReaderModel;

public class ACH_XLS_Body_Test {
	
	/**
	 * Test to make sure node / node values representing the body are arranged according to ACH headers
	 */

	String xmlFilePath,xmlFilePath2;
	List<XMLReaderModel> xmlData,xmlData2;
	static List<String> achHeaderData;
	
	@Before
	public void init () {
		
		xmlFilePath = System.getProperty("user.home")+File.separator+"Downloads/ds.xml";
		xmlFilePath2 = System.getProperty("user.home")+File.separator+"Downloads/sfu.xml";	
		xmlData = XMLReader.xmlReading(xmlFilePath);
		xmlData2 = XMLReader.xmlReading(xmlFilePath2);
		achHeaderData = ACH_XLS_Header.getACH_Header;
	}
	
	@Test
	public void ach_body_xml_test() {
		for(ArrayList<String> s : ACH_XLS_Body.mACHBodyFormat(xmlData2)) {
			for(String d : s) {
				Assert.assertFalse(d.equals(""));
				Assert.assertFalse(d.equals(null));
			}
		}
	}

}
