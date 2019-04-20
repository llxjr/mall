package cn.funwx.mall.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.funwx.mall.pojo.Chapter;

/**
 * @author liu66
 * 
 */
@Repository
public interface ChapterDao {

    /**
     * 查找Chapter列表
     *
     * @param map
     * @return
     */
    public List<Chapter> findChapter(Map<String, Object> map);
    
    public List<Chapter> findChapterByCourseName(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalChapter(Map<String, Object> map);

    /**
     * 实体修改
     *
     * @param Chapter
     * @return
     */
    public int updateChapter(Chapter chapter);


    public int addChapter(Chapter chapter);

    public int deleteChapter(Integer id);
    

    Chapter getChapterByName(String paperName);
 
    public Chapter findById(Integer id);
   
    
    public List<Chapter> findByCourseId(int courseId);
    
    /**
     * 查询全部
     * @return
     */
    List<Chapter> findAllChapter();
    
}
