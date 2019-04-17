package cn.funwx.mall.dto;

import cn.funwx.mall.pojo.Category;

/**
 * @author liu66
 * @description 课程
 * 
 */
public class CourseDTO {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 描述
     */
    private String description;
    /**
     * 课程类目
     */
    private Category category;
    /**
     * 课程标签
     */
    private String tag;
    /**
     * 是否启用试卷
     */
    private int isNotPaper;

    
}
