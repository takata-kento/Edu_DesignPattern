package com.example.edu_design_pattern.active_object;

public class DelayedTyperCommand implements Command{
    private long delayTime;
    private char typingChar;
    private ActiveObjectEngine engine;
    private static boolean stop = false;

    public DelayedTyperCommand(long delayTime, char typingChar, ActiveObjectEngine engine) {
        this.delayTime = delayTime;
        this.typingChar = typingChar;
        this.engine = engine;
    }

    @Override
    public void execute() {
        System.out.print(typingChar);
        if (!stop) {
            engine.addCommand(new SleepCommand(this, engine, delayTime));
        }
    }

    public static void stopExecute() {
        stop = true;
    }
}
