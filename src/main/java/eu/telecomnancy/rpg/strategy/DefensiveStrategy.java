package eu.telecomnancy.rpg.strategy;

public class DefensiveStrategy implements Strategy {
    @Override
    public int getModifiedDamage(int damage) {
        return damage / 2;
    }
}
