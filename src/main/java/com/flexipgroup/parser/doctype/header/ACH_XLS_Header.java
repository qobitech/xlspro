package com.flexipgroup.parser.doctype.header;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class ACH_XLS_Header {
	
	private static final String RECORDNUM = "RECORDNUM";
	private static final String HOSTBANKCODE  = "HOSTBANKCODE";
	private static final String HOSTBRANCHCODE = "HOSTBRANCHCODE";
	private static final String BENEFICIARYACCOUNTNUM = "BENEFICIARYACCOUNTNUM";
	private static final String BENEFICIARYNAME = "BENEFICIARYNAME";
	private static final String TXNCURRENCY ="TXNCURRENCY";
	private static final String TXNAMOUNT="TXNAMOUNT";
	private static final String RIBCODE = "RIBCODE";
	private static final String NARRATION="NARRATION";
	
	private ACH_XLS_Header() {}
	
	public static List<String> getACH_Header = new ArrayList<String>(Arrays.asList(
			RECORDNUM,
			HOSTBANKCODE,
			HOSTBRANCHCODE,
			BENEFICIARYACCOUNTNUM,
			BENEFICIARYNAME,
			TXNCURRENCY,
			TXNAMOUNT,
			RIBCODE,
			NARRATION
	));
	

	
}
