package eu.telecomnancy.rpg;

public interface CharacterCreator {
    public GameCharacter createCharacter(String name, int level, boolean isArmed, boolean isArmored);
}
