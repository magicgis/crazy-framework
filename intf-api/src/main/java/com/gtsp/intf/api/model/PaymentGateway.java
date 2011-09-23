package com.gtsp.intf.api.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class InterfacePgDomain.
 */
public class PaymentGateway extends InterfaceDomain implements Serializable {

	// --- 공통 파라미터 ==========================================
	/** 결재 수단(신용카드,WebMoney, 핸드폰 결재). */
	private String payMethod;

	/** T store JAPAN 서비스 ID. */
	private String serviceId;

	/** 결제 결과를 통지하는 URL. */
	private String returnUrl;

	/** 주문 아이디. */
	private String orderId;

	/** Store 사용자 아이디. */
	private String userId;

	/** 상품 ID. */
	private String itemId;

	/** 상품 명. */
	private String itemName;

	/** 가격. */
	private String price;

	/** 단말의 이통사를 판별 구분자. */
	private String carrierInfo;

	/** 결재 일자. */
	private String tranDate;

	/** 결재 정보 번호 (각 결제 수단 별로 되돌려진 결제 정보 번호를 되돌려줌). */
	private String payInfoNo;

	/** 카드 거래 시의 거래 ID. */
	private String cardAccessId;

	/** 카드 거래 패스워드. */
	private String cardAccessPass;

	/** 카드 회사 코드. */
	private String cardCompany;

	/** 동월 내 재등록 Flag. */
	private String reregInSameMonth;

	/** 「au 간단 결제」 계속 과금 Id. */
	private String continueId;

	/** 카드 등록 연번. */
	private String cardSeq;

	/** 결제 년월일. */
	private String accountDay;

	/** 과금 처리 결과 파일. */
	private String resultFile;

	// --- only j-store ===================================
	/** au one Open ID (j store에서만 사용). */
	private String auoneOpenId;
	
	/** WebMoney 이용 시 출력. 구매에 사용된 WebMoney의 관리 번호. */
	private String webmoneyControlNo;
	
	/** RAKUTEN 이용 시 해당 거래의 주문 ID. */
	private String rakutenOrderId;
	
	
	/**
	 * Gets the service id.
	 * 
	 * @return the service id
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * Sets the service id.
	 * 
	 * @param serviceId
	 *            the new service id
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * Gets the return url.
	 * 
	 * @return the return url
	 */
	public String getReturnUrl() {
		return returnUrl;
	}

	/**
	 * Sets the return url.
	 * 
	 * @param returnUrl
	 *            the new return url
	 */
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	/**
	 * Gets the order id.
	 * 
	 * @return the order id
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * Sets the order id.
	 * 
	 * @param orderId
	 *            the new order id
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * Gets the pay method.
	 * 
	 * @return the pay method
	 */
	public String getPayMethod() {
		return payMethod;
	}

	/**
	 * Sets the pay method.
	 * 
	 * @param payMethod
	 *            the new pay method
	 */
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	/**
	 * Gets the user id.
	 * 
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 * 
	 * @param userId
	 *            the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the auone open id.
	 * 
	 * @return the auone open id
	 */
	public String getAuoneOpenId() {
		return auoneOpenId;
	}

	/**
	 * Sets the auone open id.
	 * 
	 * @param auoneOpenId
	 *            the new auone open id
	 */
	public void setAuoneOpenId(String auoneOpenId) {
		this.auoneOpenId = auoneOpenId;
	}

	/**
	 * Gets the item id.
	 * 
	 * @return the item id
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * Sets the item id.
	 * 
	 * @param itemId
	 *            the new item id
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * Gets the item name.
	 * 
	 * @return the item name
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Sets the item name.
	 * 
	 * @param itemName
	 *            the new item name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price
	 *            the new price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * Gets the carrier info.
	 * 
	 * @return the carrier info
	 */
	public String getCarrierInfo() {
		return carrierInfo;
	}

	/**
	 * Sets the carrier info.
	 * 
	 * @param carrierInfo
	 *            the new carrier info
	 */
	public void setCarrierInfo(String carrierInfo) {
		this.carrierInfo = carrierInfo;
	}

	/**
	 * Gets the tran date.
	 * 
	 * @return the tran date
	 */
	public String getTranDate() {
		return tranDate;
	}

