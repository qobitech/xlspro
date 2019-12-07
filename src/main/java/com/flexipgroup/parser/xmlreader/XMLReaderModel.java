package com.flexipgroup.parser.xmlreader;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

/**
 * To define the attributes to be found in every xml file that has been read (node, parent node, node value)
 * @author user
 *
 */


@Data
public class XMLReaderModel{
	private String parentNode;
	private String node;
	private String nodeValue;
	
	public XMLReaderModel(String parent, String child,String childValue) {
		this.parentNode = parent; this.node = child;this.nodeValue=childValue;
	}
	@Autowired
	public XMLReaderModel(String parent, String child) {
		this.parentNode = parent; this.node = child;
	}
	@SuppressWarnings("unused")
	private XMLReaderModel() {}
}