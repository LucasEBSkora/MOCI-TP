package eu.telecomnancy.rpg.command;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class GameInvoker {
    private final Queue<Command> commands;
    private final int capacity = 10;
    public GameInvoker() {
        commands = new ArrayBlockingQueue<>(capacity);
    }

    public void enqueueCommand(Command c) {
        if (commands.size() >= capacity) {
            execute();
        }
        commands.add(c);
    }

    public void execute() {
        Command c = commands.poll();
        while (c != null) {
            c.execute();
            c = commands.poll();
        }
    }

}
