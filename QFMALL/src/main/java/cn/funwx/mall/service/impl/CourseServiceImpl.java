package cn.funwx.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.funwx.mall.dao.CategoryDao;
import cn.funwx.mall.dao.ChapterDao;
import cn.funwx.mall.dao.CourseDao;
import cn.funwx.mall.dto.CategoryDTO;
import cn.funwx.mall.dto.CourseDTO;
import cn.funwx.mall.pojo.Category;
import cn.funwx.mall.pojo.Chapter;
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
	
	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ChapterDao chapterDao;
	
	public List<Course> findByCategoryId(int categoryId) {
		return courseDao.findByCategoryId(categoryId);
	}

	public List<Course> getAllCourse() {
		return courseDao.getAllCourse();
	}

	public List<CategoryDTO> courseList() {
		// 目录包含课程list，课程包含章节list
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		// 获取全部类目
		List<Category> categories = categoryDao.findAllCategory();
		if (categories != null && categories.size() > 0) {
			for (Category category : categories) {
				// 根据目录id找课程    courseList
				List<Course> courses = courseDao.findByCategoryId(category.getId());
				if (courses != null && courses.size() > 0) {
					// 定义课程DTO，courseDTO包含章节list
					List<CourseDTO> courseDTOs = new ArrayList<CourseDTO>();
					for (Course course : courses) {
						// 根据课程id找章节   chapterList
						List<Chapter> chapters = chapterDao.findByCourseId(course.getId());
						// 初始化课程DTO， 将章节放入CourseDTO
						CourseDTO courseDTO = new CourseDTO();
						courseDTO.setId(course.getId());
						courseDTO.setCourseName(course.getCourseName());
						courseDTO.setDescription(course.getDescription());
						courseDTO.setCourseImg(course.getCourseImg());
						courseDTO.setPrice(course.getPrice());
						if (chapters != null && chapters.size() > 0) {
							// 将章节list放入courseDTO
							courseDTO.setChapters(chapters);
						}
						courseDTOs.add(courseDTO);
					}
					// 初始化类目DTO
					CategoryDTO categoryDTO = new CategoryDTO();
					categoryDTO.setId(category.getId());
					categoryDTO.setCategoryName(category.getCategoryName());
					categoryDTO.setDescription(category.getDescription());
					categoryDTO.setParentId(category.getParentId());
					// 将课程DTO放入类目DTO
					categoryDTO.setCourseDTOs(courseDTOs);
					categoryDTOs.add(categoryDTO);
				}
			}
		}
		return categoryDTOs;
	}

	public Course findCourseById(int id) {
		return courseDao.findCourseById(id);
	}

}
