package cn.plusman.learn.java.jmxdemo;

/**
 * @author plusman
 * @since 2021/4/20 3:26 PM
 */
public interface GameMBean {
    public void playFootball(String clubName);
    
    public String getPlayerName();
    
    public void setPlayerName(String playerName);
}
