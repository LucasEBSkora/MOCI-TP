package eu.telecomnancy.rpg.factory_method;

import eu.telecomnancy.rpg.armor.Helmet;
import eu.telecomnancy.rpg.armor.Shield;
import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.observer.Observer;
import eu.telecomnancy.rpg.weapon.Sword;

import java.util.ArrayList;
import java.util.List;

public class WarriorCreator implements CharacterCreator {

    private final List<Observer> observers;

    public WarriorCreator() {
        observers = new ArrayList<>();
    }

    public WarriorCreator(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public GameCharacter createCharacter(String name, int level, boolean isArmed, boolean isArmored) {

        Warrior warrior = new Warrior(name);

        warrior.setStrength(warrior.getStrength() + (level - warrior.getLevel()) / 4);
        warrior.setLevel(level);
        warrior.setHealth(10 * warrior.getLevel());
        warrior.setExperiencePoints(1000 * warrior.getLevel());
        if (isArmed) {
            warrior.setWeapon(new Sword("Broadsword", 10, level));
        }

        if (isArmored) {
            warrior.addArmor(new Helmet("Helmet +1", level / 4));
            warrior.addArmor(new Shield("Shield +2", level / 2));
        }

        observers.forEach(warrior::attach);

        return warrior;

    }
}
