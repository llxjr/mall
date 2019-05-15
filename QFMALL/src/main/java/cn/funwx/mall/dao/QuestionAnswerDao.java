package cn.funwx.mall.dao;

import java.util.List;
import java.util.Map;

import cn.funwx.mall.pojo.QuestionAnswer;


public interface QuestionAnswerDao {
	public List<QuestionAnswer> findQuestionAnswer (Map<String, Object> map);
	
	public int addQuestionAnswer(QuestionAnswer questionanswer);
	
	public int updateQuestionAnswer(QuestionAnswer questionanswer);
	
	public int deleteQuestionAnswer(int id);
	
	public QuestionAnswer findQuestionAnswerById(int id);
	
	public Long getTotalUser(Map<String, Object> map);
	
	public List<QuestionAnswer> findByQuestionId(int questionId);
}
