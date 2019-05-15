package cn.funwx.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.funwx.mall.dao.MyGoodsDao;
import cn.funwx.mall.pojo.MyGoods;
import cn.funwx.mall.service.MyGoodsService;

@Service
public class MyGoodsServiceImpl implements MyGoodsService {

	@Autowired
	private MyGoodsDao myGoodsDao;
	
	public List<MyGoods> findAllMyGoods(String uuid) {
		return myGoodsDao.findAllMyGoods(uuid);
	}

	public void addMyGoods(MyGoods myGoods) {
		myGoodsDao.addMyGoods(myGoods);
	}

}
