package com.daling.util;

final public class HttpConstant {

	/**
	 * HTTP header definitions
	 */
	public static final String TRANSFER_ENCODING = "Transfer-Encoding";
	public static final String CONTENT_LEN = "Content-Length";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String CONTENT_ENCODING = "Content-Encoding";
	public static final String EXPECT_DIRECTIVE = "Expect";
	public static final String CONN_DIRECTIVE = "Connection";
	public static final String TARGET_HOST = "Host";
	public static final String USER_AGENT = "User-Agent";
	public static final String DATE_HEADER = "Date";
	public static final String SERVER_HEADER = "Server";

	public static final String ACCEPT = "Accept";
	public static final String ACCEPT_ENCODING = "Accept-Encoding";
	public static final String ACCEPT_LANGUAGE = "Accept-Language";
	public static final String COOKIE = "Cookie";

	public static final String ACCEPT_DEF_VAL = "text/html, application/xhtml+xml, */*";
	public static final String ACCEPT_ENCODING_DEF_VAL = "gzip, deflate";
	public static final String ACCEPT_LANGUAGE_DEF_VAL = "zh-CN";

	public static final String CONTENT_TYPE_WWW_VAL = "application/x-www-form-urlencoded";
	public static final String CONTENT_TYPE_JSON_VAL = "application/json";
	public static final String CONTENT_TYPE_XML_VAL = "text/xml";
	public static final String CONTENT_TYPE_TEXT_VAL = "text/plain";
	public static final String CONTENT_TYPE_MULTIPART_VAL = "multipart/form-data";
	public static final String CONTENT_TYPE_DEF_VAL = CONTENT_TYPE_WWW_VAL;

	public static final String USER_AGENT_Chrome41 = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36";
	public static final String USER_AGENT_IE11 = "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko";
	public static final String USER_AGENT_FireFox38 = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0";

	/**
	 * HTTP connection control
	 */
	public static final String CONN_CLOSE = "Close";
	public static final String CONN_KEEP_ALIVE = "Keep-Alive";

	/**
	 * Transfer encoding definitions
	 */
	public static final String CHUNK_CODING = "chunked";
	public static final String IDENTITY_CODING = "identity";

} 
