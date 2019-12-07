package com.flexipgroup.parser.doctype;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flexipgroup.parser.doctype.header.NAPS_XLS_Header;
import com.flexipgroup.parser.xmlreader.XMLReader;
import com.flexipgroup.parser.xmlreader.XMLReaderModel;

public class NAPS_DOC_TYPE_Test {
	
	/**
	 * Test to match data gotten from (xml,txt,csv) files with NAPS header data 
	 */
	
	String xmlFilePath,xmlFilePath2;
	List<XMLReaderModel> xmlData,xmlData2;
	static List<String> napsHeaderData;
	
	@Before
	public void init () {
		
		xmlFilePath = System.getProperty("user.home")+File.separator+"Downloads/ds.xml";
		xmlFilePath2 = System.getProperty("user.home")+File.separator+"Downloads/sfu.xml";	
		xmlData = XMLReader.xmlReading(xmlFilePath);
		xmlData2 = XMLReader.xmlReading(xmlFilePath2);
		napsHeaderData = NAPS_XLS_Header.getNAPS_Header;
	}
	
	
	/**
	 * test to match data gotten from xml file (node value) with NAPS header data
	 */
	@Test
	public void naps_doc_type_xml_test () {
		Assert.assertEquals(napsHeaderData.size(), NAPS_DOC_TYPE.match(xmlData));
	}
	
	
	/**
	 * test to match data gotten from xml file (node) with NAPS header data
	 */
	@Test
	public void naps_doc_type_xml_test2 () {
		Assert.assertEquals(napsHeaderData.size(), NAPS_DOC_TYPE.match2(xmlData2));
	}
	
	
	/**
	 * test to match data gotten from txt file with NAPS header data
	 */
	public void naps_doc_type_txt_test () {
		
	}
	
	
	/**
	 * test to match data gotten from csv file with NAPS header data
	 */
	public void naps_doc_type_csv_test () {
		
	}

}
