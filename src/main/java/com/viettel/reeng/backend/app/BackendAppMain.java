package com.viettel.reeng.backend.app;

import org.apache.log4j.PropertyConfigurator;


public class BackendAppMain {
	public static void main(String[] args) {		
//		PropertyConfigurator.configure("../etc/log4j.conf");
		PropertyConfigurator.configure("etc/log4j.conf");
		AppContext.getInstance();
	}
}
