package eu.telecomnancy.rpg.command;

public class AddCharacterToTeamCommand implements Command {
    private final Facade facade;
    private final String characterName;

    private final String teamName;

    public AddCharacterToTeamCommand(Facade facade, String characterName, String teamName) {
        this.facade = facade;
        this.characterName = characterName;
        this.teamName = teamName;
    }

    @Override
    public void execute() {
        facade.addToTeam(characterName, teamName);
    }
}
