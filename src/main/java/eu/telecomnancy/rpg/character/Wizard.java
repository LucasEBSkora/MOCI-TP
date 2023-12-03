package eu.telecomnancy.rpg.character;

import eu.telecomnancy.rpg.visitor.CharacterVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class Wizard extends GameCharacter {
    @Getter
    @Setter
    private int intelligence;

    public Wizard(String name) {
        super(name);
        intelligence = getLevel() * 10 + new Random().nextInt(10);
    }

    @Override
    public void accept(CharacterVisitor V) {
        V.visitWizard(this);
    }


}
