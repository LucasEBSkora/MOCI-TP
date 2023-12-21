package eu.telecomnancy.rpg.observer;

import eu.telecomnancy.rpg.character.GameCharacter;

public class DeathObserver implements Observer {
    @Override
    public void update(Observable observable) {
        if (!(observable instanceof GameCharacter character)) {
            return;
        }
        if (character.getHealth() == 0) {
            System.out.println("character " + character.getName() + " is dead!");
            character.setAlive(false);
        }
    }
}
