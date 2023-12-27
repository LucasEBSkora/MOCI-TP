package eu.telecomnancy.rpg.observer;

import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.character.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeathObserverTest {

    GameCharacter character;
    DeathObserver observer;

    @BeforeEach
    void setUp() {
        character = new Warrior("jefferson");
        character.setHealth(10);
        observer = new DeathObserver();
        character.attach(observer);
    }


    @Test
    void noDeath() {
        character.applyDamage(9);
        assertTrue(character.isAlive());
    }

    @Test
    void death() {
        character.applyDamage(20);
        assertFalse(character.isAlive());
    }

}