package eu.telecomnancy.rpg.character;

import eu.telecomnancy.rpg.singleton.GameConfiguration;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class Team {
    private final String name;

    private final Collection<GameCharacter> players;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public void addPlayer(GameCharacter player) {
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
}
