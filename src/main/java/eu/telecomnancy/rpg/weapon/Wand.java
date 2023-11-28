package eu.telecomnancy.rpg.weapon;

public class Wand extends Weapon {
    public int magic;
    public Wand(String name, int damage, int magic) {
        super(name, damage);
        this.magic = magic;
    }
}
