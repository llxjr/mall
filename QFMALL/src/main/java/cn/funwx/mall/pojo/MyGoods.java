package cn.funwx.mall.pojo;

import cn.funwx.mall.pojo.base.BaseEntity;

public class MyGoods extends BaseEntity{
	
	private String uuid;
	private  int categoryId;
	private int courseId;
	private String goodsName;
	private String goodsNo;
	private Double goodsPrice;
	private String  describe;
	private String goodsImg;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	@Override
	public String toString() {
		return "MyGoods [uuid=" + uuid + ", categoryId=" + categoryId + ", courseId=" + courseId + ", goodsName="
				+ goodsName + ", goodsNo=" + goodsNo + ", goodsPrice=" + goodsPrice + ", describe=" + describe
				+ ", goodsImg=" + goodsImg + "]";
	}
	
}
