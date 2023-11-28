package eu.telecomnancy.rpg.visitor;

import eu.telecomnancy.rpg.character.Healer;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.character.Wizard;

public class  BuffVisitor implements CharacterVisitor {

    private final int intensity;

    public BuffVisitor(int intensity) {
        this.intensity = intensity;
    }

    @Override
    public void visitWizard(Wizard character) {
        character.setIntelligence(this.intensity + character.getIntelligence());
    }

    @Override
    public void visitWarrior(Warrior character) {
        character.setStrength(this.intensity + character.getStrength());
    }

    @Override
    public void visitHealer(Healer character) {
        character.setWisdom(this.intensity + character.getWisdom());
    }
}
