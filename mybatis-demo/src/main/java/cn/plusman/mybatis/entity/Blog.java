package cn.plusman.mybatis.entity;

import lombok.Data;

/**
 * cn.plusman.mybatis.entity
 *
 * @author plusman
 * @since 12/17/20
 */
@Data
public class Blog {
    private Integer blogId;
    private String content;
    private String camelStyle;
    
    /**
     * 需要在 resultMap 配置 Json Type Handler，才可正常显示
     * 不然显示为 null
     */
    private String[] jsonField;
    /**
     * 如果字段为 String，则直接取出 JSON Stirng
     */
    // private String jsonField;
}
