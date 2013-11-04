package com.onb.employeeRegistration.util;

public class PatternUtility {
	
	private PatternUtility(){
	}
	
	public static final String NAME_PATTERN = "[a-zA-Z ]*";
	public static final String USERNAME_PATTERN ="[a-zA-Z0-9]*";
	public static final String PASSWORD_PATTERN = "|[a-zA-Z]*[0-9\\+\\*][a-zA-Z0-9\\+\\*]*";
	public static final String ROLE_PATTERN = "[a-zA-Z0-9_]*";
	public static final String ACCESS_PATTERN = "|[a-zA-Z0-9_]*";
	public static final String ADDRESS_PATTERN = "|[a-zA-Z0-9-\\./+':()? ]*";
	public static final String EMAIL_ADDRESS_PATTERN = "|[\\w]+(\\.[\\w]+)*@[\\w]+(\\.[\\w]+)*(\\.[\\w]{2,})";
	public static final String PHONE_NUMBER_PATTERN = "|((\\+)?[1-9]{1,4})?([-\\s\\.\\/])?((\\(\\d{1,4}\\))|\\d{1,4})(([-\\s\\.\\/])?[0-9]{1,6}){2,6}(\\s?(ext|x)\\s?[0-9]{1,6})?";
	public static final String BRANCH_PATTERN = "|[a-zA-Z0-9 ]*";
	public static final String DEPARTMENT_NAME_PATTER = "|[a-zA-Z0-9 ]*";
}
