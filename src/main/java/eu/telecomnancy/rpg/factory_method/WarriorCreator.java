package eu.telecomnancy.rpg.factory_method;

import eu.telecomnancy.rpg.armor.Helmet;
import eu.telecomnancy.rpg.armor.Shield;
import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.weapon.Sword;

public class WarriorCreator implements CharacterCreator {
    @Override
    public GameCharacter createCharacter(String name, int level, boolean isArmed, boolean isArmored) {

        Warrior warrior = new Warrior(name);

        warrior.setStrength(warrior.getStrength() + (level - warrior.level)/4);
        warrior.setLevel(level);
        warrior.setHealth(10*warrior.level);
        warrior.setExperiencePoints(1000*warrior.level);
        if (isArmed) {
            warrior.setWeapon( new Sword("Broadsword", 10, level));
        }

        if (isArmored) {
            warrior.armor.add(new Helmet("Helmet +1", level/4));
            warrior.armor.add(new Shield("Shield +2", level/2));
        }

        return warrior;

    }
}
