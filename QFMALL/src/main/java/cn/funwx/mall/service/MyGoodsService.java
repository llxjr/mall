package cn.funwx.mall.service;

import java.util.List;

import cn.funwx.mall.pojo.MyGoods;

public interface MyGoodsService {
	
	public List<MyGoods> findAllMyGoods(String uuid);
	public void addMyGoods(MyGoods myGoods);
}
