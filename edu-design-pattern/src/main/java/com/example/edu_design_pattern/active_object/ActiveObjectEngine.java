package com.example.edu_design_pattern.active_object;

import java.util.LinkedList;
import java.util.List;

public class ActiveObjectEngine {
    private List<Command> commands = new LinkedList<>();

    public List<Command> getCommand() {
        return this.commands;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void run() {
        while (!commands.isEmpty()) {
            commands.getFirst().execute();
            commands.removeFirst();
        }
    }
}
