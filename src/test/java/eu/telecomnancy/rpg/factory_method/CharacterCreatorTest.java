package eu.telecomnancy.rpg.factory_method;

import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.character.Healer;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.character.Wizard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterCreatorTest {

    @Test
    void createHealer() {
        CharacterCreator creator = new HealerCreator();
        GameCharacter playerCharacter = creator.createCharacter("jim", 1, false, false);
        assertTrue(playerCharacter instanceof Healer);
        assertEquals("jim", playerCharacter.getName());
        assertEquals(1, playerCharacter.getLevel());
        assertEquals(8, playerCharacter.getHealth());
        assertEquals(1, playerCharacter.getDamage());
        assertEquals(0, playerCharacter.getBaseArmor());
    }

    @Test
    void createWizard() {
        CharacterCreator creator = new WizardCreator();
        GameCharacter playerCharacter = creator.createCharacter("Thomas", 5, true, true);
        assertTrue(playerCharacter instanceof Wizard);
        assertEquals("Thomas", playerCharacter.getName());
        assertEquals(5, playerCharacter.getLevel());
        assertEquals(30, playerCharacter.getHealth());
        assertEquals(3, playerCharacter.getDamage());
        assertEquals(1, playerCharacter.getBaseArmor());
    }

    @Test
    void createWarrior() {
        CharacterCreator creator = new WarriorCreator();
        GameCharacter playerCharacter = creator.createCharacter("Jerry", 20, true, true);
        assertTrue(playerCharacter instanceof Warrior);
        assertEquals("Jerry", playerCharacter.getName());
        assertEquals(20, playerCharacter.getLevel());
        assertEquals(200, playerCharacter.getHealth());
        assertEquals(10, playerCharacter.getDamage());
        assertEquals(15, playerCharacter.getBaseArmor());
    }
}