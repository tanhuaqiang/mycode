package com.daling.util;

import com.google.common.collect.Lists;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.MalformedURLException;
import java.net.ProxySelector;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

/**
 * @author tanhq
 */
public class HttpUtil {
	private final static Logger log = LoggerFactory.getLogger("dal_http");
	public final static int CONN_TIMEOUT_MS = 10000;//和服务器建立连接的timeout, 建立连接在规定的时间内ConnectionTimeOut完成
	public final static int CONN_REQ_TIMEOUT_MS = 10000;//从连接池获取连接的timeout
	public final static int SOCKET_TIMEOUT_MS = 120000;//从服务器读取数据的timeout,数据在规定的时间内SocketTimeOut传输完毕
	public final static int KEEP_ALIVE_MS = 30000;
	public final static int TOTAL_CONN_MAX = 65535;
	public final static int ROUTE_CONN_MAX = 15000;
	public final static int RETRY_COUNT_MAX = 5;
	public final static String DEFAULT_ENCODING = "UTF-8";
//	public final static String PROXY_HOST ;
//	public final static int PORXY_PORT;
//	static {
//		PropertiesConfiguration config = null;
//		try {
//			config = new PropertiesConfiguration();
//			config.setEncoding("UTF-8");
//			config.load("httpclient.properties");
//			config.setThrowExceptionOnMissing(false);
//		} catch (ConfigurationException exc) {
//			log.error("", exc);
//			config = new PropertiesConfiguration();
//		}
//		CONN_TIMEOUT_MS = NumberUtils.toInt(config.getString("conn_timeout_ms"), 10000);
//		CONN_REQ_TIMEOUT_MS = NumberUtils.toInt(config.getString("conn_req_timeout_ms"), 10000);
//		SOCKET_TIMEOUT_MS = NumberUtils.toInt(config.getString("socket_timeout_ms"), 10000);
//		KEEP_ALIVE_MS = NumberUtils.toInt(config.getString("keep_alive_ms"), 30000);
//		TOTAL_CONN_MAX = NumberUtils.toInt(config.getString("total_conn_max"), 65535);
//		ROUTE_CONN_MAX = NumberUtils.toInt(config.getString("route_conn_max"), 128);
//		RETRY_COUNT_MAX = NumberUtils.toInt(config.getString("retry_count_max"), 5);
//		DEFAULT_ENCODING = config.getString("default_encoding", "UTF-8");
//		PROXY_HOST = config.getString("proxy_host", "");
//		PORXY_PORT = NumberUtils.toInt(config.getString("proxy_port"), -1);
//
//	}

	public static int getCONN_TIMEOUT_MS() {
		return CONN_TIMEOUT_MS;
	}

	public static int getCONN_REQ_TIMEOUT_MS() {
		return CONN_REQ_TIMEOUT_MS;
	}

	public static int getSOCKET_TIMEOUT_MS() {
		return SOCKET_TIMEOUT_MS;
	}

	public static int getKEEP_ALIVE_MS() {
		return KEEP_ALIVE_MS;
	}

	public static int getTOTAL_CONN_MAX() {
		return TOTAL_CONN_MAX;
	}

	public static int getROUTE_CONN_MAX() {
		return ROUTE_CONN_MAX;
	}

	public static int getRETRY_COUNT_MAX() {
		return RETRY_COUNT_MAX;
	}

	public static String getDEFAULT_ENCODING() {
		return DEFAULT_ENCODING;
	}

	private CloseableHttpClient httpClient = null;
	private IdleConnectionMonitorThread connMonitor = null;

