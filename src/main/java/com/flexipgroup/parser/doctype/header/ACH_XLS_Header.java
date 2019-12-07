package com.flexipgroup.parser.doctype.header;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class ACH_XLS_Header {
	
	private static final String RECORD_NUM = "record_type_id";
	private static final String HOST_BANK_CODE  = "BANK_CODE";
	private static final String HOST_BRANCH_CODE = "Account_id";
	private static final String BENEFICIARY_ACCOUNT_NUMBER = "BENEFICIARY_NAME";
	private static final String BENEFICIARY_NAME = "Currency";
	private static final String TXN_CURRENCY ="Amount";
	private static final String TXN_AMOUNT="Narration";
	private static final String RIB_CODE = "RIBCODE";
	private static final String NARRATION="NARRATION";
	
	private ACH_XLS_Header() {}
	
	public static List<String> getACH_Header = new ArrayList<String>(Arrays.asList(
			RECORD_NUM,HOST_BANK_CODE,HOST_BRANCH_CODE,BENEFICIARY_ACCOUNT_NUMBER,BENEFICIARY_NAME,TXN_CURRENCY,
			TXN_AMOUNT
	));
	

	
}
