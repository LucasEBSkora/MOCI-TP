package eu.telecomnancy.rpg.factory_method;

import eu.telecomnancy.rpg.character.GameCharacter;

public interface CharacterCreator {
    GameCharacter createCharacter(String name, int level, boolean isArmed, boolean isArmored);
}
