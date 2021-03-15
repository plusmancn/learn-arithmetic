package cn.plusman.learn.java.varargs;

/**
 * 可变参数参考文档：https://www.runoob.com/w3cnote/java-varargs-parameter.html
 * @author plusman
 * @since 2021/3/15 10:49 PM
 */
public class VarargsDemo {
    public static void main(String[] args) {
        VarargsDemo demo = new VarargsDemo();
        
        // 两者调用方式等价
        demo.Case1(new Integer[]{Integer.valueOf(1), Integer.valueOf(2)});
        demo.Case1(1, 4, 5);
    }
    
    public void Case1(Integer... nums) {
        System.out.println(nums);
    }
    
    // 不允许此类重载
    // public void Case1(Integer[] numbers) {
    //
    // }
}
