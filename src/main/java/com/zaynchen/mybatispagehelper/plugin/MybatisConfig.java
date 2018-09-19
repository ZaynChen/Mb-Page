package com.zaynchen.mybatispagehelper.plugin;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MybatisConfig {

    @Autowired
    public MybatisConfig(SqlSession sqlSession) {
        System.out.println("sqlsessionfactorybean test");
        Interceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("dialect", MySqlDialect.class.getName());
        pageInterceptor.setProperties(properties);
        sqlSession.getConfiguration().addInterceptor(pageInterceptor);
    }
}
