package eu.telecomnancy.rpg.strategy;

public class NeutralStrategy implements Strategy {
    @Override
    public int getModifiedDamage(int damage) {
        return damage;
    }
}