	private HttpUtil() {
		try {
			init();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	static public HttpUtil getInstance() {
		return HttpUtilsHolder.instance;
	}

	private static class HttpUtilsHolder {
		private static HttpUtil instance = new HttpUtil();
	}

	public void init() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
		// 设置代理
//		HttpRoutePlanner routePlanner;
//		if (StringUtils.isBlank(PROXY_HOST) || PORXY_PORT < 0) {
//			routePlanner = new SystemDefaultRoutePlanner(ProxySelector.getDefault());
//		} else {
//			routePlanner = new HttpRoutePlanner() {
//				@Override
//				public HttpRoute determineRoute(HttpHost target, HttpRequest request, HttpContext context) throws HttpException {
//					return new HttpRoute(target, null, new HttpHost(PROXY_HOST, PORXY_PORT), "https".equalsIgnoreCase(target.getSchemeName()));
//				}
//			};
//		}

		//
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(SOCKET_TIMEOUT_MS)
				.setConnectTimeout(CONN_TIMEOUT_MS)
				.setConnectionRequestTimeout(CONN_REQ_TIMEOUT_MS)
				.build();
		ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
		SSLContextBuilder sslContextBuilder = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
			@Override
			public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				return true; // TODO 目前是默认信任全部，需要后续改造, 可以指定的信任列表
			}
		});
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContextBuilder.build(), SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create().register("http", plainsf).register("https", sslsf)
				.build();
		PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(registry);
		connMgr.setMaxTotal(TOTAL_CONN_MAX);
		connMgr.setDefaultMaxPerRoute(ROUTE_CONN_MAX);
		//
		ConnectionKeepAliveStrategy connKeepAliveStrategy = new ConnectionKeepAliveStrategy() {
			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				return KEEP_ALIVE_MS; // keep alive for 30 seconds
			}
		};
		//
		HttpRequestRetryHandler thisRetryHandler = new HttpRequestRetryHandler() {
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				if (executionCount >= RETRY_COUNT_MAX // Do_not_retry_if_over_max_retry_count
						|| exception instanceof InterruptedIOException // Timeout 超时
						|| exception instanceof UnknownHostException // Unknownhost 目标服务器不可达  
						|| exception instanceof ConnectTimeoutException // Conn_Refused 连接被拒绝  
						|| exception instanceof SSLException // SSL_Handshake_Exception SSL握手异常  
						|| exception instanceof SSLHandshakeException // 不要重试SSL握手异常
				) {
					return false;
				}
				if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试  
	                 return true;  
	             } 
				HttpClientContext clientContext = HttpClientContext.adapt(context);
				HttpRequest request = clientContext.getRequest();
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
				if (idempotent) {
					return true;// Retry if the request is considered idempotent
				} else {
					return false;
				}
			}
		};
		httpClient = HttpClients.custom() //
				.setDefaultRequestConfig(requestConfig) //
				.setConnectionManager(connMgr) //
				.setRetryHandler(thisRetryHandler) //
				.setKeepAliveStrategy(connKeepAliveStrategy) //
