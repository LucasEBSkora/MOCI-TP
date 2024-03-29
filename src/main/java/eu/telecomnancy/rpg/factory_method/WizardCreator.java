package eu.telecomnancy.rpg.factory_method;

import eu.telecomnancy.rpg.armor.Robe;
import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.character.Wizard;
import eu.telecomnancy.rpg.observer.Observer;
import eu.telecomnancy.rpg.weapon.Staff;

import java.util.ArrayList;
import java.util.List;

public class WizardCreator implements CharacterCreator {
    private final List<Observer> observers;

    public WizardCreator() {
        observers = new ArrayList<>();
    }

    public WizardCreator(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public GameCharacter createCharacter(String name, int level, boolean isArmed, boolean isArmored) {

        Wizard wizard = new Wizard(name);

        wizard.setIntelligence(wizard.getIntelligence() + (level - wizard.getLevel()) / 4);
        wizard.setLevel(level);
        wizard.setHealth(6 * wizard.getLevel());
        wizard.setExperiencePoints(1000 * wizard.getLevel());
        if (isArmed) {
            wizard.setWeapon(new Staff("Staff of magic missiles", 12, level));
        }

        if (isArmored) {
            wizard.addArmor(new Robe("Robe of Protection", level / 4));
        }

        observers.forEach(wizard::attach);

        return wizard;

    }
}
