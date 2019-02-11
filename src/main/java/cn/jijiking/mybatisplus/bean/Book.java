package cn.jijiking.mybatisplus.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName： 表名映射
 */
@Data
@TableName(value = "book")
public class Book implements Serializable{
    /*
     * @TableId:
     *      value： 指定表中的主键列的列名，如果实体属性名和列名一致， 可以不指定
     *      type： 指定主键策略
     */
    @TableId(value = "id" ,type = IdType.AUTO)
    int id ;
    /*
     * @TableField:
     *      value: 指定表中对应的字段名称
     *      exist: 设定数据库属性中是否有对应的字段名，默认位true
     */
    @TableField(value = "name")
    String name;
    @TableField(exist = false)
    String Descript;

    /*
     * 如果要使用乐观锁，则需要配置这个属性，并且加上注解
     * 乐观锁原理：
     *  使用版本号时，可以在数据初始化时指定一个版本号，每次对数据的更新操作都对版本号执行+1操作。
     *  并判断当前版本号是不是该数据的最新的版本号。
     *
     *  数据库表中也要有这个属性
     */
    @Version
    private Integer version;
}
