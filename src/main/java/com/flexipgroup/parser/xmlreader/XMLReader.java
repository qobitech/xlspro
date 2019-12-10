package com.flexipgroup.parser.xmlreader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLReader {
	 
	/**
	 * To read an xml file and extract nodes , parent nodes, nodes values
	 * To remove parent nodes, and nodes without values
	 * return only nodes with node values
	 * @param filePath
	 * @return
	 */
	
	
	
	
	private static List<XMLReaderModel> xmlRead (String filePath)
	{
		List<XMLReaderModel>l = new ArrayList<XMLReaderModel>();
		try{  
			File file = new File(filePath);  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			db.setErrorHandler(new MyErrorHandler());
			Document doc = db.parse(file); 			
			doc.getDocumentElement().normalize();  
			//System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
			NodeList list = doc.getDocumentElement().getChildNodes();
			
			getParentChildNode(l,list);
			remedy (l); 
			deleteNodeRow (l);	
		}catch (Exception e)   
		{  
			e.printStackTrace();  
		}
		return l;
	}
	
	public static List<XMLReaderModel> xmlReading (String filePath){
		return xmlRead (filePath);
	}
	
	private static XMLReaderModel getParentChildNode(List<XMLReaderModel>l,NodeList list){
		NodeList liste = list;
		if(liste.getLength() >= 1) {		
			for(int a = 0;a < liste.getLength(); a++) {				
				if(liste.item(a).getNodeName().indexOf("#")==-1) {							
					l.add(new XMLReaderModel(liste.item(a).getParentNode().getNodeName(),liste.item(a).getNodeName(),liste.item(a).getTextContent()));			
					if(liste.item(a).hasChildNodes())getParentChildNode(l,liste.item(a).getChildNodes());	
				}
			}
		}
		return null;
	}

	private static void remedy (List<XMLReaderModel> lf){
		for(int i = 0; i < lf.size(); i++){
			for(int j = 0; j < lf.size(); j++){	
				if(lf.get(i).getNode().equals(lf.get(j).getParentNode())){
					lf.get(i).setNodeValue("");
				}			
			}
		}
	}
	
	private static void deleteNodeRow (List<XMLReaderModel> lf) {
		lf.removeIf(p->(Objects.equals(p.getNodeValue(),"") || Objects.equals(p.getNodeValue(),null)));
	}
}
