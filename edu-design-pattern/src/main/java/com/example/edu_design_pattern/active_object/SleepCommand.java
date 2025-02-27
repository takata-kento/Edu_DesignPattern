package com.example.edu_design_pattern.active_object;

public class SleepCommand implements Command{
    private final Command wakeupCommand;
    private final ActiveObjectEngine engine;
    private final long sleepTime;
    private long startTime;
    private boolean isStart = false;

    public SleepCommand(Command wakeupCommand, ActiveObjectEngine engine, long sleepTime) {
        this.wakeupCommand = wakeupCommand;
        this.engine = engine;
        this.sleepTime = sleepTime;
    }

    @Override
    public void execute() {
        long currentTime = System.currentTimeMillis();

        if (!isStart) {
            isStart = true;
            startTime = currentTime;
            engine.addCommand(this);
        }
        else if ((currentTime - startTime) < sleepTime) {
            engine.addCommand(this);
        }
        else {
            engine.addCommand(wakeupCommand);
        }
    }
}
