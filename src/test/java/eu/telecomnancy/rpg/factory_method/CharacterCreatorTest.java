package eu.telecomnancy.rpg.factory_method;

import eu.telecomnancy.rpg.armor.Helmet;
import eu.telecomnancy.rpg.armor.Robe;
import eu.telecomnancy.rpg.armor.Shield;
import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.character.Healer;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.character.Wizard;
import eu.telecomnancy.rpg.weapon.Staff;
import eu.telecomnancy.rpg.weapon.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCreatorTest {

    @Test
    void createHealer() {
        CharacterCreator creator = new HealerCreator();
        GameCharacter playerCharacter = creator.createCharacter("jim", 1, false, false);
        assertTrue(playerCharacter instanceof Healer);
        assertEquals("jim", playerCharacter.name);
        assertEquals(1, playerCharacter.level);
        assertEquals(8, playerCharacter.health);
        assertNull(playerCharacter.weapon);
        assertEquals(0, playerCharacter.armor.size());
    }

    @Test
    void createWizard() {
        CharacterCreator creator = new WizardCreator();
        GameCharacter playerCharacter = creator.createCharacter("Thomas", 5, true, true);
        assertTrue(playerCharacter instanceof Wizard);
        assertEquals("Thomas", playerCharacter.name);
        assertEquals(5, playerCharacter.level);
        assertEquals(30, playerCharacter.health);
        assertTrue(playerCharacter.weapon instanceof Staff);
        assertEquals(1, playerCharacter.armor.size());
        assert (playerCharacter.armor.get(0) instanceof Robe);
    }

    @Test
    void createWarrior() {
        CharacterCreator creator = new WarriorCreator();
        GameCharacter playerCharacter = creator.createCharacter("Jerry", 20, true, true);
        assertTrue(playerCharacter instanceof Warrior);
        assertEquals("Jerry", playerCharacter.name);
        assertEquals(20, playerCharacter.level);
        assertEquals(200, playerCharacter.health);
        assert (playerCharacter.weapon instanceof Sword);
        assertEquals(2, playerCharacter.armor.size());
        assert (playerCharacter.armor.get(0) instanceof Helmet);
        assert (playerCharacter.armor.get(1) instanceof Shield);
    }
}