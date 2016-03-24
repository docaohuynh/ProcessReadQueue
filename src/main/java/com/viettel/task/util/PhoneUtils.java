package com.viettel.task.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;


public class PhoneUtils {
	private static final Logger logger = Logger
			.getLogger(PhoneUtils.class);
	

	public static final String PHONE_PATTERN = "^0?[9][0-9][1-9][0-9]{6}$|^0?16[0-9]{8}$|^0?12[0-9]{8}$|^0?1[8-9][0-9]{8}$|^[+]?849[0-9][1-9][0-9]{6}$|^[+]?8416[0-9]{8}$|^[+]?8412[0-9]{8}$|^[+]?841[8-9][0-9]{8}$";
    public static final String VIETTEL_PATTERN = "^09[6-8][1-9][0-9]{6,6}$|^016[1-9][1-9][0-9]{6,6}$";
    private static final String MOBILE = "^0?90[0-9]{7}$|^0?93[0-9]{7}$|^0?120[0-9]{7}$|^0?121[0-9]{7}$|^0?122[0-9]{7}$|^0?126[0-9]{7}$|^0?128[0-9]{7}";
    private static final String VINA = "^0?91[0-9]{7}$|^0?94[0-9]{7}$|^0?123[0-9]{7}$|^0?124[0-9]{7}$|^0?125[0-9]{7}$|^0?127[0-9]{7}";

	private static Pattern phonePattern = Pattern.compile(PHONE_PATTERN);
	private static Pattern vtPhonePattern = Pattern.compile(VIETTEL_PATTERN);
	
	
	private static final String vnPrefixPlus = "+84";
	private static final String vnPrefix = "84";
	private static final String chinaPrefix = "86";
	private static final String vnPrefixZero = "0084";
	
	//INDONESIA
	public static final String INDO_SMARTFREN_PHONE = "^0?88[1-4][0-9]{7}$|^0?88[1-4][0-9]{8}$|^0?88[7-9][0-9]{7}$|^0?88[7-9][0-9]{8}$";
    public static final String INDO_TELKOMSEL_PHONE = "^0?81[1-3][0-9]{7}$|^0?81[1-3][0-9]{8}$|^0?82[1-3][0-9]{7}$|^0?82[1-3][0-9]{8}$|^0?85[2-3][0-9]{7}$|^0?85[2-3][0-9]{8}$";
    public static final String INDO_INDOSAT_PHONE =   "^0?81[4-6][0-9]{7}$|^0?81[4-6][0-9]{8}$|^0?85[5-8][0-9]{7}$|^0?85[5-8][0-9]{8}$";
	
    //CHINA
    public static final String CHINA_MOBILE_PHONE = "^13[4-9][0-9]{8}$|^15[0-2][0-9]{8}$|^15[7-9][0-9]{8}$|^188[0-9]{8}$";
    public static final String CHINA_UNICOM_PHONE = "^13[0-2][0-9]{8}$|^15[5-6][0-9]{8}$|^18[5-6][0-9]{8}$";
    public static final String CHINA_TELECOM_PHONE = "^133[0-9]{8}$|^153[0-9]{8}$|^189[0-9]{8}$";

    
	private static final String indoPrefixPlus = "+62";
	private static final String indoPrefix = "62";
	private static final String indoPrefixZero = "0062";
	
	private static Pattern indoPhonePattern = Pattern.compile(INDO_SMARTFREN_PHONE + "|" + INDO_TELKOMSEL_PHONE + "|" + INDO_INDOSAT_PHONE);
	private static Pattern indoPhoneMobiVina = Pattern.compile(VINA + "|" + MOBILE );
	private static Pattern chinaPhonePattern = Pattern.compile(CHINA_MOBILE_PHONE + "|" + CHINA_UNICOM_PHONE  + "|" + CHINA_TELECOM_PHONE );
	
	public static boolean isPhoneNumber(String number) {

		if (number == null || number.length() == 0)
			return false;	

		if (phonePattern.matcher(number).find()) {
			return true;
		}
		//Indonesia
		if (indoPhonePattern.matcher(number).find()) {
			return true;
		}
		
		//Mobi Vina
		if (indoPhoneMobiVina.matcher(number).find()) {
			return true;
		}
		
		//China
		if (chinaPhonePattern.matcher(number).find()) {
			return true;
		}
		return false;
	}
	
