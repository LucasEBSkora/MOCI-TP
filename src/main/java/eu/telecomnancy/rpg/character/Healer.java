package eu.telecomnancy.rpg.character;

import eu.telecomnancy.rpg.visitor.CharacterVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class Healer extends BaseCharacter {
    public int wisdom;

    public Healer(String name) {
        super(name);
        this.wisdom = this.getLevel() * 10 + new Random().nextInt(10);
    }

    @Override
    public void accept(CharacterVisitor V) {
        V.visitHealer(this);
    }

}
