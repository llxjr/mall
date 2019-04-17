package cn.funwx.mall.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用分页工具
 * @author Administrator
 *
 * @param <T>
 */
public class Page<T> {  
    private int pageSize=3;           	//页大小  
    private int pageNum=1;           	//当前页号  1为起始页
    private int totalPageCount=0;     	//总页数  
    private int total=0;             	//记录总数  
    private Integer nextPage;          	//下一页  
    private Integer prePage;           	//上一页  
    private List<T> list=new ArrayList<T>();     //房屋信息的集合  
      
      

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	} 
  
    //得到开始记录数  
    public int getSartRow(){  
        return (pageNum-1)*pageSize;  
    }  
      
    //得到结束记录数  
    public int getEndRow(){  
        return pageSize;  
    }  
  
    public int getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
  
    public int getPageNum() {  
        return pageNum;  
    }  
  
    //得到当前页  
    public void setPageNum(int pageNum) {  
        this.pageNum = pageNum;  
        //下一页  
        setNextPage();  
        //上一页  
        setPrePage();  
    }  
  
    public int getTotalPageCount() {  
        return totalPageCount;  
    }  
  
    //总页数  
    public void setTotalPageCount() {  
        int totalP = total % getPageSize() == 0 ? total / getPageSize() :  
        	total/ getPageSize() + 1;  
        this.totalPageCount = totalP;  
    }  
  
    public int getTotal() {  
        return total;  
    }  
      
    //总记录数  
    public void setTotal(int total) {  
        this.total = total;  
        //设置总页数  
        setTotalPageCount();  
    }  
  
    public Integer getNextPage() {  
        return nextPage;  
    }  
  
    //设置下一页  
    public void setNextPage() {  
        this.nextPage = this.pageNum+1;  
          
    }  
  
    public Integer getPrePage() {  
        return prePage;  
    }  
  
    //设置上一页  
    public void setPrePage() {  
        this.prePage =this.pageNum-1;  
        if(this.prePage<1){  
            this.prePage=1;  
        }  
    }
  
}  