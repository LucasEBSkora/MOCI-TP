package eu.telecomnancy.rpg.decorator;

import eu.telecomnancy.rpg.armor.Armor;
import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.observer.Observer;
import eu.telecomnancy.rpg.strategy.Strategy;
import eu.telecomnancy.rpg.visitor.CharacterVisitor;
import eu.telecomnancy.rpg.weapon.Weapon;
import lombok.Getter;

@Getter
public abstract class Decorator implements GameCharacter {
    final GameCharacter decorated;

    public Decorator(GameCharacter decorated) {
        this.decorated = decorated;
    }


    @Override
    public String getName() {
        return decorated.getName();
    }

    @Override
    public int getHealth() {
        return decorated.getHealth();
    }

    @Override
    public void setHealth(int health) {
        decorated.setHealth(health);
    }

    @Override
    public int getExperiencePoints() {
        return decorated.getExperiencePoints();
    }

    @Override
    public void setExperiencePoints(int xp) {
        decorated.setExperiencePoints(xp);
    }

    @Override
    public int getLevel() {
        return decorated.getLevel();
    }

    @Override
    public void setLevel(int level) {
        decorated.setLevel(level);
    }

    @Override
    public boolean isAlive() {
        return decorated.isAlive();
    }

    @Override
    public void setAlive(boolean alive) {
        decorated.setAlive(alive);
    }

    @Override
    public Weapon getWeapon() {
        return decorated.getWeapon();
    }

    @Override
    public void setWeapon(Weapon weapon) {
        decorated.setWeapon(weapon);
    }

    @Override
    public void addArmor(Armor armor) {
        decorated.addArmor(armor);
    }

    @Override
    public int getBaseArmor() {
        return decorated.getBaseArmor();
    }

    @Override
    public Strategy getStrategy() {
        return decorated.getStrategy();
    }

    @Override
    public void setStrategy(Strategy strategy) {
        decorated.setStrategy(strategy);
    }

    @Override
    public void applyDamage(int damage) {
        decorated.applyDamage(damage);
    }

    @Override
    public int getDamage() {
        return decorated.getDamage();
    }

    @Override
    public void addXP(int xp) {
        decorated.addXP(xp);
    }

    @Override
    public void accept(CharacterVisitor V) {
        decorated.accept(V);
    }

    @Override
    public void notifyObservers() {
        decorated.notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        decorated.attach(observer);
    }

    @Override
    public void detach(Observer observer) {
        decorated.detach(observer);
    }
}
