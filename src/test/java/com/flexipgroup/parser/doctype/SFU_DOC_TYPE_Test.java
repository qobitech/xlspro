package com.flexipgroup.parser.doctype;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flexipgroup.parser.doctype.header.SFU_XLS_Header;
import com.flexipgroup.parser.xmlreader.XMLReader;
import com.flexipgroup.parser.xmlreader.XMLReaderModel;

public class SFU_DOC_TYPE_Test {
	
	/**
	 * Test to match data gotten from (xml,txt,csv) files with SFU header data 
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
	
	
	/**
	 * test to match data gotten from xml file (node value) with SFU header data
	 */
	@Test
	public void sfu_doc_type_xml_test () {
		Assert.assertEquals(sfuHeaderData.size(), SFU_DOC_TYPE.match(xmlData));
	}
	
	
	/**
	 * test to match data gotten from xml file (node) with SFU header data
	 */
	@Test
	public void sfu_doc_type_xml_test2 () {
		Assert.assertEquals(sfuHeaderData.size(), SFU_DOC_TYPE.match2(xmlData2));
	}
	
	
	/**
	 * test to match data gotten from txt file with SFU header data
	 */
	public void sfu_doc_type_txt_test () {
		
	}
	
	
	/**
	 * test to match data gotten from csv file with SFU header data
	 */
	public void sfu_doc_type_csv_test () {
		
	}
}
