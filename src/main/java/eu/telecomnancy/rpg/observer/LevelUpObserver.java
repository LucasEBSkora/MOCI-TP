package eu.telecomnancy.rpg.observer;

import eu.telecomnancy.rpg.character.GameCharacter;

public class LevelUpObserver implements Observer {
    @Override
    public void update(Observable observable) {
        if (!(observable instanceof GameCharacter character)) {
            return;
        }
        int oldLevel = character.getLevel();

        int newLevel = character.getExperiencePoints() / 1000;
        if (newLevel > oldLevel) {
            System.out.println("Character " + character.getName() + " leveled up to level " + newLevel);
            character.setLevel(newLevel);
        }
    }
}
