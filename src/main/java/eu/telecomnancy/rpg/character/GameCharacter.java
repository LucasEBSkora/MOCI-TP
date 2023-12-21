package eu.telecomnancy.rpg.character;

import eu.telecomnancy.rpg.armor.Armor;
import eu.telecomnancy.rpg.observer.Observable;
import eu.telecomnancy.rpg.strategy.NeutralStrategy;
import eu.telecomnancy.rpg.strategy.Strategy;
import eu.telecomnancy.rpg.visitor.CharacterVisitor;
import eu.telecomnancy.rpg.weapon.Weapon;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
@Setter
public abstract class GameCharacter extends Observable {
    final String name;
    int health;
    int experiencePoints;
    int level;
    boolean alive;

    Weapon weapon;
    ArrayList<Armor> armor;

    Strategy strategy;

    public GameCharacter(String name) {
        this.name = name;
        this.experiencePoints = 0;
        this.level = 1;
        this.alive = true;

        armor = new ArrayList<>();
        strategy = new NeutralStrategy();
    }

    public abstract void accept(CharacterVisitor V);

    public void applyDamage(int damage) {
        health -= strategy.getModifiedDamage(damage);
        if (health < 0) {
            health = 0;
        }
        notifyObservers();
    }

    public int getDamage() {
        int damage;
        if (weapon == null) {
            damage = 1;
        } else {
            damage = weapon.damage * level / 20;
        }
        return strategy.getModifiedDamage(damage);
    }

    public void addXP(int xp) {
        experiencePoints += xp;
        notifyObservers();
    }
}
