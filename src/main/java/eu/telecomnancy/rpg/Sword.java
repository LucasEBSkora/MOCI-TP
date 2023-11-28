package eu.telecomnancy.rpg;

public class Sword extends Weapon {
    public int sharpness;
    public Sword(String name, int damage, int sharpness) {
        super(name, damage);
        this.sharpness = sharpness;
    }
}
