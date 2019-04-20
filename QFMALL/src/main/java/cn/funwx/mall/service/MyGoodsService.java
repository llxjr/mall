package cn.funwx.mall.service;

import java.util.List;

import cn.funwx.mall.pojo.MyGoods;

public interface MyGoodsService {
	
	public List<MyGoods> findAllMyGoods();
	public void addMyGoods(MyGoods myGoods);
}
