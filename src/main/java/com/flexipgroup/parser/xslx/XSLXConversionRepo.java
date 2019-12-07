package com.flexipgroup.parser.xslx;

public interface XSLXConversionRepo {

	public XSLXModel fromXML (XSLXModel file);
	
	public XSLXModel fromJSON (XSLXModel file);
	
	public XSLXModel fromCSV (XSLXModel file);
	
	
}
