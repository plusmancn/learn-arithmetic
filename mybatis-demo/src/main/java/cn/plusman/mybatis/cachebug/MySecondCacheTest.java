/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.mybatis.cachebug;

import cn.plusman.mybatis.entity.Blog;
import cn.plusman.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author plusman
 * @since 2021/3/13 3:05 PM
 */
public class MySecondCacheTest {
    public static void main(String[] args) {
        String resource = "mybatis/mybatis-config.xml";
        try {
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
    
    
            SqlSession s1 = sqlSessionFactory.openSession();
            s1.getMapper(UserMapper.class).selectByid3(2);
            s1.commit();
    
            s1.getMapper(UserMapper.class).selectByid3(2);
            s1.commit();
    
            SqlSession s2 = sqlSessionFactory.openSession();
            s2.getMapper(UserMapper.class).selectByid3(2);
            s2.commit();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
