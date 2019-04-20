package cn.funwx.mall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.funwx.mall.pojo.Course;

/**
 * @author liu66
 * 
 */
@Repository
public interface CourseDao {
	
	public List<Course>findByCategoryId(int categoryId);
	public List<Course> getAllCourse();
	public Course findCourseById(int id);
}
