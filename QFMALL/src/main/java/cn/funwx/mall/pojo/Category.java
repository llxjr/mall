package cn.funwx.mall.pojo;

import java.util.List;

import cn.funwx.mall.pojo.base.BaseEntity;

/**
 * 
 * @author llz
 *
 */
public class Category extends BaseEntity{
	private String categoryName;
	private String description;
	private int parentId;
	private int hasChild;
	private String tag;
	private int level;
	private int isDel;
	private List<Category>child;
	
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public List<Category> getChild() {
		return child;
	}
	public void setChild(List<Category> child) {
		this.child = child;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getHasChild() {
		return hasChild;
	}
	public void setHasChild(int hasChild) {
		this.hasChild = hasChild;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", description=" + description + ", parentId=" + parentId
				+ ", hasChild=" + hasChild + ", tag=" + tag + ", level=" + level + ", isDel=" + isDel + ", child="
				+ child + "]";
	}
	
	
}
