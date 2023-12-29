package eu.telecomnancy.rpg.command;

public class DeleteCommand implements Command {
    private final Facade facade;
    private final String name;

    public DeleteCommand(Facade facade, String name) {
        this.facade = facade;
        this.name = name;
    }

    @Override
    public void execute() {
        facade.delete(name);
    }
}
