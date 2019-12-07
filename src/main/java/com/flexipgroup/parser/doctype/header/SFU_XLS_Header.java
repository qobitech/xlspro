package com.flexipgroup.parser.doctype.header;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SFU_XLS_Header {
	
	private static final String RECORD_TYPE_ID = "RECORD_TYPE_ID";
	private static final String BANK_CODE= "BANK_CODE";
	private static final String ACCOUNT_ID= "ACCOUNT_ID";
	private static final String BENEFICIARY_NAME= "BENEFICIARY_NAME";
	private static final String CURRENCY= "RECORD_TYPE_ID";
	private static final String AMOUNT= "AMOUNT";
	private static final String NARRATION= "NARRATION";
	
	public static List<String> getSFU_Header = new ArrayList<String>(Arrays.asList(
			RECORD_TYPE_ID,BANK_CODE,ACCOUNT_ID,BENEFICIARY_NAME,CURRENCY,AMOUNT,NARRATION
	));
	
	private SFU_XLS_Header (){}
	
}
