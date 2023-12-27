package eu.telecomnancy.rpg.decorator;

import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.character.Wizard;
import eu.telecomnancy.rpg.weapon.Wand;
import eu.telecomnancy.rpg.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DualWielderDecoratorTest {
    GameCharacter character;
    Weapon wand;

    @BeforeEach
    void setUp() {
        character = new Wizard("Lewis");
        character.setLevel(10);
        character.setWeapon(new Wand("wand of wandyness", 16, 100));
        wand = new Wand("wand of reverse wandyness", 8, 100);
    }

    @Test
    void testNoSecondWeapon() {
        DualWielderDecorator decorated = new DualWielderDecorator(character);
        assertEquals(6, decorated.getDamage());
    }

    @Test
    void testSecondWeapon() {
        DualWielderDecorator decorated = new DualWielderDecorator(character);
        decorated.setSecondaryWeapon(wand);
        assertEquals(7, decorated.getDamage());
    }

}