package com.viettel.util.mail;

import java.util.Arrays;
import java.util.HashMap;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class TestSend {

	public static void main(String[] args) {
		String [] chaps = {"cơ","điện","dao dộng", "lượng tử ánh sáng"};
//		ContentMail content = new ContentMail("huynhdc", chaps, 20, 3, 3, 3, 3, "Toán");
//		
//		CrunchifyJavaMailExample send = new CrunchifyJavaMailExample();
//		
//		try {
//			send.sendEmail(content);
//		} catch (AddressException e) {
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}

	}
	
	public HashMap<String, Integer> countIntem( Object[] array ) {

        Arrays.sort(array);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Integer count = 0;
        String first = (String) array[0];
        for( int counter = 0; counter < array.length; counter++ ) {
            if(first.hashCode() == array[counter].hashCode()) {
                count = count + 1;
            } else {
                map.put(first, count);
                count = 1;
            }
            first = (String) array[counter];
            map.put(first, count);
        }

        return map;
    }
	

    /**
     * @param args
     */
    /*public static void main(String[] args) {
        // TODO Auto-generated method stub
    	List<String> list = new ArrayList<String>();
    	list.add("name");
    	list.add("name1");
    	list.add("name2");
    	list.add("name");
        String[] array = { "name", "namehuynh", "name", "name2", "name2",
                "name3", "name1", "name1", "name2", "name2", "name2", "name3" };
        Object[] objArray = list.toArray();
        HashMap<String, Integer> countMap = new TestSend().countIntem(objArray);
        for (Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }*/

}
