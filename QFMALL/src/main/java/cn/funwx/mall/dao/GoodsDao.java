package cn.funwx.mall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.funwx.mall.pojo.Goods;
/**
 * @author liu66
 * 
 */
@Repository
public interface GoodsDao {
	
	public List<Goods> findAllGoods();
	
	public void addGoods(Goods goods);
	
	public void deleteGoods(int id);
	
}
