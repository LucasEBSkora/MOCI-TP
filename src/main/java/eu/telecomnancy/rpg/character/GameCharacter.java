package eu.telecomnancy.rpg.character;

import eu.telecomnancy.rpg.armor.Armor;
import eu.telecomnancy.rpg.observer.Observable;
import eu.telecomnancy.rpg.strategy.Strategy;
import eu.telecomnancy.rpg.visitor.CharacterVisitor;
import eu.telecomnancy.rpg.weapon.Weapon;

public interface GameCharacter extends Observable {
    String getName();

    int getHealth();

    void setHealth(int health);

    int getExperiencePoints();

    void setExperiencePoints(int xp);

    int getLevel();

    void setLevel(int level);

    boolean isAlive();

    void setAlive(boolean alive);

    Weapon getWeapon();
    void setWeapon(Weapon weapon);

    void addArmor(Armor armor);

    int getBaseArmor();

    void setStrategy(Strategy strategy);

    Strategy getStrategy();
    void applyDamage(int damage);

    int getDamage();

    void addXP(int xp);

    void accept(CharacterVisitor V);


}
