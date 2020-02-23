package com.dalingjia.util;

import org.apache.commons.lang3.RandomStringUtils;

public class NumberFormatTest {

	public static void main(String[] args) {
		System.out.println(Double.valueOf(049.44));
		System.out.println(Double.valueOf(009.44));
		System.out.println(Double.valueOf(000.44));

		String validationCode = RandomStringUtils.randomNumeric(19);
		System.out.println(validationCode);
	}
}