	public static boolean isPhoneIndo(String number) {

		if (number == null || number.length() == 0)
			return false;	
		//Indonesia
		if (indoPhonePattern.matcher(number).find()) {
			return true;
		}
		return false;
	}
	
	public static boolean isPhoneChina(String number) {

		if (number == null || number.length() == 0)
			return false;	
		//China
		if (chinaPhonePattern.matcher(number).find()) {
			return true;
		}
		return false;
	}
	
	public static boolean isPhoneMobiVina(String number) {

		if (number == null || number.length() == 0)
			return false;	
		//Indonesia
		if (indoPhoneMobiVina.matcher(number).find()) {
			return true;
		}
		return false;
	}

	//84xxx => 0xxx
	public static String formatTel2AccountId(String number) {		
		if (number.startsWith(vnPrefix)) {
			number = "0" + number.substring(vnPrefix.length(), number.length());
		} else if (number.startsWith(vnPrefixPlus)) {
			number = "0" + number.substring(vnPrefixPlus.length(), number.length());			
		} else if (number.startsWith(vnPrefixZero)) {
			number = "0" + number.substring(vnPrefixZero.length(), number.length());			
		}
		
		//Indonesia
		if (number.startsWith(indoPrefix)) {
			number = "0" + number.substring(indoPrefix.length(), number.length());
		} else if (number.startsWith(indoPrefixPlus)) {
			number = "0" + number.substring(indoPrefixPlus.length(), number.length());			
		} else if (number.startsWith(indoPrefixZero)) {
			number = "0" + number.substring(indoPrefixZero.length(), number.length());			
		}
		
		return number;
	}
	

	//0xxx => 84xxx
	public static String formatTel2Indo(String number) {		
		//Indonesia
		if (number.startsWith("0")) {
			number = indoPrefix + number.substring(1, number.length());
		} 
		return number;
	}
	
	//0xxx => 84xxx
	public static String formatMobiVina(String number) {		
		//Mobi Vina
		if (number.startsWith("0")) {
			number = vnPrefix + number.substring(1, number.length());
		} 
		return number;
	}
	
	//0xxx => 84xxx
		public static String formatChina(String number) {		
			//China
			if (number.startsWith("0")) {
				number = chinaPrefix + number.substring(1, number.length());
			}else{
				number = chinaPrefix + number;
			}
			return number;
		}
	
	public static void main(String[] args) {
		
		if (indoPhonePattern.matcher("085288889999").find()) {
			System.out.println("true");
		}
		
//		System.out.println(isVtNumberTel("0915959164"));
		
		
	}

	/**
	 * generate random code
	 */
	public static String genCode(int min, int max) {
		int code = 0;
		String strCode = null;
		code = (int) (min + Math.random() * (max - min));
		strCode = Integer.toString(code);
		return strCode;
	}

	public static enum OtpCode {
		/**
		 * Generate code successful
		 */
		SUCCESSFUL("200"),

		/**
		 * Error: username is not phone number 405 not-allow
		 */
		ERROR_INVALID_USERNAME("405"),
		
		
		/**
		 * Error: username is not phone number 405 not-allow
		 */
		ERROR_FORBIDDEN_USERNAME("403"),
		
		
		ERROR_INTERNAL("500"),

		/**
		 * Error: username is locked 550 permission denied
		 */
		ERROR_LOCKED_USERNAME("550");
		

		private String value;

		OtpCode(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public String getDesc() {
			String result = null;
			if ("403".equalsIgnoreCase(value)) {
				result = "Username is not in the whitelist";
			}
			if ("405".equalsIgnoreCase(value)) {
				result = "Username is not phone number";
			}
			if ("550".equalsIgnoreCase(value)) {
				result = "Username is locked";
			}
			if ("200".equalsIgnoreCase(value)) {
				result = "Successful";
			}
			if ("500".equalsIgnoreCase(value)) {
				result = "Internal error";
			}
			return result;

		}

	}

	// convert from internal Java String format -> UTF-8
//		public static String convertToUTF8(String s) {
//			String out = null;
//			try {
//				out = new String(s.getBytes("UTF-8"), "ISO-8859-1");
//			} catch (java.io.UnsupportedEncodingException e) {
//				return null;
//			}
//			return out;
//		}
	
