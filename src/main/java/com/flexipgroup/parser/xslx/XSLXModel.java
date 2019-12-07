package com.flexipgroup.parser.xslx;

import com.flexipgroup.parser.doctype.header.ACH_XLS_Header;
import com.flexipgroup.parser.doctype.header.NAPS_XLS_Header;
import com.flexipgroup.parser.doctype.header.NEFT_XLS_Header;
import com.flexipgroup.parser.doctype.header.SFU_XLS_Header;

import lombok.Data;

@Data
public class XSLXModel {
	
	private SFU_XLS_Header sfu_file;
	private ACH_XLS_Header mdmc_file;
	private NAPS_XLS_Header naps_file;
	private NEFT_XLS_Header neft_file;
	
	private XSLXModel() {}
	
	public XSLXModel(SFU_XLS_Header sfu_file) {
		this.sfu_file = sfu_file;
	}
	
	public XSLXModel(ACH_XLS_Header mdmc_file) {
		this.mdmc_file = mdmc_file;
	}
	
	public XSLXModel(NAPS_XLS_Header naps_file) {
		this.naps_file = naps_file;
	}
	
	public XSLXModel(NEFT_XLS_Header neft_file) {
		this.neft_file = neft_file;
	}
	
}
