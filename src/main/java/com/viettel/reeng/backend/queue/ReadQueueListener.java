package com.viettel.reeng.backend.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.viettel.reeng.backend.app.AppContext;
import com.viettel.task.model.CmsUser;
import com.viettel.task.model.EduChapter;
import com.viettel.task.model.EduQuestion;
import com.viettel.task.model.EduSubject;
import com.viettel.task.service.CmsUserService;
import com.viettel.task.service.EduChapterService;
import com.viettel.task.service.EduQuestionService;
import com.viettel.task.service.EduSubjectService;
import com.viettel.util.mail.ContentMail;
import com.viettel.util.mail.EduSendMail;

public class ReadQueueListener implements ChannelAwareMessageListener {

	private String easy = "1";
	private String medium = "2";
	private String diff = "3";
	private String veryDiff = "4";

	private int workerSize = 10;
	private Logger logger = Logger.getLogger(ReadQueueListener.class);
	private String username;
	private String subject;
	private Integer totalNumQuestion;
	private Integer numEasy;
	private Integer numMedium;
	private Integer numDiff;
	private Integer numVeryDiff;
	private String email;
	private List<String> arrLevel = new ArrayList<String>();
	private List<String> arrChapters = new ArrayList<String>();
	private List<String> arrQuestionFile = new ArrayList<String>();
	private List<String> arrQuestionFullFile = new ArrayList<String>();
	private HashMap<String, Integer> chapter;

	@Autowired
	RabbitTemplate template;

	public ReadQueueListener() {
	}

	public ReadQueueListener(int workerSize) {
	}

	public void onMessage(Message msg, Channel channel) {

		try {
			String mes = new String(msg.getBody());
			logger.info("[MESSAGE] [" + msg.getMessageProperties().getDeliveryTag() + "] " + mes);
			//step 2: convert to JSON
			Gson gson = new Gson();
			//test
			String content = "";
			String to = "";
			ReadQueue messageQueue = (ReadQueue)gson.fromJson(mes, ReadQueue.class);
			if(messageQueue!=null){
				System.out.println("subjectId ... :"+ messageQueue.getSubjectid());
				/*get Question*/
				for(String questionid: messageQueue.getQuesitionsid()){
//					get Question and count level;
					EduQuestionService questionService = (EduQuestionService) AppContext.getInstance().getBean("eduQuestionService");
					EduQuestion question = questionService.findById(Integer.parseInt(questionid));
					arrLevel.add(question.getLevel().toString());
					arrQuestionFile.add(question.getQuestionFile());
					arrQuestionFullFile.add(question.getFullQuestionFile());

					//get Chapter by question
					EduChapterService chapterService = (EduChapterService) AppContext.getInstance().getBean("eduChapterService");
					EduChapter chap = chapterService.findById(question.getChapterId());
					arrChapters.add(chap.getName());
					
				}
//				count num question
				Object[] objLevel = arrLevel.toArray();
		        HashMap<String, Integer> mapLevel = countIntem(objLevel);
		        totalNumQuestion = 0;
		        numEasy =0;
		        numMedium =0;
		        numDiff=0;
		        numVeryDiff=0;
		        
		        for (Entry<String, Integer> entry : mapLevel.entrySet()) {
		        	if(entry.getKey().equals(easy)){
		        		numEasy ++;
		        	}else if(entry.getKey().equals(medium)){
		        		numMedium++;
		        	}else if(entry.getKey().equals(diff)){
		        		numDiff++;	
		        	}else{
		        		numVeryDiff++;
		        	}
		        	totalNumQuestion = numEasy+ numMedium+ numDiff+ numVeryDiff;
		            System.out.println(entry.getKey());
		        }
				
//		        count chapter
		        Object[] objChapter = arrLevel.toArray();
		        chapter = countIntem(objChapter);
		        
		        /*get username*/
		        CmsUserService cmsUserService = (CmsUserService) AppContext.getInstance().getBean("cmsUserService");
				CmsUser cmsUser = cmsUserService.findById(Integer.parseInt(messageQueue.getUserid()));
				username = cmsUser.getUsername();
				email = cmsUser.getEmail();
				
				/*get subject*/
				EduSubjectService eduSubjectService = (EduSubjectService) AppContext.getInstance().getBean("eduSubjectService");
				EduSubject eduSubject = eduSubjectService.findById(Integer.parseInt(messageQueue.getSubjectid()));
				subject = eduSubject.getName();
				
		        ContentMail contentMail =  new ContentMail(username, chapter, totalNumQuestion, 
		        		numEasy, numMedium, numDiff, numVeryDiff, subject, email, 
		        		arrQuestionFile, arrQuestionFullFile);
		        EduSendMail sendMail = new EduSendMail();
		        sendMail.sendEmail(contentMail);
		        
//				System.out.println("AAAAAAAAAAAAAAaaa" + arrLevel.toString());
			}
		} catch (Exception ex) {
			logger.error("[NOTIFICATION MESSAGE] [" + msg.getMessageProperties().getDeliveryTag() + "] has an exception.", ex);
		}

	}

	public HashMap<String, Integer> countIntem(Object[] array) {

		Arrays.sort(array);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Integer count = 0;
		String first = (String) array[0];
		for (int counter = 0; counter < array.length; counter++) {
			if (first.hashCode() == array[counter].hashCode()) {
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

	public void shutdown() {
		// executor.shutdown();
	}

	public int getWorkerSize() {
		return workerSize;
	}

	public void setWorkerSize(int workerSize) {
		this.workerSize = workerSize;
	}
}
