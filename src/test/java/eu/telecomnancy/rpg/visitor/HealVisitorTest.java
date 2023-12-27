package eu.telecomnancy.rpg.visitor;

import eu.telecomnancy.rpg.character.Healer;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.character.Wizard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HealVisitorTest {

    @Test
    void visitWizard() {
        CharacterVisitor v = new HealVisitor(10);
        Wizard wizard = new Wizard("James");
        wizard.setHealth(25);
        wizard.accept(v);
        assertEquals(35, wizard.getHealth());
    }

    @Test
    void visitWarrior() {
        CharacterVisitor v = new HealVisitor(100);
        Warrior warrior = new Warrior("James");
        warrior.setLevel(20);
        warrior.setHealth(20);
        warrior.accept(v);
        assertEquals(140, warrior.getHealth());
    }

    @Test
    void visitHealer() {
        CharacterVisitor v = new HealVisitor(66);
        Healer healer = new Healer("James");
        healer.setHealth(56);
        healer.accept(v);
        assertEquals(100, healer.getHealth());
    }
}