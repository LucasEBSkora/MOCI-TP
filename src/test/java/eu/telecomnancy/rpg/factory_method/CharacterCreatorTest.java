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

import static org.junit.jupiter.api.Assertions.assertNull;
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
        assertNull(playerCharacter.getWeapon());
        assertEquals(0, playerCharacter.getArmor().size());
    }

    @Test
    void createWizard() {
        CharacterCreator creator = new WizardCreator();
        GameCharacter playerCharacter = creator.createCharacter("Thomas", 5, true, true);
        assertTrue(playerCharacter instanceof Wizard);
        assertEquals("Thomas", playerCharacter.getName());
        assertEquals(5, playerCharacter.getLevel());
        assertEquals(30, playerCharacter.getHealth());
        assertTrue(playerCharacter.getWeapon() instanceof Staff);
        assertEquals(1, playerCharacter.getArmor().size());
        assert (playerCharacter.getArmor().get(0) instanceof Robe);
    }

    @Test
    void createWarrior() {
        CharacterCreator creator = new WarriorCreator();
        GameCharacter playerCharacter = creator.createCharacter("Jerry", 20, true, true);
        assertTrue(playerCharacter instanceof Warrior);
        assertEquals("Jerry", playerCharacter.getName());
        assertEquals(20, playerCharacter.getLevel());
        assertEquals(200, playerCharacter.getHealth());
        assert (playerCharacter.getWeapon() instanceof Sword);
        assertEquals(2, playerCharacter.getArmor().size());
        assert (playerCharacter.getArmor().get(0) instanceof Helmet);
        assert (playerCharacter.getArmor().get(1) instanceof Shield);
    }
}