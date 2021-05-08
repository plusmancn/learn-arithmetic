package cn.plusman.learn.java.template;

/**
 * @author plusman
 * @since 2021/5/5 12:07 PM
 */
public class ClassTemplate {
    protected void foo() {
        System.out.println(getClass().getName() + "#foo");
    }
    
    public void refresh() {
        foo();
    }
}