	public void byteToFile(byte[] bytes, String filePath, String fileName) {

		try {
			// Create the file on server
			File serverFile = new File(filePath + fileName);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public static String encryptMD5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());

			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++)
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));

			return sb.toString();
		} catch (EnumConstantNotPresentException e) {
			logger.error(e.getMessage(), e);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		}
		return "";
	}

	public static long MbtoBye(int Mb) {
		long sizebyte = 0;
		sizebyte = Mb * (1024 * 1024);
		return sizebyte;
	}

	public static int generatedIntegerString(int length) {
		Random number = new Random();
		char[] digits = new char[length];// length 15
		digits[0] = (char) ('1' + number.nextInt(9));
		for (int i = 1; i < length; i++) {
			digits[i] = (char) ('0' + number.nextInt(10));
		}
		return Integer.parseInt(new String(digits));
	}
	
	
	public static boolean isVtNumberTel(String number){
		if (number == null || number.length() == 0)
			return false;	

		if (vtPhonePattern.matcher(number).find()) {
			return true;
		}
		return false;
	}
	
	public static String createOtpSms(String to, String from, String subject, String content){
		return null;
	}


	public static boolean isNotEmpty(String string){
		
		return string!=null && !string.equals("");
	}
	
	public static String toJson(Map<String,Object> map){   
		String jsonStr = null;
		Gson gson = new GsonBuilder().create();
		jsonStr = gson.toJson(map);
		return jsonStr;

	}
	
	public static String listToJsonArray(List<Object> lsObject){
		Type listType = new TypeToken<List<Object>>() {
		}.getType();
		Gson gson = new Gson();
		JsonElement js = gson.toJsonTree(lsObject,listType);		
		return js.toString();
	}

	


//	Set<Map.Entry<String, String> entries = map.entrySet();
//	JSONArray mJSONArray = new JSONArray(entries);
	
	public static String genResult(int code, String desc) {
		
		JsonObject obj = new JsonObject();
		
		obj.addProperty("errorCode", code);
		obj.addProperty("desc", desc);
		
		return obj.toString();
	}
	
//	public static String genResult(int code, String desc, Map<String,JsonElement> params) {
//			
//			JsonObject obj = new JsonObject();
//			
//			obj.addProperty("errorCode", code);
//			obj.addProperty("desc", desc);
//			for(String key: params.keySet()){
//				obj.add(key, params.get(key));
//			}
//			
//			return obj.toString();
//		}
	
	public static String genResult(int code, String desc, Map<String,Object> params) {
		
		JsonObject obj = new JsonObject();
		
		obj.addProperty("errorCode", code);
		obj.addProperty("desc", desc);
		for (String key : params.keySet()) {
			Object value = params.get(key);
			if (value instanceof JsonElement) {
				obj.add(key, (JsonElement) params.get(key));
			} else {
				if (value instanceof String) {
					obj.addProperty(key, (String) params.get(key));
				} else {
					obj.addProperty(key, (Number) params.get(key));
				}
			}
		}

		return obj.toString();
	}

	
	public static String genOtpResult(OtpCode code,long lockedTime) {
		
		JsonObject obj = new JsonObject();
		
		obj.addProperty("code", code.getValue());
		obj.addProperty("desc", code.getDesc());
		if(lockedTime != 0){
			obj.addProperty("lockedTimeSd", lockedTime);
		}
		return obj.toString();
	}
	
	public static String genOtpResult(OtpCode code,String desc) {
		
		JsonObject obj = new JsonObject();
		
		obj.addProperty("code", code.getValue());
		obj.addProperty("desc", desc);
		
		return obj.toString();
	}
	
	
	public static String genOtpResult(OtpCode code, long lockedTime, JsonArray jsonArray) {
		JsonObject obj = new JsonObject();
		
		obj.addProperty("code", code.getValue());
		obj.addProperty("desc", code.getDesc());
		if(lockedTime != 0){
			obj.addProperty("lockedTimeSd", lockedTime);
		}
		if(jsonArray != null){
			obj.add("subscription_package", jsonArray);
		}
		return obj.toString();
		
	}
	
	//normaliser to 84xxx
	public static String normalizeMsisdn(String msisdn){
		
		if (msisdn.startsWith("84")) {
			return msisdn;
		}
		
		if (msisdn.startsWith("+84")) {
			return "84" + msisdn.substring(3, msisdn.length());			
		}
		
		if (msisdn.startsWith("0084")) {
			return "84" + msisdn.substring(4, msisdn.length());
		}

		if (msisdn.startsWith("0")) {
			return "84" + msisdn.substring(1, msisdn.length());
		}

		return "84" + msisdn;
	}
	
	private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789";
	public static String genRandomString(int size){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < size; i++) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING
					.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
