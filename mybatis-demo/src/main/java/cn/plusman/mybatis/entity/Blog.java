package cn.plusman.mybatis.entity;

/**
 * cn.plusman.mybatis.entity
 *
 * @author plusman
 * @since 12/17/20
 */
public class Blog {
    private Integer id;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
            "id=" + id +
            ", content='" + content + '\'' +
            '}';
    }
}
