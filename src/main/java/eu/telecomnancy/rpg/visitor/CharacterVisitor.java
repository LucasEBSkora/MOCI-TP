package eu.telecomnancy.rpg.visitor;

import eu.telecomnancy.rpg.character.Healer;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.character.Wizard;

public abstract class CharacterVisitor {
    abstract public void visitWizard(Wizard character);

    abstract public void visitWarrior(Warrior character);

    abstract public void visitHealer(Healer character);
}
