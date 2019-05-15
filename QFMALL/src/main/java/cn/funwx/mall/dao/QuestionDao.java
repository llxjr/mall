package cn.funwx.mall.dao;

import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Repository;

import cn.funwx.mall.pojo.Question;

/**
 * @author liu66
 * 
 */
@Repository
public interface QuestionDao {

   

    /**
     * 获取所有题目
     *
     * @param map
     * @return
     */
    public List<Question> findQuestion(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalQuestion(Map<String, Object> map);

    /**
     * 实体修改
     *
     * @param Question
     * @return
     */
    public int updateQuestion(Question question);

    /**
     * 添加题目
     *
     * @param Question
     * @return
     */
    public int addQuestion(Question question);

    /**
     * 删除题目
     *
     * @param id
     * @return
     */
    public int deleteQuestion(Integer id);
    
    /**
     * 
     * @param Question
     * @return
     */
  
    
    /**
     * 根据id获取问题
     * @param uuid
     * @return
     */
    Question findById(Integer id);
    
    /**
     * 查询全部
     * @return
     */
	public List<Question> findAllQuestion();
    
   
}
