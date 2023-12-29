package eu.telecomnancy.rpg.command;

public class CreateHealerCommand implements Command {
    private  final Facade facade;
    private final String name;
    private final int level;

    public CreateHealerCommand(Facade facade, String name, int level) {
        this.facade = facade;
        this.name = name;
        this.level = level;
    }

    @Override
    public void execute() {
        facade.createHealer(name, level);
    }
}
