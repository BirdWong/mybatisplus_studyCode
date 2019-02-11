package cn.jijiking.mybatisplus.bean;

import lombok.Data;

import java.util.List;


@Data
public class PageResult<T> {
    //总记录数
    private Long tatolSize;
    //当前页码
    private Long row;
    //页面内容个数
    private Long pageSize;
    //页面内容
    private List<T> pageContext;


}
