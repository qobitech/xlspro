package com.flexipgroup.parser.doctype;

import java.util.List;

import com.flexipgroup.parser.doctype.header.SFU_XLS_Header;
import com.flexipgroup.parser.xmlreader.XMLReaderModel;

public class SFU_DOC_TYPE {
	
	/**
	 * To verify if file is SFU doc type
	 */
	
		private static int track = 0;
		private static int track2 = 0;
		
		/**
		 * compare node value with sfu header
		 * @param l
		 * @return
		 */
		
		private static int primatch (List <XMLReaderModel> l) {
			for(int a = 0; a < SFU_XLS_Header.getSFU_Header.size(); a++) { 
				for(int i = 0; i < l.size(); i++) 
				{
					if(SFU_XLS_Header.getSFU_Header.get(a).equalsIgnoreCase(l.get(i).getNodeValue()))
					{	
						System.out.println(SFU_XLS_Header.getSFU_Header.get(a)+"\t"+l.get(i).getNodeValue());
						track++;
						i = l.size();
					}
				}
			}
			return track;
		} 
		
	/**
	 * compare node with sfu header
	 * @param l
	 * @return
	 */
		private static int primatch2 (List <XMLReaderModel> l) {
			for(int a = 0; a < SFU_XLS_Header.getSFU_Header.size(); a++) { 
				for(int i = 0; i < l.size(); i++) 
				{
					if(SFU_XLS_Header.getSFU_Header.get(a).equalsIgnoreCase(l.get(i).getNode()))
					{	
						System.out.println(SFU_XLS_Header.getSFU_Header.get(a)+"\t"+l.get(i).getNode());
						track2++;
						i = l.size();
					}
				}
			}
			return track2;
		} 
		
		
		public static int match (List <XMLReaderModel> l) {
			return primatch (l);
		}
		
		public static int match2 (List <XMLReaderModel> l) {
			return primatch2 (l);
		}
		
		private SFU_DOC_TYPE() {}

}
