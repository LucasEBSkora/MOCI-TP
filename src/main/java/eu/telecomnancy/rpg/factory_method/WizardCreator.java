package eu.telecomnancy.rpg.factory_method;

import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.armor.Robe;
import eu.telecomnancy.rpg.weapon.Staff;
import eu.telecomnancy.rpg.character.Wizard;

public class WizardCreator implements CharacterCreator {

    @Override
    public GameCharacter createCharacter(String name, int level, boolean isArmed, boolean isArmored) {

        Wizard wizard = new Wizard(name);

        wizard.setIntelligence(wizard.getIntelligence() + (level - wizard.level)/4);
        wizard.setLevel(level);
        wizard.setHealth(6*wizard.level);
        wizard.setExperiencePoints(1000*wizard.level);
        if (isArmed) {
            wizard.setWeapon( new Staff("Staff of magic missiles", 12, level));
        }

        if (isArmored) {
            wizard.armor.add(new Robe("Robe of Protection", level/8));
        }

        return wizard;

    }
}