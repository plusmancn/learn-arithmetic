package cn.plusman.mybatis;

import cn.plusman.mybatis.entity.Blog;
import cn.plusman.mybatis.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * PACKAGE_NAME
 *
 * @author plusman
 * @since 12/16/20
 */
public class ApplicationBoot {
    public static void main(String[] args) {
        String resource = "mybatis/mybatis-config.xml";
        try {
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

            try (SqlSession session = sqlSessionFactory.openSession()) {
                // Blog blog = session.selectOne("cn.plusman.mybatis.mapper.BlogMapper.selectBlog", 1);
                Blog blog1 = session.getMapper(BlogMapper.class).selectBlog(1);
                // Blog blognull = session.getMapper(BlogMapper.class).selectBlog();
                System.out.println("Blog1: " + blog1);
                // System.out.println("Blognull: " + blognull);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