//	public static void main(String[] args) {
//		try {
//			System.out.println("com.mysql.jdbc.Driver");
//			System.out.println("EN = " + PassTranformer.encrypt("guest"));
//			System.out.println("DE = " + PassTranformer.decrypt("de7810347261c26a"));
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
//	public static void main(String[] args) {
//		try {
//			System.out.println("com.mysql.jdbc.Driver");
//			System.out.println(PassTranformer.encrypt("com.mysql.jdbc.Driver"));
//			System.out.println("------------");
//			
//			System.out.println("jdbc:mysql://10.58.46.40:3306/ejabberd_14_05");
//			System.out.println(PassTranformer.encrypt("jdbc:mysql://10.58.46.40:3306/ejabberd_14_05"));
//			System.out.println("------------");
//			
//			System.out.println("softphone");
//			System.out.println(PassTranformer.encrypt("softphone"));
//			System.out.println("------------");
//			
//			System.out.println("Softphone#2013");
//			System.out.println(PassTranformer.encrypt("Softphone#2013"));
//			System.out.println("------------");
//								
//			System.out.println("5");
//			System.out.println(PassTranformer.encrypt("5"));
//			System.out.println("------------");
//			
//			System.out.println("select 1");
//			System.out.println(PassTranformer.encrypt("select 1"));
//			System.out.println("------------");
//			
//			System.out.println("true");
//			System.out.println(PassTranformer.encrypt("true"));
//			System.out.println("------------");
//			
//			System.out.println("120000");
//			System.out.println(PassTranformer.encrypt("120000"));
//			System.out.println("------------");
//			
//			System.out.println("900000");
//			System.out.println(PassTranformer.encrypt("900000"));
//			System.out.println("------------");
//			
//			System.out.println("2");
//			System.out.println(PassTranformer.encrypt("2"));
//			System.out.println("------------");
//			
//			
//			//mongo
//			System.out.println("------------------------ mongo ");
//			
//			System.out.println("localhost");
//			System.out.println(PassTranformer.encrypt("localhost"));
//			System.out.println("------------");
//			
//			System.out.println("2002");
//			System.out.println(PassTranformer.encrypt("2002"));
//			System.out.println("------------");
//			
//			System.out.println("softphone_test");
//			System.out.println(PassTranformer.encrypt("softphone_test"));
//			System.out.println("------------");
//			
//			System.out.println("------------------------ rabbitmq ");
//			
//			System.out.println("localhost");
//			System.out.println(PassTranformer.encrypt("localhost"));
//			System.out.println("------------");
//			
//			System.out.println("2004");
//			System.out.println(PassTranformer.encrypt("2004"));
//			System.out.println("------------");
//			
//			System.out.println("/");
//			System.out.println(PassTranformer.encrypt("/"));
//			System.out.println("------------");
//			
//			System.out.println("guest");
//			System.out.println(PassTranformer.encrypt("guest"));
//			System.out.println("------------");
//			
//			System.out.println("guest");
//			System.out.println(PassTranformer.encrypt("guest"));
//			System.out.println("------------");
//			
//			System.out.println("------------------------ xmlrpc ");
//			
//			System.out.println("http://localhost:2000/RPC2");
//			System.out.println(PassTranformer.encrypt("http://localhost:2000/RPC2"));
//			System.out.println("------------");
//			
//			System.out.println("5000");
//			System.out.println(PassTranformer.encrypt("5000"));
//			System.out.println("------------");
//						
//			System.out.println("10000");
//			System.out.println(PassTranformer.encrypt("10000"));
//			System.out.println("------------");
//			
//						
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
