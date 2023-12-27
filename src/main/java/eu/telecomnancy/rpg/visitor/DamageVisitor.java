package eu.telecomnancy.rpg.visitor;

import eu.telecomnancy.rpg.character.Healer;
import eu.telecomnancy.rpg.character.Warrior;
import eu.telecomnancy.rpg.character.Wizard;

public class DamageVisitor extends CharacterVisitor {

    final private int damage;

    public DamageVisitor(int damage) {
        this.damage = damage;
    }

    @Override
    public void visitWizard(Wizard character) {
        // Wizard suffers 1.5 damage
        int armor = character.getBaseArmor();
        int damage = this.damage * 3 / 2;
        if (damage < armor) {
            return;
        }

        character.applyDamage(damage - armor);
    }

    @Override
    public void visitWarrior(Warrior character) {
        // Warrior benefits from double armor
        int armor = 2 * character.getBaseArmor();
        if (damage < armor) {
            return;
        }

        character.applyDamage(damage - armor);
    }

    @Override
    public void visitHealer(Healer character) {
        // healer can't wear armor
        character.applyDamage(damage);
    }
}
