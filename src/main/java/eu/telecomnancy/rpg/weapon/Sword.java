package eu.telecomnancy.rpg.weapon;

public class Sword extends Weapon {
    public int sharpness;
    public Sword(String name, int damage, int sharpness) {
        super(name, damage);
        this.sharpness = sharpness;
    }
}
