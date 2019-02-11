package cn.jijiking.mybatisplus;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * 使用前的查询语句：
 * 2019-02-10T13:04:32.689664Z	   48 Prepare	SELECT  id,name  FROM book
 * 2019-02-10T13:04:32.717945Z	   48 Execute	SELECT  id,name  FROM book
 *
 * 使用后的查询语句：
 * 2019-02-10T13:00:57.442717Z	   44 Prepare	SELECT  id,name  FROM book LIMIT ?,?
 * 2019-02-10T13:00:57.476711Z	   44 Execute	SELECT  id,name  FROM book LIMIT 0,3
 */
@EnableTransactionManagement
@Configuration
@MapperScan("cn.jijiking.mybatisplus.templates.mapper")
public class MybatisPlusConfig {

    /*
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return  new PaginationInterceptor();
    }

    /*
     * 性能分析插件
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        /*
         * 参数：maxTime SQL 执行最大时长，超过自动停止运行，有助于发现问题。
         * 参数：format SQL SQL是否格式化，默认false。
         * 该插件只用于开发环境，不建议生产环境使用。
         */
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(1000000);
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
     *
     * 执行拦截操作
     *
     * *******与前面两个冲突，开发环境都用不了********
     * 自己多注意
     * 报错： There is no getter for property named 'delegate' in 'class com.sun.prox
     */
//    @Bean
//    public SqlExplainInterceptor sqlExplainInterceptor(){
//
//        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
//        List<ISqlParser> sqlParserList = new ArrayList<>();
//        sqlParserList.add(new BlockAttackSqlParser());
//        sqlExplainInterceptor.setSqlParserList(sqlParserList);
//        return sqlExplainInterceptor;
//    }



    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
}
