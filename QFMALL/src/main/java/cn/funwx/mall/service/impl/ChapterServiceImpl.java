package cn.funwx.mall.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.funwx.mall.dao.ChapterDao;
import cn.funwx.mall.pojo.Chapter;
import cn.funwx.mall.service.ChapterService;


@Service
public class ChapterServiceImpl implements ChapterService {
	
	@Autowired
	private ChapterDao chapterDao;
	

	public List<Chapter> findAllChapter() {
		return chapterDao.findAllChapter();
	}
	
	public List<Chapter> findChapter(Map<String, Object> map) {
		return null;
	}

	public Long getTotalChapter(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public Chapter findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Chapter> findByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}


}
