package eu.telecomnancy.rpg.character;

import java.util.Random;

import eu.telecomnancy.rpg.visitor.CharacterVisitor;
import lombok.Getter;
import lombok.Setter;

public class Warrior extends GameCharacter {
    @Getter
    @Setter
    private int strength;

    public Warrior(String name) {
        super(name);
        strength = getLevel() * 10+new Random().nextInt(10);
    }

    @Override
    public void accept(CharacterVisitor V) {
        V.visitWarrior(this);
    }

}