	/**
	 * Sets the tran date.
	 * 
	 * @param tranDate
	 *            the new tran date
	 */
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	/**
	 * Gets the pay info no.
	 * 
	 * @return the pay info no
	 */
	public String getPayInfoNo() {
		return payInfoNo;
	}

	/**
	 * Sets the pay info no.
	 * 
	 * @param payInfoNo
	 *            the new pay info no
	 */
	public void setPayInfoNo(String payInfoNo) {
		this.payInfoNo = payInfoNo;
	}

	/**
	 * Gets the card access id.
	 * 
	 * @return the card access id
	 */
	public String getCardAccessId() {
		return cardAccessId;
	}

	/**
	 * Sets the card access id.
	 * 
	 * @param cardAccessId
	 *            the new card access id
	 */
	public void setCardAccessId(String cardAccessId) {
		this.cardAccessId = cardAccessId;
	}

	/**
	 * Gets the card access pass.
	 * 
	 * @return the card access pass
	 */
	public String getCardAccessPass() {
		return cardAccessPass;
	}

	/**
	 * Sets the card access pass.
	 * 
	 * @param cardAccessPass
	 *            the new card access pass
	 */
	public void setCardAccessPass(String cardAccessPass) {
		this.cardAccessPass = cardAccessPass;
	}

	/**
	 * Gets the webmoney control no.
	 * 
	 * @return the webmoney control no
	 */
	public String getWebmoneyControlNo() {
		return webmoneyControlNo;
	}

	/**
	 * Sets the webmoney control no.
	 * 
	 * @param webmoneyControlNo
	 *            the new webmoney control no
	 */
	public void setWebmoneyControlNo(String webmoneyControlNo) {
		this.webmoneyControlNo = webmoneyControlNo;
	}

	/**
	 * Gets the rakuten order id.
	 * 
	 * @return the rakuten order id
	 */
	public String getRakutenOrderId() {
		return rakutenOrderId;
	}

	/**
	 * Sets the rakuten order id.
	 * 
	 * @param rakutenOrderId
	 *            the new rakuten order id
	 */
	public void setRakutenOrderId(String rakutenOrderId) {
		this.rakutenOrderId = rakutenOrderId;
	}

	/**
	 * Gets the card company.
	 * 
	 * @return the card company
	 */
	public String getCardCompany() {
		return cardCompany;
	}

	/**
	 * Sets the card company.
	 * 
	 * @param cardCompany
	 *            the new card company
	 */
	public void setCardCompany(String cardCompany) {
		this.cardCompany = cardCompany;
	}

	/**
	 * Gets the rereg in same month.
	 * 
	 * @return the rereg in same month
	 */
	public String getReregInSameMonth() {
		return reregInSameMonth;
	}

	/**
	 * Sets the rereg in same month.
	 * 
	 * @param reregInSameMonth
	 *            the new rereg in same month
	 */
	public void setReregInSameMonth(String reregInSameMonth) {
		this.reregInSameMonth = reregInSameMonth;
	}

	/**
	 * Gets the continue id.
	 * 
	 * @return the continue id
	 */
	public String getContinueId() {
		return continueId;
	}

	/**
	 * Sets the continue id.
	 * 
	 * @param continueId
	 *            the new continue id
	 */
	public void setContinueId(String continueId) {
		this.continueId = continueId;
	}

	/**
	 * Gets the card seq.
	 * 
	 * @return the card seq
	 */
	public String getCardSeq() {
		return cardSeq;
	}

	/**
	 * Sets the card seq.
	 * 
	 * @param cardSeq
	 *            the new card seq
	 */
	public void setCardSeq(String cardSeq) {
		this.cardSeq = cardSeq;
	}

	/**
	 * Gets the account day.
	 * 
	 * @return the account day
	 */
	public String getAccountDay() {
		return accountDay;
	}

	/**
	 * Sets the account day.
	 * 
	 * @param accountDay
	 *            the new account day
	 */
	public void setAccountDay(String accountDay) {
		this.accountDay = accountDay;
	}

	/**
	 * Gets the result file.
	 * 
	 * @return the result file
	 */
	public String getResultFile() {
		return resultFile;
	}

	/**
	 * Sets the result file.
	 * 
	 * @param resultFile
	 *            the new result file
	 */
	public void setResultFile(String resultFile) {
		this.resultFile = resultFile;
	}
}
