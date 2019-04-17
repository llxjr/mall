package cn.funwx.mall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.funwx.mall.pojo.Category;

/**
 * @author liu66
 * 
 */
@Repository
public interface CategoryDao {
	
	public List<Category>findCategory(int pid);

}
