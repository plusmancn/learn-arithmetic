package cn.plusman.learn.java.enumdemo;

/**
 * @author plusman
 * @since 2021/7/3 9:45 AM
 */
enum Planet {
    /**
     * 所以标记个 Depracated 不香吗，为什么一定需要删除呢。
     * 再加个 Will be removed in 1.7.x
     */
    @Deprecated
    EARTH("地球"),
    
    /**
     * Active
     */
    MERCURY("水星");
    
    public String publicStr;
    Planet(String name) {
        this.publicStr = name;
    }
    
    public String getXX() {
        switch (this) {
            case MERCURY:
                return "xx";
            default:
        }
        
        throw new AssertionError("Unknown op");
        
    }
}