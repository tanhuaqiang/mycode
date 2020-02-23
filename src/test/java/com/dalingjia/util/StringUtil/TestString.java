package com.dalingjia.util.StringUtil;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class TestString {

	public static void main(String[] args) {
		String url = "http://localhost:81/yjyyjydt.jhtml";
		System.out.println(getRefererWebSite(url));

		StringBuffer stringBuffer = new StringBuffer();
		String str = null;
		stringBuffer.append(str).append("tanhq");
		System.out.println(stringBuffer.toString());

		System.out.println(join());

		split("abc");

		System.out.println(StringUtils.join("abc","efg",".do"));

		System.out.println("joinCollection : " + joinCollection());

	}

	private static String getRefererWebSite(String referer) {
		if (StringUtils.isBlank(referer)) {
			return "";
		}
		int start = 0, i = 0, count = 3;
		while (i < count && start != -1) {
			start = referer.indexOf('/', start + 1);
			i++;
		}
		if (start <= 0) {
			throw new IllegalStateException("referer website uri not like 'http://.../...' pattern: " + referer);
		}
		return referer.substring(0, start);
	}

	private static String join() {
		return StringUtils.join(new Object[] { "tanhq", 12, 'a' }, "|");
	}

	private static String joinCollection(){
		Set<String> set = new HashSet<String>();
		set.add("tanhq");
//		set.add("xige");
//		set.add("jingling");
		return StringUtils.join(set, ",");
	}


	private static void split(String str) {
		String[] strings = str.split(",");
		for (String string : strings) {
			System.out.println(string);
		}
	}



}
