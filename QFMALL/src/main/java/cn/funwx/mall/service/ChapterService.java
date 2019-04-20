package cn.funwx.mall.service;

import java.util.List;
import java.util.Map;

import cn.funwx.mall.pojo.Chapter;

/**
 * @author liu66
 * 
 */
public interface ChapterService {

    
    /**
     * @param map
     * @return
     */
   public List<Chapter> findChapter(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalChapter(Map<String, Object> map);
  
    /**
     * 根据id获取章节
     * @param uuid
     * @return
     */
    public Chapter findById(Integer id);
    
    /**
     * 根据课程id查找
     * @param courseId
     * @return
     */
    public List<Chapter> findByCourseId(int courseId);
    
    /**
     * 查询全部
     * @return
     */
    List<Chapter>findAllChapter();
}
