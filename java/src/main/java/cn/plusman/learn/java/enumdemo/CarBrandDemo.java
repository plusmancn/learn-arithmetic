package cn.plusman.learn.java.enumdemo;

/**
 * @author plusman
 * @since 2021/4/23 2:44 PM
 */
enum CarBrandEnum {
    /**
     * 沃尔沃
     */
    Volvo,
    /**
     * 特斯拉
     */
    Tesla,
    /**
     * 日产
     */
    Nissian
};

public class CarBrandDemo {
    public static void main(String[] args) {
        CarBrandEnum carBrand = CarBrandEnum.Nissian;
    
        System.out.println(carBrand);
    }
}
