package eu.telecomnancy.rpg.singleton;

public class GameConfiguration {
    public int difficulty;
    public int maxPartySize;

    private static GameConfiguration singleInstance;

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
