package com.flexipgroup.parser.xls;

import java.util.ArrayList;
import java.util.List;

public class ExcelDetails {
	
	private List<String> header;
	private int columnNumber;
	private int rowNumber;
	private final int CELL_SIZE = 600;
	
	private static List<String> formatBody(ArrayList<ArrayList<String>> body) {
		
		List<String> bo = new ArrayList<String>();
		
		for(int i = 0;i < body.size(); i++) {
			for(int j = 0; j < body.get(i).size(); j++) {
				bo.add(body.get(i).get(j));
			}
		}
		return bo;
		
	}
	
	public static List<String> getbody(ArrayList<ArrayList<String>> body) {
		return formatBody(body);
	}
	
}
