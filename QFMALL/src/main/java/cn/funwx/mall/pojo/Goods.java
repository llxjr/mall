package cn.funwx.mall.pojo;

import cn.funwx.mall.pojo.base.BaseEntity;

public class Goods  extends BaseEntity{
	
	private  int categoryId;
	private int courseId;
	private String goodsName;
	private String goodsNo;
	private Double goodsPrice;
	private  int isNotEntity;
	private  int isBlank;
	private  int isDel;
	private String  describe;
	private String goodsImg;
	private String detail;
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
	public int getIsNotEntity() {
		return isNotEntity;
	}
	public void setIsNotEntity(int isNotEntity) {
		this.isNotEntity = isNotEntity;
	}
	public int getIsBlank() {
		return isBlank;
	}
	public void setIsBlank(int isBlank) {
		this.isBlank = isBlank;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
