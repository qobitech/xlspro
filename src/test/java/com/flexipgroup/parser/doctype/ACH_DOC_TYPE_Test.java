package com.flexipgroup.parser.doctype;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flexipgroup.parser.doctype.header.ACH_XLS_Header;
import com.flexipgroup.parser.xmlreader.XMLReader;
import com.flexipgroup.parser.xmlreader.XMLReaderModel;



public class ACH_DOC_TYPE_Test {
	
	/**
	 * Test to match data gotten from (xml,txt,csv) files with ACH header data 
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
	
	
	/**
	 * test to match data gotten from xml file (node value) with ACH header data
	 */
	@Test
	public void ach_doc_type_xml_test () {
		Assert.assertEquals(achHeaderData.size(), ACH_DOC_TYPE.match(xmlData));
	}
	
	
	/**
	 * test to match data gotten from xml file (node) with ACH header data
	 */
	@Test
	public void ach_doc_type_xml_test2 () {
		Assert.assertEquals(achHeaderData.size(), ACH_DOC_TYPE.match2(xmlData2));
	}
	
	
	/**
	 * test to match data gotten from txt file with ACH header data
	 */
	public void ach_doc_type_txt_test () {
		
	}
	
	
	/**
	 * test to match data gotten from csv file with ACH header data
	 */
	public void ach_doc_type_csv_test () {
		
	}
}
