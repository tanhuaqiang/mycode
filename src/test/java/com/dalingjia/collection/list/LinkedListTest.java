package com.dalingjia.collection.list;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> list = Lists.newArrayList("tanhq", "xige", "fangjinglin");
		System.out.println(list);
		DecimalFormat fmt=new DecimalFormat("0.0000");
		BigDecimal i= new BigDecimal(78.3500);
//		BigDecimal g =(i.multiply(new BigDecimal(100)).intValue())/100d;
		int t = i.multiply(new BigDecimal(100)).intValue();
		System.out.println(t);
		System.out.println(fmt.format(i));
		System.out.println(t/100d);

		BigDecimal prodAmount = BigDecimal.ZERO;
		prodAmount = prodAmount.add(new BigDecimal(388.98).multiply(new BigDecimal(10)).setScale(2, BigDecimal.ROUND_HALF_UP));
		System.out.println(prodAmount);
		//保留小数点后两位，4舍5入
		System.out.println(new BigDecimal(388.985).setScale(2, BigDecimal.ROUND_HALF_UP));
		System.out.println(new BigDecimal(388.984).setScale(2, BigDecimal.ROUND_HALF_UP));
	}
}
