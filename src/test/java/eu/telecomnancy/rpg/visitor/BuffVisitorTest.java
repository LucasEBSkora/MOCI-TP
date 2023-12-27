package eu.telecomnancy.rpg.visitor;

import eu.telecomnancy.rpg.character.Healer;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.character.Wizard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuffVisitorTest {

    @Test
    void visitWizard() {
        CharacterVisitor v = new BuffVisitor(5);
        Wizard wizard = new Wizard("James");
        int oldInt = wizard.getIntelligence();
        wizard.accept(v);
        assertEquals(oldInt + 5, wizard.getIntelligence());
    }

    @Test
    void visitWarrior() {
        CharacterVisitor v = new BuffVisitor(3);
        Warrior warrior = new Warrior("James");
        int oldStr = warrior.getStrength();
        warrior.accept(v);
        assertEquals(oldStr + 3, warrior.getStrength());
    }

    @Test
    void visitHealer() {
        CharacterVisitor v = new BuffVisitor(10);
        Healer healer = new Healer("James");
        int oldWis = healer.getWisdom();
        healer.accept(v);
        assertEquals(oldWis + 10, healer.getWisdom());
    }
}