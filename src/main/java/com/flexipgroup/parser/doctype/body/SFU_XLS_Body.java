package com.flexipgroup.parser.doctype.body;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.flexipgroup.parser.doctype.header.SFU_XLS_Header;
import com.flexipgroup.parser.xmlreader.XMLReaderModel;
import com.google.common.base.Objects;

public class SFU_XLS_Body {
	/**
	 * To identify node values from xml document
	 * to arrange node values in rows according to SFU xls document header 
	 */
	
	public static List<String> getSFU_Body = new ArrayList<String>();
	
	public SFU_XLS_Body() {}

	public static ArrayList<ArrayList<String>> mSFUBodyFormat (List<XMLReaderModel>l){
		return SFUBodyFormat (l);
	}
	
	
	/**
	 * compare node from xml document with SFU document headers
	 * to add node values to array  
	 * @param l
	 * @return
	 */
	
	private static ArrayList<ArrayList<String>> SFUBodyFormat (List<XMLReaderModel>l)
	{
		ArrayList<ArrayList<String>>format = new ArrayList<ArrayList<String>>();
		String [] array = new String[SFU_XLS_Header.getSFU_Header.size()];
		int count = 0;int check = 0;int sda = 0;
		while(check < (l.size()/SFU_XLS_Header.getSFU_Header.size())*SFU_XLS_Header.getSFU_Header.size()) {
			check = count;
			for(int a=0;a < SFU_XLS_Header.getSFU_Header.size();a++) 
			{
				for(int i=check;i<l.size();i++) 
				{	
					if( SFU_XLS_Header.getSFU_Header.get(a).equalsIgnoreCase(l.get(i).getNode()) )
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
			array = new String[SFU_XLS_Header.getSFU_Header.size()];		
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
