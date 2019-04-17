package cn.funwx.mall.controller.font;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.funwx.mall.pojo.Category;
import cn.funwx.mall.service.CategoryService;
import cn.funwx.mall.utils.Result;

/**
 * @author liu66
 * 
 */
@RequestMapping("/category")
@Controller
public class CategoryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	private static final String HEAD_PAGE = "/common/head";
	
    @RequestMapping("/head")
    public Result indexPage(HttpServletRequest request) {
    	List<Category>list=categoryService.findCategory();
    	System.out.println("categoryList:"+list);
    	request.getSession().setAttribute("categoryList", list);
        return Result.suc();
    }
	
}
