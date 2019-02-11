package cn.jijiking.mybatisplus.controller;


import cn.jijiking.mybatisplus.bean.Book;
import cn.jijiking.mybatisplus.bean.PageResult;
import cn.jijiking.mybatisplus.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDao bookDao ;


    @RequestMapping(value = "/findall",method = RequestMethod.GET)
    public List<Book> getAll(){
        return bookDao.getAll();
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public Book findById(@PathVariable("id") int id){
        return  bookDao.findById(id);
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public Integer insert(@RequestBody Book book){
        try {
            return bookDao.insert(book);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }



    @RequestMapping(value = "/update")
    public Integer updateByWrapper(){
        return bookDao.updateByWrapper();
    }

    @RequestMapping(value = "getpage/{row}/{size}")
    public PageResult<Book> getByPage(@PathVariable("row")int row, @PathVariable("size") int pagesize){
        return bookDao.getByPage(row, pagesize);
    }



    @RequestMapping(value = "deleteall", method = RequestMethod.GET)
    public Integer deleteAll(){
        return bookDao.deleteAll();
    }



    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Integer deleteById(@PathVariable("id") int id){
        return bookDao.deleteById(id);
    }
}
