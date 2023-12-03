package eu.telecomnancy.rpg.strategy;

public class OffensiveStrategy implements Strategy {
    @Override
    public int getModifiedDamage(int damage) {
        return 2 * damage;
    }
}
