package com.viettel.task.test;

import org.apache.log4j.PropertyConfigurator;

import com.viettel.reeng.backend.app.AppContext;
import com.viettel.task.model.EduSubject;
import com.viettel.task.service.EduSubjectService;

public class TestDao {

	public static void main(String[] args) {		
//		PropertyConfigurator.configure("../etc/log4j.conf"); //linux
		PropertyConfigurator.configure("etc/log4j.conf"); //window
//		AppContext.getInstance()
		
		/*TextMtService srv = (TextMtService) AppContext.getInstance().getBean("textMtService");
		TextMt mt = new TextMt();
		
		mt.setIsdn("01656132662");
		mt.setMtContent("abc");
		mt.setProcessId(0);
		mt.setSender("7001");
		srv.saveTextMt(mt);
		System.out.println(mt.getIsdn());*/
		
		EduSubjectService srvHist = (EduSubjectService) AppContext.getInstance().getBean("eduSubjectService");
		
		EduSubject cms = srvHist.findById(1);
		
		System.out.println(cms.getDescription());
		/*TextMtHistService srvHist = (TextMtHistService) AppContext.getInstance().getBean("textMtHistService");

		
		TextMtHist hist = new TextMtHist();
    	hist.setIsdn("01656132662");
    	hist.setMtContent("ssssssssssss");
    	hist.setProcessTime(new Date());
    	hist.setSender("nexmo");
    	hist.setStatus(Integer.parseInt(NexmoStatus.SUCCESS));
    	srvHist.saveTextMtHist(hist);*/
		
		
	}
}
