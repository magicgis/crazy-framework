package com.gtsp.intf.api.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class InterfaceDomain.
 */
public class InterfaceDomain implements Serializable {

	// - request attributes ============================
	/** 요청 URL. */
	private String requestUrl;
	
	/** 요청 타입. */
	private RequestType requestType;
	
	/** The response type. */
	private ResponseType responseType;

	/** global store Id. */
	private String storeId;

	/** ㅇ청 Timeout (단위/ms).기본값 3분 */
	private int requestTimeout = 180000;

	// - response attributes ============================
	/** 처리 여부 . */
	private boolean resultSuccess = false;

	/** http 상태 코드. */
	private int resultHttpStatus;

	/** 요청 회사에서 전송한 실제 결과 처리 코드. */
	private String resultCode;

	/** 요청 회사에서 전송한 실제 결과 처리 값. */
	private String resultMessageBody;

	/** 요청이 multipart인지 구분자. 기본값은 false */
	private boolean multipart = false;
	
	/** 저장될 경로. */
	private String filePath;

	/**
	 * Gets the request type.
	 *
	 * @return the request type
	 */
	public RequestType getRequestType() {
		return requestType;
	}

	/**
	 * Sets the request type.
	 *
	 * @param requestType the new request type
	 */
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
	
	/**
	 * Gets the store id.
	 *
	 * @return the store id
	 */
	public String getStoreId() {
		return storeId;
	}

	/**
	 * Sets the store id.
	 *
	 * @param storeId the new store id
	 */
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	/**
	 * Gets the request timeout.
	 *
	 * @return the request timeout
	 */
	public int getRequestTimeout() {
		return requestTimeout;
	}

	/**
	 * Sets the request timeout.
	 *
	 * @param requestTimeout the new request timeout
	 */
	public void setRequestTimeout(int requestTimeout) {
		this.requestTimeout = requestTimeout;
	}

	/**
	 * Checks if is result success.
	 *
	 * @return true, if is result success
	 */
	public boolean isResultSuccess() {
		return resultSuccess;
	}

	/**
	 * Sets the result success.
	 *
	 * @param resultSuccess the new result success
	 */
	public void setResultSuccess(boolean resultSuccess) {
		this.resultSuccess = resultSuccess;
	}

	/**
	 * Gets the result http status.
	 *
	 * @return the result http status
	 */
	public int getResultHttpStatus() {
		return resultHttpStatus;
	}

	/**
	 * Sets the result http status.
	 *
	 * @param resultHttpStatus the new result http status
	 */
	public void setResultHttpStatus(int resultHttpStatus) {
		this.resultHttpStatus = resultHttpStatus;
	}

	/**
	 * Gets the result code.
	 *
	 * @return the result code
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * Sets the result code.
	 *
	 * @param resultCode the new result code
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * Gets the result message body.
	 *
	 * @return the result message body
	 */
	public String getResultMessageBody() {
		return resultMessageBody;
	}

	/**
	 * Sets the result message body.
	 *
	 * @param resultMessageBody the new result message body
	 */
	public void setResultMessageBody(String resultMessageBody) {
		this.resultMessageBody = resultMessageBody;
	}

	/**
	 * Checks if is multipart.
	 *
	 * @return true, if is multipart
	 */
	public boolean isMultipart() {
		return multipart;
	}

	/**
	 * Sets the multipart.
	 *
	 * @param multipart the new multipart
	 */
	public void setMultipart(boolean multipart) {
		this.multipart = multipart;
	}

	/**
	 * Gets the request url.
	 *
	 * @return the request url
	 */
	public String getRequestUrl() {
		return requestUrl;
	}

	/**
	 * Sets the request url.
	 *
	 * @param requestUrl the new request url
	 */
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	/**
	 * Gets the response type.
	 *
	 * @return the response type
	 */
	public ResponseType getResponseType() {
		return responseType;
	}

	/**
	 * Sets the response type.
	 *
	 * @param responseType the new response type
	 */
	public void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}

	/**
	 * Gets the file path.
	 *
	 * @return the file path
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * Sets the file path.
	 *
	 * @param filePath the new file path
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
