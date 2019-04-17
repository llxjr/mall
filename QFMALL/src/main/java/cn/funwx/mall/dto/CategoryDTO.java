package cn.funwx.mall.dto;

import java.util.List;

/**
 * @author liu66
 * @description 类目
 * 
 */
public class CategoryDTO {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 类型名称
     */
    private String categoryName;
    /**
     * 父ID 没有默认为0
     */
    private Integer parentId;
    /**
     * 是否有子类 有为1没有为0
     */
    private Integer hasChild;
    /**
     * 唯一区别标识
     */
    private String tag;
    /**
     * 类目级别 最多3级 根为1
     */
    private Integer level;

    private List<CategoryDTO> childDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getHasChild() {
        return hasChild;
    }

    public void setHasChild(Integer hasChild) {
        this.hasChild = hasChild;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<CategoryDTO> getChildDto() {
        return childDto;
    }

    public void setChildDto(List<CategoryDTO> childDto) {
        this.childDto = childDto;
    }
}
