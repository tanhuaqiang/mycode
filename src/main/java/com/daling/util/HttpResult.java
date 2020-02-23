package com.daling.util;

import java.util.Arrays;

import org.apache.http.Header;

public class HttpResult {

	private Header[] headers;
    private String content;
    private int statusCode = 200;
    private String contentType;
    private boolean success;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public void setHeaders(Header[] headers) {
        this.headers = headers;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "HttpResult [headers=" + Arrays.toString(headers) + ", content=" + content + ", statusCode=" + statusCode + ", contentType=" + contentType
				+ ", success=" + success + "]";
	}
} 
