package com.gtsp.intf.api;

import com.gtsp.intf.api.model.PaymentGateway;


/**
 * PG 전용 핸들러 인터페이스.
 */
public interface PGHandler {
	
	/**
	 * 단일 과금/ 아이템 과금.
	 *
	 * @param paymentGateway the payment gateway
	 * @return the payment gateway
	 * @throws Exception the exception
	 */
	public PaymentGateway handleItem(PaymentGateway paymentGateway) throws Exception;

	/**
	 * 월정액 등록.
	 *
	 * @param paymentGateway the payment gateway
	 * @return the payment gateway
	 * @throws Exception the exception
	 */
	public PaymentGateway handleMonthly(PaymentGateway paymentGateway) throws Exception;

	/**
	 * 월정액 과금 처리 결과 확인.
	 *
	 * @param paymentGateway the payment gateway
	 * @return the payment gateway
	 * @throws Exception the exception
	 */
	public PaymentGateway handleMonthlyConfirm(PaymentGateway paymentGateway) throws Exception;

	/**
	 * 월정액 탈퇴.
	 *
	 * @param paymentGateway the payment gateway
	 * @return the payment gateway
	 * @throws Exception the exception
	 */
	public PaymentGateway handleMonthlyWithdraw(PaymentGateway paymentGateway) throws Exception;

	/**
	 * 매출 취소.
	 *
	 * @param paymentGateway the payment gateway
	 * @return the payment gateway
	 * @throws Exception the exception
	 */
	public PaymentGateway handleCancel(PaymentGateway paymentGateway) throws Exception;


	/**
	 * 환불.
	 *
	 * @param paymentGateway the payment gateway
	 * @return the payment gateway
	 * @throws Exception the exception
	 */
	public PaymentGateway handleRefund(PaymentGateway paymentGateway) throws Exception;


}
