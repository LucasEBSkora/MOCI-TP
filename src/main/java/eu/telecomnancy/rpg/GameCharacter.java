package eu.telecomnancy.rpg;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
@Setter
public abstract class GameCharacter {
    public final String name;
    public  int health;
    public int experiencePoints;
    public int level;

    public Weapon weapon;
    ArrayList<Armor> armor;
    public GameCharacter(String name) {
        this.name = name;
        this.experiencePoints = 0;
        this.level = 1;

        armor = new ArrayList<>();
    }
}
