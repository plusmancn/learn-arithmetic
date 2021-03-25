package cn.plusman.mybatis.mapper;

import cn.plusman.mybatis.entity.Blog;
import cn.plusman.mybatis.plugin.pagedir.IPage;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * cn.plusman.mybatis.mapper
 *
 * @author plusman
 * @since 12/17/20
 */
public interface BlogMapper {
    /**
     * 根据 id 获取博客内容
     * @param id
     * @return
     */
    Blog selectBlog(
        int id
    );
    
    /**
     * 获取博客列表
     * @return
     */
    List<Blog> selectBlogList(
        @Param("page") IPage<Blog> page
    );
    
    /**
     * @param rowBounds
     * @return
     */
    List<Blog> seleceBlogByPageHelper(
        PageRowBounds rowBounds
    );
    
    /**
     * default method
     * @return
     */
    default Blog selectBlog() {
        return this.selectBlog(12);
        // return new Blog()
        //     .setBlogId(12)
        //     .setContent("hello world");
    }
}
