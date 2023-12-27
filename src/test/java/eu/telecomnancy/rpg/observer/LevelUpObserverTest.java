package eu.telecomnancy.rpg.observer;

import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.character.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LevelUpObserverTest {
    GameCharacter character;
    LevelUpObserver observer;

    @BeforeEach
    void setUp() {
        character = new Warrior("jefferson");
        observer = new LevelUpObserver();
        character.attach(observer);
    }


    @Test
    void noLevelUp() {
        character.setLevel(5);
        character.setExperiencePoints(5400);
        character.addXP(80);
        assertEquals(5, character.getLevel());
    }

    @Test
    void levelUp() {
        character.setLevel(10);
        character.setExperiencePoints(10500);
        character.addXP(2500);
        assertEquals(13, character.getLevel());
    }
}