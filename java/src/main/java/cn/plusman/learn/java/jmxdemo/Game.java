package cn.plusman.learn.java.jmxdemo;

/**
 * @author plusman
 * @since 2021/4/20 3:33 PM
 */
public class Game implements GameMBean {
    private String playerName;
    
    @Override
    public void playFootball(String clubName) {
        System.out.println(
            this.playerName + " playing football for " + clubName);
    }
    
    @Override
    public String getPlayerName() {
        System.out.println("Return playerName " + this.playerName);
        return playerName;
    }
    
    @Override
    public void setPlayerName(String playerName) {
        System.out.println("Set playerName to value " + playerName);
        this.playerName = playerName;
    }
}
