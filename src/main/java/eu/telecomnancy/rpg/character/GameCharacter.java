package eu.telecomnancy.rpg.character;

import eu.telecomnancy.rpg.armor.Armor;
import eu.telecomnancy.rpg.visitor.CharacterVisitor;
import eu.telecomnancy.rpg.weapon.Weapon;
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
    public ArrayList<Armor> armor;
    public GameCharacter(String name) {
        this.name = name;
        this.experiencePoints = 0;
        this.level = 1;

        armor = new ArrayList<>();
    }

    public abstract void accept(CharacterVisitor V);
}
