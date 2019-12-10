package com.flexipgroup.parser.doctype.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ACH_Model {
	
	private String RECORD_NUM;
	private String HOST_BANK_CODE;
	private String HOST_BRANCH_CODE;
	private String BENEFICIARY_ACCOUNT_NUMBER;
	private String BENEFICIARY_NAME;
	private String TXN_CURRENCY;
	private String TXN_AMOUNT;
	private String RIB_CODE;
	private String NARRATION;

	
	public ACH_Model (String RECORD_NUM,String HOST_BANK_CODE,String HOST_BRANCH_CODE,
			String BENEFICIARY_ACCOUNT_NUMBER,String BENEFICIARY_NAME,String TXN_CURRENCY,
			String TXN_AMOUNT,String RIB_CODE,String NARRATION)
	{
		this.RECORD_NUM = RECORD_NUM;
		this.HOST_BANK_CODE = HOST_BANK_CODE;
		this.HOST_BRANCH_CODE = HOST_BRANCH_CODE;
		this.BENEFICIARY_ACCOUNT_NUMBER = BENEFICIARY_ACCOUNT_NUMBER;
		this.BENEFICIARY_NAME = BENEFICIARY_NAME;
		this.TXN_CURRENCY = TXN_CURRENCY;
		this.TXN_AMOUNT = TXN_AMOUNT;
		this.RIB_CODE = RIB_CODE;
		this.NARRATION = NARRATION;
	}
	
}
