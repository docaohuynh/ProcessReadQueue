package com.viettel.task.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.viettel.task.sms.respone.NexmoRespone;
import com.viettel.task.util.GsonUtils;
import com.viettel.task.util.PhoneUtils;
import com.viettel.task.util.ReplaceString;

public class ParseJson {

	public static void main(String[] args) {
/*		String ss = "{    \"message-count\": \"1\",    \"messages\": [{        \"to\": \"841656132662\",        \"message-id\": \"0600000028445F18\",        \"status\": \"0\",        \"remaining-balance\": \"11.73270000\",        \"message-price\": \"0.04930000\",        \"network\": \"45204\"    }]}";
		
		List<ReplaceString> list = new ArrayList<ReplaceString>();
		ReplaceString a = new ReplaceString("message-id", "messageId");
		list.add(a);
		ReplaceString a1 = new ReplaceString("message-count", "messageCount");
		list.add(a1);
		ReplaceString a2 = new ReplaceString("message-price", "messagePrice");
		list.add(a2);
		ReplaceString a3 = new ReplaceString("remaining-balance", "remainingBalance");
		list.add(a3);
		ReplaceString a4 = new ReplaceString("client-ref", "clientRef");
		list.add(a4);
		
		ReplaceString done = new ReplaceString();
		String result = done.replaceMultiString(ss, list);
		NexmoRespone textReceive = GsonUtils.getGson().fromJson(result,
				NexmoRespone.class);
		System.out.println("aaa");*/
		
		String to = PhoneUtils.formatTel2Indo("08577383636");
		System.out.println(to);
	}

}
