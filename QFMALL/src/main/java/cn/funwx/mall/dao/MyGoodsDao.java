package cn.funwx.mall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.funwx.mall.pojo.MyGoods;

@Repository
public interface MyGoodsDao {
	
	public List<MyGoods> findAllMyGoods(String uuid);
	public void addMyGoods(MyGoods myGoods);
	
}
