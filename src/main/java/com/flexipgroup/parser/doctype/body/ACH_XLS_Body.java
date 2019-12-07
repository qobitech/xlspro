package com.flexipgroup.parser.doctype.body;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.flexipgroup.parser.doctype.header.ACH_XLS_Header;
import com.flexipgroup.parser.xmlreader.XMLReaderModel;
import com.google.common.base.Objects;

public class ACH_XLS_Body {
	
	/**
	 * To identify node values from xml document
	 * to arrange node values in rows according to ACH xls document header 
	 */
	
	public static List<String> getNAPS_Body = new ArrayList<String>();
	
	public ACH_XLS_Body() {}

	public static ArrayList<ArrayList<String>> mACHBodyFormat (List<XMLReaderModel>l){
		return ACHBodyFormat (l);
	}
	
	
	/**
	 * compare node from xml document with ACH document headers
	 * to add node values to array  
	 * @param l
	 * @return
	 */
	
	private static ArrayList<ArrayList<String>> ACHBodyFormat (List<XMLReaderModel>l)
	{
		ArrayList<ArrayList<String>>format = new ArrayList<ArrayList<String>>();
		String [] array = new String[ACH_XLS_Header.getACH_Header.size()];
		int count = 0;int check = 0;int sda = 0;
		while(check < (l.size()/ACH_XLS_Header.getACH_Header.size())*ACH_XLS_Header.getACH_Header.size()) {
			check = count;
			for(int a=0;a<ACH_XLS_Header.getACH_Header.size();a++) 
			{
				for(int i=check;i<l.size();i++) 
				{	
					if(ACH_XLS_Header.getACH_Header.get(a).equalsIgnoreCase(l.get(i).getNode()))
					{
						addtoList(array,l.get(i).getNodeValue());
						count++;
						i=l.size();
					}		
				}				
			}
			sda++;
			if(!Objects.equal(null, array[0]))
				format.add(sda-1,new ArrayList<>(Arrays.asList(array)));
			array = new String[ACH_XLS_Header.getACH_Header.size()];		
		}
		format.forEach(e->{System.out.println(e);});
		return format;
	}
	  
	/**
	 * To enter node values into array
	 * to check if node value exists in array,
	 * to make sure node value is not duplicated and entered into array
	 * @param array
	 * @param value
	 * @return
	 */
	
	private static String [] addtoList(String [] array,String value) {
		String copyvalue = null;
		for(int a=0;a< array.length; a++)
		{
			for(int i = 0; i < array.length; i++)
			{
				if(!Objects.equal(array[i],"") || !Objects.equal(array[i],null)) {
					if(!Objects.equal(array[i],value)) {
						copyvalue = value;
						i=array.length;
					}else {
						copyvalue = "";
					}
				}
			}
			if(!Objects.equal(null,copyvalue) || !Objects.equal("",copyvalue)) {
				if(Objects.equal(array[a],"") || Objects.equal(array[a],null)) {
					array[a]=copyvalue;
					break;
				}
			}
		}
		return array;
	}

}
