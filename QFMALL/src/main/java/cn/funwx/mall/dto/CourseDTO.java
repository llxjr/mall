package cn.funwx.mall.dto;

import java.util.List;

import cn.funwx.mall.pojo.Category;
import cn.funwx.mall.pojo.Chapter;
import cn.funwx.mall.pojo.Course;

/**
 * @author liu66
 * @description 课程
 * 
 */
public class CourseDTO  extends Course{
    /**
     * 课程类目
     */
    private Category category;
    /** 章节 */
    private List<Chapter> chapters;
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
    
    
}
