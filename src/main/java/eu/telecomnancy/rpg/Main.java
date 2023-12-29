package eu.telecomnancy.rpg;

import eu.telecomnancy.rpg.command.Command;
import eu.telecomnancy.rpg.command.Facade;
import eu.telecomnancy.rpg.command.GameInvoker;

import java.io.Console;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static Facade facade;
    private static GameInvoker invoker;
    public static void main(String[] args) {
        facade = new Facade();
        invoker = new GameInvoker();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            if (parts.length == 0) continue;
            if (Objects.equals(parts[0], "exit")) {
                break;
            } else
                parseCommand(parts);
        }
    }

    private static void parseCommand(String[] command) {

        switch (command[0]) {
            case "create":
                parseCreateCommand(command);
                break;
            case "add":
                parseAddCommand(command);
                break;
            case "attack":
                parseAttackCommand(command);
                break;
            case "buff":
                parseBuffCommand(command);
                break;
            case "delete":
                parseDeleteCommand(command);
                break;
            default:
                System.out.println(command[0] + " not valid command start!");
        }

    }

    private static void parseDeleteCommand(String[] command) {
    }

    private static void parseBuffCommand(String[] command) {

    }

    private static void parseAttackCommand(String[] command) {

    }

    private static void parseAddCommand(String[] command) {

    }

    private static void parseCreateCommand(String[] command) {

    }
}
