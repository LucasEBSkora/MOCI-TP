package eu.telecomnancy.rpg.visitor;

import eu.telecomnancy.rpg.character.*;

public abstract class CharacterVisitor {
    abstract public void visitWizard(Wizard character);

    abstract public void visitWarrior(Warrior character);

    abstract public void visitHealer(Healer character);

    void visitTeam(Team team) {
        for (GameCharacter member : team.getPlayers()) {
            member.accept(this);
        }
    }
}
