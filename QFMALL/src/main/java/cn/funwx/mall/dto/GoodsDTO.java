package cn.funwx.mall.dto;

import cn.funwx.mall.pojo.Course;
import cn.funwx.mall.pojo.Goods;

public class GoodsDTO extends Goods{
	private Course course;
	private CourseDTO courseDTO;
	

	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public CourseDTO getCourseDTO() {
		return courseDTO;
	}
	public void setCourseDTO(CourseDTO courseDTO) {
		this.courseDTO = courseDTO;
	}
	
}
