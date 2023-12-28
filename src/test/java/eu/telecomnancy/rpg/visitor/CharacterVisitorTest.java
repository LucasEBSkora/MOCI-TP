package eu.telecomnancy.rpg.visitor;

import eu.telecomnancy.rpg.character.Healer;
import eu.telecomnancy.rpg.character.Team;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.character.Wizard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterVisitorTest {

    @Test
    void visitTeam() throws Exception {
        Team team = new Team("the jameses");
        CharacterVisitor v = new HealVisitor(6);
        Wizard wizard = new Wizard("James");
        wizard.setHealth(0);
        Warrior warrior = new Warrior("James");
        warrior.setLevel(5);
        warrior.setHealth(0);
        Healer healer = new Healer("James");
        healer.setHealth(0);
        team.addPlayer(wizard);
        team.addPlayer(warrior);
        team.addPlayer(healer);
        team.accept(v);
        assertEquals(6, wizard.getHealth());
        assertEquals(11, warrior.getHealth());
        assertEquals(4, healer.getHealth());
    }
}