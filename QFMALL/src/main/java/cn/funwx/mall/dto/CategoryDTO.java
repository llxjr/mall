package cn.funwx.mall.dto;

import java.util.List;

import cn.funwx.mall.pojo.Category;
import cn.funwx.mall.pojo.Course;

/**
 * @author liu66
 * @description 类目
 * 
 */
public class CategoryDTO extends Category{
	private List<CourseDTO> courseDTOs;

	public List<CourseDTO> getCourseDTOs() {
		return courseDTOs;
	}

	public void setCourseDTOs(List<CourseDTO> courseDTOs) {
		this.courseDTOs = courseDTOs;
	}
	
	
}
