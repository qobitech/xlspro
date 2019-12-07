package com.flexipgroup.parser.fileformat;

import org.junit.Assert;
import org.junit.Test;

public class FileFormatTest {
	
	
	/**
	 * Test to make sure it only accepts only pre-defined file extensions (txt, xls, xlsx, csv, xml) 
	 */
	
	@Test
	public void fileFormatTest () {
		Assert.assertEquals(true,FileFormat.isFileType("txt"));
		Assert.assertEquals(true,FileFormat.isFileType("xls"));
		Assert.assertEquals(true,FileFormat.isFileType("xlsx"));
		Assert.assertEquals(true,FileFormat.isFileType("csv"));
		Assert.assertEquals(true,FileFormat.isFileType("xml"));
	}
	
	@Test
	public void fileFormatTest2 () {
		Assert.assertEquals(false,FileFormat.isFileType("tx"));
		Assert.assertEquals(false,FileFormat.isFileType("xlsw"));
		Assert.assertEquals(false,FileFormat.isFileType("sxlsx"));
		Assert.assertEquals(false,FileFormat.isFileType("cdsv"));
		Assert.assertEquals(false,FileFormat.isFileType("xsml"));
	}

}
