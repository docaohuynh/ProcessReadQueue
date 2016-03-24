package com.viettel.task.sms;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.viettel.task.constants.Constants;
import com.viettel.task.model.bean.SendSmsInfo;
import com.viettel.task.sms.respone.NexmoRespone;
import com.viettel.task.util.GsonUtils;
import com.viettel.task.util.ReplaceString;

public class SendSMSNexmo {
	
		private final String USER_AGENT = "Mozilla/5.0";
	
/*		public static void main(String[] args) throws Exception {
	
			SendSMSNexmo http = new SendSMSNexmo();
	
			System.out.println("\nTesting 2 - Send Http POST request");
			http.sendPost();
	
		}*/


	// HTTP POST request
		public NexmoRespone sendPost(String param) throws Exception {
			String url = Constants.NEXMO_API;
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			
			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = param;
			
			
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			//print result
			System.out.println(response.toString());
			//respone result
			String responeString = response.toString();
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
			String result = done.replaceMultiString(responeString, list);
			NexmoRespone textReceive = GsonUtils.getGson().fromJson(result,
					NexmoRespone.class);
			
			return textReceive;

		}
}
