package cn.jijiking.mybatisplus.dao;

import cn.jijiking.mybatisplus.bean.Book;
import cn.jijiking.mybatisplus.bean.PageResult;
import cn.jijiking.mybatisplus.mapper.BookMapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class BookDao {

    @Autowired
    private BookMapper bookMapper ;

    public List<Book> getAll(){
        return bookMapper.selectList(null);
    }



    public Integer insert(Book book){
        bookMapper.insert(book);
        return book.getId();
    }

    public Book findById(int id){
        //hashMap存储的是需要查询的条件
        HashMap hashMap = new HashMap();
        bookMapper.selectByMap(hashMap);
        ArrayList arrayList = new ArrayList();
        bookMapper.selectBatchIds(arrayList);
        return bookMapper.selectById(id);
    }

    public Integer updateByWrapper(){
        Book book = new Book();
        book.setName("java疯狂");
        int i = bookMapper.update(book, new UpdateWrapper<Book>().like("name", "java"));
        return i;
    }

    public PageResult<Book> getByPage(int row, int pageSize){
        Page<Book> page = new Page<Book>();
        page.setSize(pageSize);
        page.setPages(row);
        IPage<Book> bookIPage = bookMapper.selectPage(page, null);
        PageResult<Book> result = new PageResult<>();
        result.setPageSize(bookIPage.getSize());
        result.setRow(bookIPage.getCurrent());
        result.setTatolSize(bookIPage.getTotal());
        result.setPageContext(bookIPage.getRecords());
        return result;
    }


    public int deleteById(int id){
        return  bookMapper.deleteById(id);
    }


    public int deleteAll(){

        return bookMapper.delete(null);
    }


}
