package eu.telecomnancy.rpg.visitor;

import eu.telecomnancy.rpg.character.Healer;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.character.Wizard;

public interface CharacterVisitor {
    void visitWizard(Wizard character);
    void visitWarrior(Warrior character);
    void visitHealer(Healer character);
}
