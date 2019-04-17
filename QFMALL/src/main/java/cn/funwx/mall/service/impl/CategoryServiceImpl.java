package cn.funwx.mall.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.funwx.mall.dao.CategoryDao;
import cn.funwx.mall.pojo.Category;
import cn.funwx.mall.service.CategoryService;

/**
 * @author liu66
 * 
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginServiceImpl.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	public List<Category> findCategory() {
		int pid=0;
		List<Category>list=categoryDao.findCategory(pid);
		for (Category category : list) {
			if(category.getHasChild()==1){
				List<Category>child=categoryDao.findCategory(category.getId());
				category.setChild(child);
			}
		}
		return list;
	}

}
