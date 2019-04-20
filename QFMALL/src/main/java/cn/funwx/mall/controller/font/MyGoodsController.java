package cn.funwx.mall.controller.font;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.funwx.mall.common.Constants;
import cn.funwx.mall.dto.GoodsDTO;
import cn.funwx.mall.pojo.Course;
import cn.funwx.mall.pojo.Goods;
import cn.funwx.mall.pojo.MyGoods;
import cn.funwx.mall.pojo.User;
import cn.funwx.mall.service.CourseService;
import cn.funwx.mall.service.MyGoodsService;
import cn.funwx.mall.utils.Result;

@RequestMapping("/mygoods")
@Controller
public class MyGoodsController {
	
	
	@Autowired
	private MyGoodsService myGoodsService;
	
	@Autowired
	private CourseService courseService;
	
	 @RequestMapping("/findAllGoods")
	 public Result indexPage(HttpServletRequest request) {
		 User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
		 if(user == null){
			 return Result.err();
		 }
		 List<MyGoods> mygoods = myGoodsService.findAllMyGoods();
		 request.getSession().setAttribute("goods", mygoods);
		 return Result.suc();
	 }
	
	 @RequestMapping(value = "/addGoods/{id}", method = { RequestMethod.POST })
	 public Result addGoods(@PathVariable Integer id, HttpServletRequest request){
		 System.out.println("addgoods~~~~~~~~~");
		 User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
		 Course course = courseService.findCourseById(id);
		 MyGoods myGoods = new MyGoods();
		 myGoods.setUuid(user.getUuid());
		 myGoods.setCourseId(id);
		 myGoods.setGoodsPrice(course.getPrice());
		 myGoods.setGoodsName(course.getCourseName());
		 myGoods.setCategoryId(course.getCategoryId());
		 myGoods.setGoodsImg(course.getCourseImg());
		 myGoods.setDescribe(course.getDescription());
		 myGoodsService.addMyGoods(myGoods);
		 return Result.suc();
	 }
}
