package eu.telecomnancy.rpg;

public interface CharacterCreator {
    GameCharacter createCharacter(String name, int level, boolean isArmed, boolean isArmored);
}
