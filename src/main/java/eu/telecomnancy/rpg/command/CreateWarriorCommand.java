package eu.telecomnancy.rpg.command;

public class CreateWarriorCommand implements Command {
    private  final Facade facade;
    private final String name;
    private final int level;

    public CreateWarriorCommand(Facade facade, String name, int level) {
        this.facade = facade;
        this.name = name;
        this.level = level;
    }

    @Override
    public void execute() {
        facade.createWarrior(name, level);
    }
}
