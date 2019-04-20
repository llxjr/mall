package cn.funwx.mall.service;

import java.util.List;

import cn.funwx.mall.dto.GoodsDTO;
import cn.funwx.mall.pojo.Goods;

public interface GoodsService {

	public List<GoodsDTO> findAllGoods();
	
	public void addGoods(Goods goods);
	
	public void deleteGoods(int id);
}
