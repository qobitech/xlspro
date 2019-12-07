package com.flexipgroup.parser.xmlreader;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XMLReaderTest {
	
	/**
	 * Test to make sure every node has a node value
	 */
	
	String xmlFilePath;
	List<XMLReaderModel> list;
	
	@Before
	public void init () {
		xmlFilePath = System.getProperty("user.home")+File.separator+"SFTPFOLDER/sfu.xml";
		list = XMLReader.xmlReading(xmlFilePath);
	}
	
	@Test
	public void xmlreaderNodeTest() {
		for (int i=0;i< list.size(); i++) {
			if(!list.get(i).getNodeValue().equals("") || !list.get(i).getNodeValue().equals(null))
				Assert.assertFalse(list.get(i).getNode().isEmpty());
		}
	}
	
	@Test
	public void xmlreaderNodeValueTest() {
		for (int i=0;i< list.size(); i++) {
			if(!list.get(i).getNodeValue().equals("") || !list.get(i).getNodeValue().equals(null))
				Assert.assertFalse(list.get(i).getNodeValue().isEmpty());
		}
	}
	
	@Test
	public void xmlreaderParentNodeTest() {
		for (int i=0;i< list.size(); i++) {
			if(!list.get(i).getNodeValue().equals("") || !list.get(i).getNodeValue().equals(null))
				Assert.assertFalse(list.get(i).getParentNode().isEmpty());
		}
	}

}
