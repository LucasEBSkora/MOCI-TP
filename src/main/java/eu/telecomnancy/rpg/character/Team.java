package eu.telecomnancy.rpg.character;

import eu.telecomnancy.rpg.armor.Armor;
import eu.telecomnancy.rpg.observer.Observer;
import eu.telecomnancy.rpg.singleton.GameConfiguration;
import eu.telecomnancy.rpg.strategy.Strategy;
import eu.telecomnancy.rpg.visitor.CharacterVisitor;
import eu.telecomnancy.rpg.weapon.Weapon;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Team implements GameCharacter {
    private final String name;

    private final Set<GameCharacter> players;

    public Team(String name) {
        this.name = name;
        players = new HashSet<>();
    }

    public void addPlayer(GameCharacter player) throws Exception {
        if (player instanceof Team) {
            throw new Exception("Teams can't contain teams!!!");
        }

        if (this.size() < GameConfiguration.getInstance().maxPartySize) {
            players.add(player);
        }
    }

    public void removePlayer(GameCharacter player) {
        players.remove(player);
    }

    public void removePlayer(String name) {
        for (GameCharacter player : players) {
            if (player.getName().equals(name)) {
                players.remove(player);
                return;
            }
        }
    }

    public GameCharacter getPlayer(String name) {
        for (GameCharacter player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public boolean containsPlayer(String name) {
        for (GameCharacter player : players) {
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsPlayer(GameCharacter player) {
        return players.contains(player);
    }

    public int size() {
        return players.size();
    }

    @Override
    public int getHealth() {
        return players.stream().map(GameCharacter::getHealth).reduce(0, Integer::sum);
    }

    @Override
    public void setHealth(int health) {
        // no
    }

    @Override
    public int getExperiencePoints() {
        return players.stream().map(GameCharacter::getExperiencePoints).reduce(0, Integer::sum);
    }

    @Override
    public void setExperiencePoints(int xp) {
        // no
    }

    @Override
    public int getLevel() {
        return players.stream().map(GameCharacter::getLevel).reduce(0, Integer::sum) / players.size();
    }

    @Override
    public void setLevel(int level) {
        // no
    }

    @Override
    public boolean isAlive() {
        return players.stream().map(GameCharacter::isAlive).reduce(false, Boolean::logicalOr);
    }

    @Override
    public void setAlive(boolean alive) {
        // no
    }

    @Override
    public Weapon getWeapon() {
        // no
        return null;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        // no
    }

    @Override
    public void addArmor(Armor armor) {
        // no
    }

    @Override
    public int getBaseArmor() {
        return players.stream().map(GameCharacter::getBaseArmor).reduce(0, Integer::min);
    }

    @Override
    public Strategy getStrategy() {
        return null;
    }

    @Override
    public void setStrategy(Strategy strategy) {
        players.forEach((character) -> character.setStrategy(strategy));
    }

    @Override
    public void applyDamage(int damage) {
        players.forEach((character) -> character.applyDamage(damage));
    }

    @Override
    public int getDamage() {
        return players.stream().map(GameCharacter::getDamage).reduce(0, Integer::sum);
    }

    @Override
    public void addXP(int xp) {
        players.forEach((character) -> character.addXP(xp));
    }

    @Override
    public void accept(CharacterVisitor V) {
        players.forEach((character) -> character.accept(V));
    }

    @Override
    public void notifyObservers() {
        players.forEach(GameCharacter::notifyObservers);
    }

    @Override
    public void attach(Observer observer) {
        players.forEach((character) -> character.attach(observer));
    }

    @Override
    public void detach(Observer observer) {
        players.forEach((character) -> character.detach(observer));
    }
}
