package com.viettel.task.sms.respone;

/**
 * @author huynhdc
 *
 */
public class NexmoSms {

    private String status;
	private String messageId;
	private String to;
	private String clientRef;
	private String remainingBalance;
	private String messagePrice;
	private String network;
	private String errorText;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getClientRef() {
		return clientRef;
	}
	public void setClientRef(String clientRef) {
		this.clientRef = clientRef;
	}
	public String getRemainingBalance() {
		return remainingBalance;
	}
	public void setRemainingBalance(String remainingBalance) {
		this.remainingBalance = remainingBalance;
	}
	public String getMessagePrice() {
		return messagePrice;
	}
	public void setMessagePrice(String messagePrice) {
		this.messagePrice = messagePrice;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getErrorText() {
		return errorText;
	}
	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}
	
}
