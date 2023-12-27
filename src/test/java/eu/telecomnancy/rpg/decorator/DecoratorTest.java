package eu.telecomnancy.rpg.decorator;

import eu.telecomnancy.rpg.armor.Armor;
import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.character.Wizard;
import eu.telecomnancy.rpg.strategy.NeutralStrategy;
import eu.telecomnancy.rpg.strategy.OffensiveStrategy;
import eu.telecomnancy.rpg.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(GameCharacter decorated) {
        super(decorated);
    }
}

class DecoratorTest {

    GameCharacter character;

    GameCharacter decorated;

    @BeforeEach
    void setUp() {
        character = new Wizard("Lewis");
        decorated = new ConcreteDecorator(character);
    }

    @Test
    void getName() {
        assertEquals("Lewis", decorated.getName());
    }

    @Test
    void getHealth() {
        character.setHealth(10);
        assertEquals(10, decorated.getHealth());
        decorated.setHealth(15);
        assertEquals(15, character.getHealth());
    }

    @Test
    void getExperiencePoints() {
        character.setExperiencePoints(100);
        assertEquals(100, decorated.getExperiencePoints());
        decorated.setExperiencePoints(2000);
        assertEquals(2000, character.getExperiencePoints());
    }

    @Test
    void getLevel() {
        assertEquals(1, decorated.getLevel());
        decorated.setLevel(15);
        assertEquals(15, character.getLevel());
    }

    @Test
    void isAlive() {
        assertTrue(decorated.isAlive());
        decorated.setAlive(false);
        assertFalse(character.isAlive());
    }

    @Test
    void getWeapon() {
        assertNull(decorated.getWeapon());
        Weapon w = new Weapon("weapon", 1);
        decorated.setWeapon(w);
        assertEquals(w, character.getWeapon());
    }

    @Test
    void addArmor() {
        assertEquals(0, decorated.getBaseArmor());
        decorated.addArmor(new Armor("aaaaaaaaaaaaa", 10));
        assertEquals(10, character.getBaseArmor());
    }

    @Test
    void getStrategy() {
        assertTrue(decorated.getStrategy() instanceof NeutralStrategy);
        decorated.setStrategy(new OffensiveStrategy());
        assertTrue(character.getStrategy() instanceof OffensiveStrategy);
    }

    @Test
    void applyDamage() {
        character.setHealth(20);
        decorated.applyDamage(10);
        assertEquals(10, character.getHealth());
    }

    @Test
    void getDamage() {
        Weapon w = new Weapon("weapon", 1);
        decorated.setWeapon(w);
    }

    @Test
    void addXP() {
        character.setExperiencePoints(1000);
        decorated.addXP(500);
        assertEquals(1500, character.getExperiencePoints());
    }
}