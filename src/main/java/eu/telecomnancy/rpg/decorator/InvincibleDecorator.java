package eu.telecomnancy.rpg.decorator;

import eu.telecomnancy.rpg.character.GameCharacter;

public class InvincibleDecorator extends Decorator {
    public InvincibleDecorator(GameCharacter decorated) {
        super(decorated);
    }

    @Override
    public void applyDamage(int damage) {
        decorated.notifyObservers();
    }
}
