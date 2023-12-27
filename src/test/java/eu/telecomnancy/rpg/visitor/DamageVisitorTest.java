package eu.telecomnancy.rpg.visitor;

import eu.telecomnancy.rpg.armor.Robe;
import eu.telecomnancy.rpg.armor.Shield;
import eu.telecomnancy.rpg.character.Healer;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.character.Wizard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DamageVisitorTest {
    @Test
    void visitWizard() {
        CharacterVisitor v = new DamageVisitor(6);
        Wizard wizard = new Wizard("James");
        wizard.addArmor(new Robe("aaa", 5));
        wizard.setHealth(25);
        wizard.accept(v);
        assertEquals(21, wizard.getHealth());
    }

    @Test
    void visitWarrior() {
        CharacterVisitor v = new DamageVisitor(30);
        Warrior warrior = new Warrior("James");
        warrior.setHealth(20);
        warrior.addArmor(new Shield("a", 10));
        warrior.addArmor(new Robe("b", 5));
        warrior.accept(v);
        assertEquals(20, warrior.getHealth());
    }

    @Test
    void visitHealer() {
        CharacterVisitor v = new DamageVisitor(10);
        Healer healer = new Healer("James");
        healer.setHealth(20);
        healer.accept(v);
        assertEquals(10, healer.getHealth());
    }
}