//				.setRoutePlanner(routePlanner) //
				// .setDefaultCookieStore(cookieStore) //
				.build();

		connMonitor = new IdleConnectionMonitorThread(connMgr);
		connMonitor.start();
	}

	public void shutdown() throws IOException {
		if (connMonitor != null) {
			connMonitor.shutdown();
		}
		if (httpClient != null) {
			httpClient.close();
		}
	}

	/**
	 * HttpClient原始的excute方法, 用于高度定制化的http请求
	 */
	public CloseableHttpResponse execute(final HttpUriRequest request) throws ClientProtocolException, IOException {
		return httpClient.execute(request);
	}

	/**
	 * HttpClient原始的excute方法, 用于高度定制化的http请求
	 */
	public <T> T execute(final HttpUriRequest request, final ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
		return httpClient.execute(request, responseHandler, null);
	}

	/**
	 * 发送http GET请求, 并返回HttpResult响应
	 * 
	 * @param urlstr
	 *            完整的请求url字符串
	 */
	public HttpResult get(String urlstr) throws ClientProtocolException, IOException {
		return get(urlstr, null, null, CONN_TIMEOUT_MS, SOCKET_TIMEOUT_MS, DEFAULT_ENCODING);
	}

	/**
	 * 发送http GET请求, 带cookie参数, 并返回HttpResult响应
	 */
	public HttpResult get(String urlstr, Map<String, String> cookieMap, Map<String, String> headerMap) throws ClientProtocolException, IOException {
		return get(urlstr, cookieMap, headerMap, CONN_TIMEOUT_MS, SOCKET_TIMEOUT_MS, DEFAULT_ENCODING);
	}

	/**
	 * 发送http GET请求, 带cookie, connTimeoutMs, socketTimeoutMs, encoding参数,
	 * 并返回HttpResult响应
	 */
	public HttpResult get(String urlstr, Map<String, String> cookieMap, Map<String, String> headerMap //
			, int connTimeoutMs, int socketTimeoutMs, String encoding) throws ClientProtocolException, IOException {

		Charset charSet = Charset.forName(encoding);

		RequestConfig localConfig = RequestConfig.custom() //
				.setCookieSpec(CookieSpecs.STANDARD) //
				.setConnectTimeout(connTimeoutMs)//
				.setSocketTimeout(socketTimeoutMs)//
				.setConnectionRequestTimeout(CONN_REQ_TIMEOUT_MS) //
				.build();

		HttpGet httpget = new HttpGet(urlstr);
		httpget.setConfig(localConfig);
		httpget.setHeaders(genHeaderArray(cookieMap, headerMap, ContentType.create(HttpConstant.CONTENT_TYPE_DEF_VAL, charSet)));
		log.debug("REQ_LINE={} ", httpget.getRequestLine());

		HttpResult httpResult = null;
		try (CloseableHttpResponse response = HttpUtil.getInstance().execute(httpget)) {
			httpResult = wrapResponsetoResult(response, charSet);
		}
		return httpResult;
	}

	/**
	 * 发送完整的HTTP POST请求, map不支持相同参数key的请求,带cookie, connTimeoutMs,
	 * socketTimeoutMs, encoding参数, 并返回HttpResult响应 相同key参数的post请参考 httpPost方法
	 */
	public HttpResult post(String urlStr, Map<String, String> params) throws ClientProtocolException, IOException {
		return post(urlStr, params, null, null, CONN_TIMEOUT_MS, SOCKET_TIMEOUT_MS, DEFAULT_ENCODING);
	}

	/**
	 * 发送完整的HTTP POST请求, map不支持相同参数key的请求,带cookie参数, 并返回HttpResult响应
	 */
	public HttpResult post(String urlstr, Map<String, String> params, Map<String, String> cookieMap, Map<String, String> headerMap) throws ClientProtocolException, IOException {
		return post(urlstr, params, cookieMap, headerMap,CONN_TIMEOUT_MS, SOCKET_TIMEOUT_MS, DEFAULT_ENCODING);
	}

	/**
	 * 发送完整的HTTP POST请求, map不支持相同参数key的请求,带cookie, connTimeoutMs,
	 * socketTimeoutMs, encoding参数, 并返回HttpResult响应 相同key参数的post请参考 httpPost方法
	 */
	public HttpResult post(String urlstr, Map<String, String> params, Map<String, String> cookieMap, Map<String, String> headerMap //
			, int connTimeoutMs, int socketTimeoutMs, String encoding) throws ClientProtocolException, IOException {

		List<NameValuePair> paramList = Lists.newArrayList();
		if (params != null) {
			for (Entry<String, String> entry : params.entrySet()) {
				paramList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		return postNVPair(urlstr, paramList, cookieMap, headerMap, connTimeoutMs, socketTimeoutMs, encoding);
	}

	/**
	 * 发送完整的HTTP POST请求, 支持多个相同key的参数传递, 并返回HttpResult响应
	 */
	public HttpResult postNVPair(String urlstr, List<NameValuePair> params) throws ClientProtocolException, IOException {
		return postNVPair(urlstr, params, null, null, CONN_TIMEOUT_MS, SOCKET_TIMEOUT_MS, DEFAULT_ENCODING);

	}

	/**
	 * 发送完整的HTTP POST请求, 支持多个相同key的参数传递,带cookie 参数, 并返回HttpResult响应
	 */
	public HttpResult postNVPair(String urlstr, List<NameValuePair> params, Map<String, String> cookieMap, Map<String, String> headerMap) throws ClientProtocolException, IOException {
		return postNVPair(urlstr, params, cookieMap, headerMap, CONN_TIMEOUT_MS, SOCKET_TIMEOUT_MS, DEFAULT_ENCODING);

	}

	/**
	 * 发送完整的HTTP POST请求, 支持多个相同key的参数传递,带cookie, connTimeoutMs, socketTimeoutMs,
	 * encoding参数, 并返回HttpResult响应
	 */
	public HttpResult postNVPair(String urlstr, List<NameValuePair> params, Map<String, String> cookieMap, Map<String, String> headerMap //
			, int connTimeoutMs, int socketTimeoutMs, String encoding) throws ClientProtocolException, IOException {
		Charset charSet = Charset.forName(encoding);
		ContentType contentType = ContentType.create(HttpConstant.CONTENT_TYPE_WWW_VAL, charSet);
		//genHeaderArray(cookieMap, contentType);
		HttpEntity reqEntity = EntityBuilder.create() //
				.setParameters(params) //
				//.setContentEncoding(encoding) //
				.setContentType(contentType) //
				// .gzipCompress()
				.build();

		return httpPost(urlstr, reqEntity, genHeaderArray(cookieMap, headerMap, contentType) //
				, connTimeoutMs, socketTimeoutMs, contentType);
	}

	/**
	 * 发送Raw格式的POST数据
	 */
	public HttpResult postRaw(String urlstr, String str, String contentTypeStr) throws ClientProtocolException, IOException {
		return postRaw(urlstr, str, contentTypeStr, null, null, CONN_TIMEOUT_MS, SOCKET_TIMEOUT_MS, DEFAULT_ENCODING);
	}

	public HttpResult postRaw(String urlstr, String str, String contentTypeStr, Map<String, String> cookieMap, Map<String, String> headerMap) throws ClientProtocolException, IOException {
		return postRaw(urlstr, str, contentTypeStr, cookieMap,headerMap, CONN_TIMEOUT_MS, SOCKET_TIMEOUT_MS, DEFAULT_ENCODING);
	}

	public HttpResult postRaw(String urlstr, String str, String contentTypeStr, Map<String, String> cookieMap, Map<String, String> headerMap //
			, int connTimeoutMs, int socketTimeoutMs, String encoding) throws ClientProtocolException, IOException {
		Charset charSet = Charset.forName(encoding);
		ContentType contentType = ContentType.create(contentTypeStr, charSet);
		HttpEntity reqEntity = EntityBuilder.create() //
				.setText(str) //
				//.setContentEncoding(encoding) //
				.setContentType(contentType) //
				// .gzipCompress()
				.build();

		return httpPost(urlstr, reqEntity, genHeaderArray(cookieMap,headerMap, contentType) //
				, connTimeoutMs, socketTimeoutMs, contentType);
	}

	/**
	 * 发送完整的HTTP POST请求, 支持多个相同key的参数传递,带cookie, connTimeoutMs, socketTimeoutMs,
	 * encoding参数, 并返回HttpResult响应
	 */
	public HttpResult httpPost(String urlstr, HttpEntity reqEntity, Header[] headers //
			, int connTimeoutMs, int socketTimeoutMs, ContentType contentType) throws ClientProtocolException, IOException {
		// HttpEntity respEntity = null;

		RequestConfig localConfig = RequestConfig.custom() //
				.setCookieSpec(CookieSpecs.STANDARD) //
				.setConnectTimeout(connTimeoutMs)//
				.setSocketTimeout(socketTimeoutMs)//
				.setConnectionRequestTimeout(CONN_REQ_TIMEOUT_MS) //
				.build();

		HttpPost httppost = new HttpPost(urlstr);
		httppost.setConfig(localConfig);
		httppost.setEntity(reqEntity);
		httppost.setHeaders(headers);
		log.debug("REQ_LINE={} ", httppost.getRequestLine());
		HttpResult httpResult = null;
		try (CloseableHttpResponse response = HttpUtil.getInstance().execute(httppost)) {
			httpResult = wrapResponsetoResult(response, contentType.getCharset());
		}
		return httpResult;
	}

	/**
	 * 
	 */
	public HttpResult wrapResponsetoResult(HttpResponse response, Charset charSet) throws ParseException, IOException {
		HttpResult httpResult = new HttpResult();
		if (response == null)
			return httpResult;
		int statusCode = response.getStatusLine().getStatusCode();
		httpResult.setStatusCode(statusCode);
		httpResult.setSuccess((statusCode >= 200 && statusCode < 300) ? true : false);

		Header[] headers = response.getAllHeaders();
		httpResult.setHeaders(headers);
		HttpEntity entity = response.getEntity();

		String contentType = entity.getContentType() == null ? null : entity.getContentType().getValue();
		String content = entity != null ? EntityUtils.toString(entity, charSet) : null;
		httpResult.setContentType(contentType);
		httpResult.setContent(content);

		if (log.isDebugEnabled()) {
			log.debug("RESP_LINE={}", response);
			for (Header header : headers) {
				log.debug("HEADER={}:{}", header.getName(), header.getValue());
			}
		}
		return httpResult;
	}

	/**
	 * 
	 */
	public String toCookieString(Map<String, String> cookieMap) {
		if (cookieMap == null || cookieMap.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (Entry<String, String> entry : cookieMap.entrySet()) {
			sb.append(entry.getKey() + "=" + entry.getValue() + ";");
		}
		return sb.toString();
	}

	/**
	 * headerMap里面不允许有Cookie的header设置
	 */
	public Header[] genHeaderArray(Map<String, String> cookieMap, Map<String, String> headerMap, ContentType contentType) {
		List<Header> headerList = Lists.newArrayList();
		String encoding = contentType.getCharset().name();
		if (cookieMap != null && !cookieMap.isEmpty()) {
			headerList.add(new BasicHeader(HttpConstant.COOKIE, toCookieString(cookieMap)));
		}
		if (headerMap != null && !headerMap.isEmpty()) {
			for(Entry<String, String> entry : headerMap.entrySet()){
				headerList.add(new BasicHeader(entry.getKey(), entry.getValue()));
			}
		}

		headerList.add(new BasicHeader(HttpConstant.ACCEPT, HttpConstant.ACCEPT_DEF_VAL));
		headerList.add(new BasicHeader(HttpConstant.ACCEPT_ENCODING, HttpConstant.ACCEPT_ENCODING_DEF_VAL));
		headerList.add(new BasicHeader(HttpConstant.ACCEPT_LANGUAGE, HttpConstant.ACCEPT_LANGUAGE_DEF_VAL));
		headerList.add(new BasicHeader(HttpConstant.CONTENT_TYPE, contentType.getMimeType()
				+ (encoding == null || encoding.isEmpty() ? "" : ("; charset=" + encoding.trim()))));
		headerList.add(new BasicHeader(HttpConstant.USER_AGENT, HttpConstant.USER_AGENT_IE11));
		headerList.add(new BasicHeader(HttpConstant.CONN_DIRECTIVE, HttpConstant.CONN_KEEP_ALIVE));

		return (Header[]) headerList.toArray(new Header[0]);

	}
	/**
	 * 
	 */
	public Header[] genHeaderArrayWithoutConType(Map<String, String> cookieMap, ContentType contentType) {
		List<Header> headerList = Lists.newArrayList();
		//String encoding = contentType.getCharset().name();

		headerList.add(new BasicHeader(HttpConstant.ACCEPT, HttpConstant.ACCEPT_DEF_VAL));
		headerList.add(new BasicHeader(HttpConstant.ACCEPT_ENCODING, HttpConstant.ACCEPT_ENCODING_DEF_VAL));
		headerList.add(new BasicHeader(HttpConstant.ACCEPT_LANGUAGE, HttpConstant.ACCEPT_LANGUAGE_DEF_VAL));
		headerList.add(new BasicHeader(HttpConstant.USER_AGENT, HttpConstant.USER_AGENT_IE11));
		headerList.add(new BasicHeader(HttpConstant.CONN_DIRECTIVE, HttpConstant.CONN_KEEP_ALIVE));
		if (cookieMap != null && !cookieMap.isEmpty()) {
			headerList.add(new BasicHeader(HttpConstant.COOKIE, toCookieString(cookieMap)));
		}

		return (Header[]) headerList.toArray(new Header[0]);

	}
	/**
	 * 
	 */
	private class IdleConnectionMonitorThread extends Thread {
		private final PoolingHttpClientConnectionManager connMgr;
		// private final HttpClientConnectionManager connMgr;
		private volatile boolean shutdown;

		public IdleConnectionMonitorThread(PoolingHttpClientConnectionManager connMgr) {
			super();
			this.connMgr = connMgr;
		}

		@Override
		public void run() {
			try {
				while (!shutdown) {
					synchronized (this) {
						wait(5000);
						// Close expired connections
						connMgr.closeExpiredConnections();
						// Optionally, close connections
						// that have been idle longer than 30 sec
						connMgr.closeIdleConnections(30, TimeUnit.SECONDS);
					}
				}
			} catch (InterruptedException ex) {
				// terminate
			}
		}

		public void shutdown() {
			shutdown = true;
			synchronized (this) {
				notifyAll();
			}
		}
	}

	private static Map<String, String> getUrlParamFromMpParam(String mpParam) throws MalformedURLException {
		if(mpParam.startsWith("http")) {
			URL url = new URL(mpParam);
			mpParam = url.getQuery();
		}
		Map<String, String> map = new HashMap<>();

		String[] params = mpParam.split("&");
		for (String param : params){
			String[] keyValue = param.split("=");
			if(keyValue.length > 1 && org.apache.commons.lang3.StringUtils.isNotBlank(keyValue[1])){
				map.put(keyValue[0], keyValue[1]);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		String mpParam = "http://canting.sjst.test.meituan.com/api/rmstakeaway/re1?tenantId=10036586&brandId=&shopId=600028077&type=2";
		try {
			Map<String, String> map = getUrlParamFromMpParam(mpParam);
			System.out.println(map);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
