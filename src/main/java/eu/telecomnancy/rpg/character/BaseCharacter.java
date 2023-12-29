package eu.telecomnancy.rpg.character;

import eu.telecomnancy.rpg.armor.Armor;
import eu.telecomnancy.rpg.observer.Observer;
import eu.telecomnancy.rpg.strategy.NeutralStrategy;
import eu.telecomnancy.rpg.strategy.Strategy;
import eu.telecomnancy.rpg.weapon.Weapon;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@ToString
public abstract class BaseCharacter implements GameCharacter {
    final String name;
    final Set<Observer> observers;
    int health;
    int experiencePoints;
    int level;
    boolean alive;
    Weapon weapon;
    ArrayList<Armor> armor;
    Strategy strategy;

    public BaseCharacter(String name) {
        this.name = name;
        this.experiencePoints = 0;
        this.level = 1;
        this.alive = true;

        armor = new ArrayList<>();
        strategy = new NeutralStrategy();
        observers = new HashSet<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getExperiencePoints() {
        return experiencePoints;
    }

    @Override
    public void setExperiencePoints(int xp) {
        this.experiencePoints = xp;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public Weapon getWeapon() {
        return this.weapon;
    }
    @Override
    public void addArmor(Armor armor) {
        this.armor.add(armor);
    }

    @Override
    public int getBaseArmor() {
        int defense = 0;
        for (Armor a : this.armor) {
            defense += a.defense;
        }
        return defense;
    }

    @Override
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Strategy getStrategy() {
        return strategy;
    }

    @Override
    public void applyDamage(int damage) {
        health -= strategy.getModifiedDamage(damage);
        if (health < 0) {
            health = 0;
        }
        notifyObservers();
    }

    @Override
    public int getDamage() {
        int damage;
        if (!alive) {
            damage = 0;
        } else if (weapon == null) {
            damage = 1;
        } else {
            damage = weapon.damage * level / 20;
        }
        return strategy.getModifiedDamage(damage);
    }

    @Override
    public void addXP(int xp) {
        experiencePoints += xp;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

}
