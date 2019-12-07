package com.flexipgroup.parser.xslx;

import com.flexipgroup.parser.doctype.body.NAPS_XLS_Body;
import com.flexipgroup.parser.xls.Excel;

public interface XLSFormatRepo {
	
	public Excel get_SFU_File();
	
	//public Excel get_MDMC_File(MDMC_XLS_Body file);
	
	public Excel get_NAPS_File(NAPS_XLS_Body file);
	
	//public Excel get_NEFT_File(NEFT_XLS_Body file);
	
}
