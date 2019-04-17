package cn.funwx.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.funwx.mall.dao.CourseDao;
import cn.funwx.mall.pojo.Course;
import cn.funwx.mall.service.CourseService;

/**
 * @author liu66 
 * 
 */
@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

	public List<Course> findByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
