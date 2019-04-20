package cn.funwx.mall.controller.font;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.funwx.mall.dto.CategoryDTO;
import cn.funwx.mall.service.CategoryService;
import cn.funwx.mall.service.CourseService;
import cn.funwx.mall.utils.Result;

/**
 * @author liu66 
 * 
 */
@RequestMapping("/course")
@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService; 
	
	@RequestMapping("/courselist")
	public Result courseList(HttpServletRequest request){
		System.out.println("test!! courseList");
		List<CategoryDTO> categoryDTOs = courseService.courseList();
    	request.getSession().setAttribute("categoryDTOs", categoryDTOs);
        return Result.suc();
	}
	
}
