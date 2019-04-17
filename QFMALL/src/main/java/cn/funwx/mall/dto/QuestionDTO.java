package cn.funwx.mall.dto;

import java.util.List;

/**
 * @author liu66
 * 
 */
public class QuestionDTO {

	/** 题目ID */
	private int id;
	/** 题目类别 1基础题库题目，2强化题库题目，99试卷题目*/
	private int type;
	/** 所属上级ID 例如：基础/强化题目上级为 章节（chapterId）；试卷（paperId） */
	private int chapterId;
	/**题目类型*/
	private String questionTypeName;
	/**题干*/
	private String stem;
	/**解析*/
	private String analysis;
	/**分值*/
	private int value;
	/**答案列表*/
	private List<QuestionAnswerDTO> answerList;
	//-----共题干题-------
	/**题目集合**/
	private List<QuestionDTO> questionList;
	//-----判断题--------
	/**对错*/
	private boolean correct;
	//-----视图详情数据-----
	/**答题数*/
	private long answerNum;
	/**正确数*/
	private long correctNum;
	/**正确率*/
	private String correctRate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getChapterId() {
		return chapterId;
	}
	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}
	public String getQuestionTypeName() {
		return questionTypeName;
	}
	public void setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
	}
	public String getStem() {
		return stem;
	}
	public void setStem(String stem) {
		this.stem = stem;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public List<QuestionAnswerDTO> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<QuestionAnswerDTO> answerList) {
		this.answerList = answerList;
	}
	public List<QuestionDTO> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<QuestionDTO> questionList) {
		this.questionList = questionList;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public long getAnswerNum() {
		return answerNum;
	}
	public void setAnswerNum(long answerNum) {
		this.answerNum = answerNum;
	}
	public long getCorrectNum() {
		return correctNum;
	}
	public void setCorrectNum(long correctNum) {
		this.correctNum = correctNum;
	}
	public String getCorrectRate() {
		return correctRate;
	}
	public void setCorrectRate(String correctRate) {
		this.correctRate = correctRate;
	}
}
