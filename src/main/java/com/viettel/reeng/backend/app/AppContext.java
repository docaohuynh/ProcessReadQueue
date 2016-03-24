/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.viettel.reeng.backend.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;



/**
 * 
 * @author vas_khanhlp1
 */
public class AppContext {

	private static AppContext instance;
	private ApplicationContext context;

	public static AppContext getInstance() {
		if (instance == null) {
			instance = new AppContext();
		}
		
		System.out.println("");
		return instance;
	}

	private AppContext() {
//		context = new FileSystemXmlApplicationContext(new String[] {"../etc/applicationContext.xml" }); //linux
		context = new FileSystemXmlApplicationContext(new String[] {"etc/applicationContext.xml" }); //window
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public ApplicationContext getApplicationContext() {
		return context;
	}

	public Object getBean(String id) {
		return context.getBean(id);
	}

	public <T> T getBean(Class<T> requiredType) {
		return context.getBean(requiredType);
	}
	
}
