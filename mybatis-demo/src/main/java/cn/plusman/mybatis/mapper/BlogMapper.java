package cn.plusman.mybatis.mapper;

import cn.plusman.mybatis.entity.Blog;

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
    Blog selectBlog(int id);
}
