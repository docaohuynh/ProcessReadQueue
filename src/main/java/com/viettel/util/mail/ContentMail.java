package com.viettel.util.mail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ContentMail {

	public final String WEBSITE = "skya.vn";
	private String username;
	private String email;
	private String subject;
	private Integer totalNumQuestion;
	private Integer numEasy;
	private Integer numMedium;
	private Integer numDiff;
	private Integer numVeryDiff;
	private List<String> arrQuestionFile = new ArrayList<String>();
	private List<String> arrQuestionFullFile = new ArrayList<String>();
	private HashMap<String, Integer> chapters;

	public ContentMail(String username, HashMap<String, Integer> chapters, Integer totalNumQuestion, Integer numEasy, Integer numMedium,
			Integer numDiff, Integer numVeryDiff, String subject, String email,List<String> arrQuestionFile,List<String> arrQuestionFullFile) {
		this.username = username;
		this.totalNumQuestion = totalNumQuestion;
		this.numEasy = numEasy;
		this.numMedium = numMedium;
		this.numDiff = numDiff;
		this.numVeryDiff = numVeryDiff;
		this.chapters = chapters;
		this.subject = subject;
		this.email = email;
		this.arrQuestionFile = arrQuestionFile;
		this.arrQuestionFullFile = arrQuestionFullFile;
	}

	public String content() {

		StringBuilder chap = new StringBuilder();
		for (Entry<String, Integer> entry : chapters.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            chap.append(
					"<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; + "
							+ entry.getKey() + ": "+entry.getValue()+" câu </p>");
        }

		StringBuilder content = new StringBuilder();
		content.append("<p><strong>Xin chào</strong> " + username + "</p>");
		content.append("<p>" + username + " vừa thực hiện xây dựng bộ đề thi môn " + subject + " trên website "
				+ WEBSITE + ".</p>");
		content.append("<p>Trong đó các chương lựa chọn để xây dựng bộ đề là:</p>");
		content.append(chap.toString());
		content.append("<p>Số lượng câu hỏi khi xây dựng bộ đề là: " + totalNumQuestion + "</p>");
		content.append("<p>Độ khó câu hỏi:</p>");
		content.append(
				"<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; + dễ: "
						+ numEasy + "</p>");
		content.append(
				"<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; + trung bình: "
						+ numMedium + "</p>");
		content.append(
				"<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; + khó: "
						+ numDiff + "</p>");
		content.append(
				"<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; + cực khó: "
						+ numVeryDiff + "</p>");
		content.append("<p>Bộ đề chúng tôi đính kèm trong mail nhé.</p>");
		content.append("<p>Chúc bạn một ngày vui vẻ.</p>");
		content.append("<p>Chào bạn.</p>");

		return content.toString();
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getTotalNumQuestion() {
		return totalNumQuestion;
	}

	public void setTotalNumQuestion(Integer totalNumQuestion) {
		this.totalNumQuestion = totalNumQuestion;
	}

	public Integer getNumEasy() {
		return numEasy;
	}

	public void setNumEasy(Integer numEasy) {
		this.numEasy = numEasy;
	}

	public Integer getNumMedium() {
		return numMedium;
	}

	public void setNumMedium(Integer numMedium) {
		this.numMedium = numMedium;
	}

	public Integer getNumDiff() {
		return numDiff;
	}

	public void setNumDiff(Integer numDiff) {
		this.numDiff = numDiff;
	}

	public Integer getNumVeryDiff() {
		return numVeryDiff;
	}

	public void setNumVeryDiff(Integer numVeryDiff) {
		this.numVeryDiff = numVeryDiff;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public HashMap<String, Integer> getChapters() {
		return chapters;
	}

	public void setChapters(HashMap<String, Integer> chapters) {
		this.chapters = chapters;
	}

	public String getWEBSITE() {
		return WEBSITE;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getArrQuestionFile() {
		return arrQuestionFile;
	}

	public void setArrQuestionFile(List<String> arrQuestionFile) {
		this.arrQuestionFile = arrQuestionFile;
	}

	public List<String> getArrQuestionFullFile() {
		return arrQuestionFullFile;
	}

	public void setArrQuestionFullFile(List<String> arrQuestionFullFile) {
		this.arrQuestionFullFile = arrQuestionFullFile;
	}

}
