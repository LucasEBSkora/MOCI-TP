package eu.telecomnancy.rpg.command;

public class AttackCommand implements Command {
    private final Facade facade;
    private final String attackerName;
    private final String targetName;

    public AttackCommand(Facade facade, String attackerName, String targetName) {
        this.facade = facade;
        this.attackerName = attackerName;
        this.targetName = targetName;
    }

    @Override
    public void execute() {
        facade.attack(attackerName, targetName);
    }
}
