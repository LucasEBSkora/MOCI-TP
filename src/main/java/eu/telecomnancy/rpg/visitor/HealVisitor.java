package eu.telecomnancy.rpg.visitor;

import eu.telecomnancy.rpg.character.Healer;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.character.Wizard;

public class HealVisitor extends CharacterVisitor {

    private final int healAmount;

    public HealVisitor(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void visitWizard(Wizard character) {
        character.setHealth(character.getHealth() + healAmount);
    }

    @Override
    public void visitWarrior(Warrior character) {
        character.setHealth(character.getHealth() + healAmount + character.getLevel());
    }

    @Override
    public void visitHealer(Healer character) {
        character.setHealth(character.getHealth() + healAmount*2/3);
    }
}
