package eu.telecomnancy.rpg.strategy;

import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.weapon.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategyTest {

    @Test
    void testChangeStrategy() {
        GameCharacter character = new Warrior("phillip");
        character.setHealth(100);
        character.setStrategy(new NeutralStrategy());
        character.applyDamage(20);
        assertEquals(80, character.getHealth());

        character.setStrategy(new DefensiveStrategy());
        character.applyDamage(20);
        assertEquals(70, character.getHealth());

        character.setStrategy(new OffensiveStrategy());
        character.applyDamage(20);
        assertEquals(30, character.getHealth());
    }

    @Test
    void testGetDamage() {
        GameCharacter character = new Warrior("phillip");
        character.setLevel(20);
        character.setWeapon(new Sword("sword of swordiness", 10, 100));
        character.setHealth(100);
        character.setStrategy(new NeutralStrategy());
        assertEquals(10, character.getDamage());

        character.setStrategy(new DefensiveStrategy());
        assertEquals(5, character.getDamage());

        character.setStrategy(new OffensiveStrategy());
        assertEquals(20, character.getDamage());
    }

}