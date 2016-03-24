package com.viettel.task.util;

import java.util.List;

/**
 * @author huynhdc
 *
 */
public class ReplaceString {
	private String source;
	private String target;
	
	public ReplaceString (){
	}
	
	public ReplaceString (String source, String target){
		this.source = source;
		this.target = target;
	}
	
	public String replaceMultiString(String input, List<ReplaceString> list){
		String result = input;
		for(ReplaceString lst: list){
			result = result.replace(lst.source, lst.target);
		}
		return result;
	}
}
