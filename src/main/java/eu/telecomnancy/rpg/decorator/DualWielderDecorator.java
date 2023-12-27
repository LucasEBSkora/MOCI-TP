package eu.telecomnancy.rpg.decorator;

import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.weapon.Weapon;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DualWielderDecorator extends Decorator {

    private Weapon secondaryWeapon;

    public DualWielderDecorator(GameCharacter decorated) {
        super(decorated);
    }

    @Override
    public int getDamage() {
        int damage;
        Weapon primaryWeapon = decorated.getWeapon();
        if (primaryWeapon == null) {
            damage = 1;
        } else {
            damage = primaryWeapon.damage * decorated.getLevel() * 3 / 80;
        }

        if (secondaryWeapon != null) {
            damage += secondaryWeapon.damage * decorated.getLevel() / 80;
        }
        return decorated.getStrategy().getModifiedDamage(damage);
    }

}
