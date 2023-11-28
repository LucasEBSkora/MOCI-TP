package eu.telecomnancy.rpg.weapon;

public class Staff extends Weapon {
    public int magic;
    public Staff(String name, int damage, int magic) {
        super(name, damage);
        this.magic = magic;
    }
}
