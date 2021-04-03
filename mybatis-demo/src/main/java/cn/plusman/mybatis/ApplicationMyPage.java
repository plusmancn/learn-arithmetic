package cn.plusman.mybatis;

import cn.plusman.mybatis.entity.Blog;
import cn.plusman.mybatis.mapper.BlogMapper;
import cn.plusman.mybatis.plugin.pagedir.IPage;
import cn.plusman.mybatis.plugin.pagedir.Page;
import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author plusman
 * @since 2021/3/22 11:26 PM
 */
public class ApplicationMyPage {
    public static void main(String[] args) {
        sessionDevelopment();
        // sessionAnother();
    }
    
    public static void sessionDevelopment() {
        String resource = "mybatis/mybatis-config-mypage.xml";
        try {
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        
            try (SqlSession session = sqlSessionFactory.openSession()) {
                IPage<Blog> page = new Page<>(1, 2);
            
                List<Blog> list = session.getMapper(BlogMapper.class).selectBlogList(page);
                System.out.println(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void sessionAnother() {
        String resource = "mybatis/mybatis-config-mypage.xml";
        try {
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream, "another");
        
            try (SqlSession session = sqlSessionFactory.openSession()) {
                IPage<Blog> page = new Page<>(1, 2);
            
                List<Blog> list = session.getMapper(BlogMapper.class).selectBlogList(page);
                System.out.println(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


