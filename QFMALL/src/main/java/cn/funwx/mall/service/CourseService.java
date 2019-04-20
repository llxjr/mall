package cn.funwx.mall.service;

import java.util.List;

import cn.funwx.mall.dto.CategoryDTO;
import cn.funwx.mall.pojo.Course;

/**
 * @author liu66
 * 
 */
public interface CourseService {
	
	public List<Course>findByCategoryId(int categoryId);
	
	public List<Course> getAllCourse();
	
	public Course findCourseById(int id);
	
	public List<CategoryDTO> courseList();
}
