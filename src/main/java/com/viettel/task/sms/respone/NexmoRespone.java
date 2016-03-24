package com.viettel.task.sms.respone;

/**
 * @author huynhdc
 *
 */
public class NexmoRespone {
	private String messageCount;
	private NexmoSms[] messages;
	public String getMessageCount() {
		return messageCount;
	}
	public void setMessageCount(String messageCount) {
		this.messageCount = messageCount;
	}
	public NexmoSms[] getMessages() {
		return messages;
	}
	public void setMessages(NexmoSms[] messages) {
		this.messages = messages;
	}
	
	
}
