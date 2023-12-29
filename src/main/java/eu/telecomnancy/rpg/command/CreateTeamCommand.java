package eu.telecomnancy.rpg.command;

public class CreateTeamCommand implements Command {
    private final Facade facade;
    private final String name;

    public CreateTeamCommand(Facade facade, String name) {
        this.facade = facade;
        this.name = name;
    }

    @Override
    public void execute() {
        facade.createTeam(name);
    }
}
