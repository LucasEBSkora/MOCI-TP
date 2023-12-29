package eu.telecomnancy.rpg.command;

import eu.telecomnancy.rpg.visitor.BuffVisitor;

public class BuffTeamCommand implements Command {
    private final Facade facade;
    private final String targetName;
    private final int amount;

    public BuffTeamCommand(Facade facade, String targetName, int amount) {
        this.facade = facade;
        this.targetName = targetName;
        this.amount = amount;
    }

    @Override
    public void execute() {
        facade.useVisitor(targetName, new BuffVisitor(amount));
    }
}
