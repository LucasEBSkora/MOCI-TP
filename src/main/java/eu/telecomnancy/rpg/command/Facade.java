package eu.telecomnancy.rpg.command;

import eu.telecomnancy.rpg.character.GameCharacter;
import eu.telecomnancy.rpg.character.Team;
import eu.telecomnancy.rpg.factory_method.HealerCreator;
import eu.telecomnancy.rpg.factory_method.WarriorCreator;
import eu.telecomnancy.rpg.factory_method.WizardCreator;
import eu.telecomnancy.rpg.observer.DeathObserver;
import eu.telecomnancy.rpg.observer.LevelUpObserver;
import eu.telecomnancy.rpg.observer.Observer;
import eu.telecomnancy.rpg.strategy.Strategy;
import eu.telecomnancy.rpg.visitor.BuffVisitor;
import eu.telecomnancy.rpg.visitor.CharacterVisitor;
import eu.telecomnancy.rpg.visitor.DamageVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Facade {

    private final Map<String, Team> teams;
    private final Map<String, GameCharacter> gameCharacters;
    private final WarriorCreator warriorCreator;
    private final HealerCreator healerCreator;
    private final WizardCreator wizardCreator;

    public Facade() {
        teams = new HashMap<>();
        gameCharacters = new HashMap<>();
        DeathObserver deathObserver = new DeathObserver();
        LevelUpObserver levelUpObserver = new LevelUpObserver();
        List<Observer> observers = new ArrayList<>();
        observers.add(deathObserver);
        observers.add(levelUpObserver);
        warriorCreator = new WarriorCreator(observers);
        healerCreator = new HealerCreator(observers);
        wizardCreator = new WizardCreator(observers);
    }

    public void createTeam(String name) {
        if (isNameDefined(name))
            return;
        Team t = new Team(name);
        teams.put(name, t);

    }

    public void createWizard(String name, int level) {
        if (isNameDefined(name))
            return;
        GameCharacter character = wizardCreator.createCharacter(name, level, true, true);
        gameCharacters.put(name, character);
    }

    public void createWarrior(String name, int level) {
        if (isNameDefined(name))
            return;
        GameCharacter character = warriorCreator.createCharacter(name, level, true, true);
        gameCharacters.put(name, character);
    }

    public void createHealer(String name, int level) {
        if (isNameDefined(name))
            return;
        GameCharacter character = healerCreator.createCharacter(name, level, true, true);
        gameCharacters.put(name, character);
    }

    public void addToTeam(String charName, String teamName) {
        if (!gameCharacters.containsKey(charName) || !teams.containsKey(teamName))
            return;
        try {
            teams.get(teamName).addPlayer(gameCharacters.get(charName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void useVisitor(String name, CharacterVisitor v) {
        if (teams.containsKey(name)) {
            teams.get(name).accept(v);
        } else if (gameCharacters.containsKey(name)) {
            gameCharacters.get(name).accept(v);
        }
    }

    public void setStrategy(String name, Strategy strategy) {
        if (teams.containsKey(name)) {
            teams.get(name).setStrategy(strategy);
        } else if (gameCharacters.containsKey(name)) {
            gameCharacters.get(name).setStrategy(strategy);
        }
    }
    public void attack(String attackerName, String targetName) {
        GameCharacter attacker = get(attackerName);
        GameCharacter target = get(targetName);
        if (attacker == null || target == null) return;
        CharacterVisitor visitor = new DamageVisitor(attacker.getDamage());
        target.accept(visitor);
    }

    public void delete(String name) {
        if (teams.containsKey(name)) {
            teams.remove(name);
        }
        else if (gameCharacters.containsKey(name)) {
            GameCharacter character = gameCharacters.remove(name);
            for (Team t : teams.values()) {
                t.removePlayer(character);
            }
        }
    }

    private boolean isNameDefined(String name) {
        return gameCharacters.containsKey(name) || teams.containsKey(name);
    }

    private GameCharacter get(String name) {
        if (teams.containsKey(name)) {
            return teams.get(name);
        } else return gameCharacters.getOrDefault(name, null);
    }
}
