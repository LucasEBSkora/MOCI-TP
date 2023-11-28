package eu.telecomnancy.rpg;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class Healer extends GameCharacter {
    @Getter
    @Setter
    public int wisdom;

    public Healer(String name) {
        super(name);
        this.wisdom = this.getLevel() * 10+new Random().nextInt(10);
    }

}
