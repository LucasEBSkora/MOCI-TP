package eu.telecomnancy.rpg.factory_method;

import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.character.Healer;
import eu.telecomnancy.rpg.weapon.Staff;

public class HealerCreator implements CharacterCreator {
    @Override
    public GameCharacter createCharacter(String name, int level, boolean isArmed, boolean isArmored) {

        Healer healer = new Healer(name);

        healer.setWisdom(healer.getWisdom() + (level - healer.level) / 4);
        healer.setLevel(level);
        healer.setHealth(8 * healer.level);
        healer.setExperiencePoints(1000 * healer.level);
        if (isArmed) {
            healer.setWeapon(new Staff("Staff of healing", 10, level));
        }

        // Healers are not allowed to wear armor

        return healer;

    }
}
