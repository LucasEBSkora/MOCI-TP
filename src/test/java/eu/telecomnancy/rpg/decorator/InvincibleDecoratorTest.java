package eu.telecomnancy.rpg.decorator;

import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.character.Wizard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InvincibleDecoratorTest {
    @Test
    void testDecorate() {
        GameCharacter character = new Wizard("lewis");
        character.setHealth(30);
        character.applyDamage(10);
        Assertions.assertEquals(20, character.getHealth());
        GameCharacter decorated = new InvincibleDecorator(character);

        decorated.applyDamage(50);
        Assertions.assertEquals(20, decorated.getHealth());
        Assertions.assertEquals(20, character.getHealth());
    }
}