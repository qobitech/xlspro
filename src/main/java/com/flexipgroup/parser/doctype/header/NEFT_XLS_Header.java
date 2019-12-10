package com.flexipgroup.parser.doctype.header;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class NEFT_XLS_Header {

	private static final String RECORD_NUMBER = "RECORD_NUMBER";
	private static final String BENEFICIARY_ACCOUNT = "BENEFICIARY_ACCOUNT";
	private static final String BENEFICIARY_BANKCODE = "BENEFICIARY_BANKCODE";
	private static final String BENEFICIARY_NAME = "BENEFICIARY_NAME";
	private static final String TRANSACTION_AMOUNT = "TRANSACTION_AMOUNT";
	private static final String NARRATION = "NARRATION";

	private NEFT_XLS_Header() {}
	
	public static List<String> getNEFT_Header = new ArrayList<String>(Arrays.asList(
			RECORD_NUMBER,
			BENEFICIARY_ACCOUNT,
			BENEFICIARY_BANKCODE,
			BENEFICIARY_NAME,
			TRANSACTION_AMOUNT,
			NARRATION
	));
}
