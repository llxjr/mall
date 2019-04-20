package cn.funwx.mall.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.funwx.mall.dao.ChapterDao;
import cn.funwx.mall.dao.CourseDao;
import cn.funwx.mall.dao.GoodsDao;
import cn.funwx.mall.dto.CourseDTO;
import cn.funwx.mall.dto.GoodsDTO;
import cn.funwx.mall.pojo.Chapter;
import cn.funwx.mall.pojo.Course;
import cn.funwx.mall.pojo.Goods;
import cn.funwx.mall.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private ChapterDao chapterDao;
	@Autowired
	private CourseDao courseDao;
	
	public List<GoodsDTO> findAllGoods() {
		List<GoodsDTO> goodsDTOs = new ArrayList<GoodsDTO>();
		List<Goods> goods = goodsDao.findAllGoods();
		List<CourseDTO> courseDTOs = new ArrayList<CourseDTO>();
		for (Goods good : goods) {
			GoodsDTO goodsDTO = new GoodsDTO();
			Course course = courseDao.findCourseById(good.getCourseId());
			List<Chapter> chapters = chapterDao.findByCourseId(course.getId());
			// 初始化课程DTO， 将章节放入CourseDTO
			CourseDTO courseDTO = new CourseDTO();
			courseDTO.setId(course.getId());
			courseDTO.setCourseName(course.getCourseName());
			courseDTO.setDescription(course.getDescription());
			courseDTO.setCourseImg(course.getCourseImg());
			if (chapters != null && chapters.size() > 0) {
				// 将章节list放入courseDTO
				courseDTO.setChapters(chapters);
			}
			goodsDTO.setId(good.getId());
			goodsDTO.setCourseId(good.getCourseId());
			goodsDTO.setCourseDTO(courseDTO);
			goodsDTOs.add(goodsDTO);
		}
		return goodsDTOs;
	}

	public void addGoods(Goods goods) {
		
		goodsDao.addGoods(goods);
	}

	public void deleteGoods(int id) {
		goodsDao.deleteGoods(id);
	}

}
