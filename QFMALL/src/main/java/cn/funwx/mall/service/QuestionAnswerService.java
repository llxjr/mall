package cn.funwx.mall.service;

import java.util.List;
import java.util.Map;

import cn.funwx.mall.dto.QuestionAnswerDTO;
import cn.funwx.mall.pojo.QuestionAnswer;

public interface QuestionAnswerService {

public List<QuestionAnswerDTO> findQuestionAnswer (Map<String, Object> map);
	
	public int addqa(QuestionAnswer questionanswer);
	
	public int updateQuestionAnswer(QuestionAnswer questionanswer);
	
	public int deleteQuestionAnswer(int id);
	
	public QuestionAnswer findQuestionAnswerById(int id);
	
	public Long getTotalUser(Map<String, Object> map);
	
	public List<QuestionAnswer> findByQuestionId(int questionId);
}
