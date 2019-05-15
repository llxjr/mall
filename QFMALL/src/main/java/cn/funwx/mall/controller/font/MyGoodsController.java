package cn.funwx.mall.controller.font;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.funwx.mall.common.Constants;
import cn.funwx.mall.common.ResultGenerator;
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
	 @ResponseBody
	 public Result indexPage(HttpServletRequest request) {
		 request.getSession().removeAttribute("mygoods");
		 User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
		 if(user == null){
             return ResultGenerator.genFailResult("亲!您还没有登录~");
		 }
		 List<MyGoods> mygoods = myGoodsService.findAllMyGoods(user.getUuid());
		 request.getSession().setAttribute("mygoods", mygoods);
		 return ResultGenerator.genSuccessResult();	
	 }
	
	 @RequestMapping(value = "/addGoods/{id}", method = { RequestMethod.POST })
	 @ResponseBody
	 public Result addGoods(@PathVariable Integer id, HttpServletRequest request){
		 User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
		 if(user == null){
             return ResultGenerator.genFailResult("亲!您还没有登录~");
		 }
		 List<MyGoods> mygoodsList = myGoodsService.findAllMyGoods(user.getUuid());
		 if (mygoodsList != null && mygoodsList.size() > 0) {
			for(MyGoods myGoods : mygoodsList){
				if (myGoods.getCourseId() == id) {
					return ResultGenerator.genFailResult("该课程已购买");
				}
			}
		}
		 Course course = courseService.findCourseById(id);
		 MyGoods myGoods = new MyGoods();
		 myGoods.setUuid(user.getUuid());
		 myGoods.setCourseId(id);
		 myGoods.setGoodsPrice(course.getPrice());
		 myGoods.setGoodsName(course.getCourseName());
		 myGoods.setCategoryId(course.getCategoryId());
		 myGoods.setGoodsImg(course.getCourseImg());
		 myGoods.setDescription(course.getDescription());
		 myGoodsService.addMyGoods(myGoods);
		 return ResultGenerator.genSuccessResult();	
	 }
	 
	 
}
