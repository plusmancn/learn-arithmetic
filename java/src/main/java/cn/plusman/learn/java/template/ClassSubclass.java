package cn.plusman.learn.java.template;

/**
 * @author plusman
 * @since 2021/5/5 12:08 PM
 */
public class ClassSubclass extends ClassTemplate {
    @Override
    protected void foo() {
        System.out.println(getClass().getName() + "#foo");
    }
    
    public static void main(String[] args) {
        ClassSubclass cs = new ClassSubclass();
        cs.refresh();
    }
}
