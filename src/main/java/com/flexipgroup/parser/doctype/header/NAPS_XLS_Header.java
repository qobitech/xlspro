package com.flexipgroup.parser.doctype.header;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class NAPS_XLS_Header {
	
	private static final String RECORD_NUMBER="record_type_id";
	private static final String BENEFICIARY_ACCOUNT="bank_code";
	private static final String BENEFICIARY_BANKCODE="account_id";
	private static final String BENEFICIARY_NAME="BENEFICIARY_NAME";
	private static final String TRANSACTION_AMOUNT="currency";
	private static final String AMOUNT="amount";
	private static final String NARRATION="narration";

	private NAPS_XLS_Header () {}
	
	public static List<String> getNAPS_Header = new ArrayList<String>(Arrays.asList(
			RECORD_NUMBER,BENEFICIARY_ACCOUNT,BENEFICIARY_BANKCODE,BENEFICIARY_NAME,TRANSACTION_AMOUNT,AMOUNT,NARRATION
	));
}
