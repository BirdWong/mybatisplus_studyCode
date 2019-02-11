package cn.jijiking.mybatisplus.mapper;

import cn.jijiking.mybatisplus.bean.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BookMapper extends BaseMapper<Book> {
    /*
     * 传统Mybatis中： Integer insertBook(Book book);
     * 使用useGeneratedkeys开启获取id返回值， keyproperty设置返回哪个属性的返回值
     * <insert useGeneratedkeys="true" keyProperty="id">Sql..</>
     *
     * MybayisPlus 会自动的将自增id填充到插入的对象中，通过getId方法就可以获取到
     */
}
