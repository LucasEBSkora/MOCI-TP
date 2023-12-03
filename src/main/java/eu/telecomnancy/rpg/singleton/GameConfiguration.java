package eu.telecomnancy.rpg.singleton;

public class GameConfiguration {
    private static GameConfiguration singleInstance;
    public int difficulty;
    public int maxPartySize;

    private GameConfiguration(int difficulty, int maxPartySize) {
        this.difficulty = difficulty;
        this.maxPartySize = maxPartySize;
    }

    static public GameConfiguration getInstance() {
        if (GameConfiguration.singleInstance == null) {
            GameConfiguration.singleInstance = new GameConfiguration(1, 5);
        }
        return GameConfiguration.singleInstance;
    }

}
