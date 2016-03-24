package com.viettel.task.model.bean;

public class SendSmsInfo {
	
	private String apiKey;
	private String apiSecret;
	private String from;
	private String to;
	private String text;
	
	public SendSmsInfo(String apiKey, String apiSecret, String from, String to, String text){
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.from = from;
		this.to = to;
		this.text = text;
	}

	public String toString(){
		String result = "api_key="+apiKey+"&api_secret="+apiSecret+"&from="+from+"&to="+to+"&text="+text;
		return result;
	}
	
}
