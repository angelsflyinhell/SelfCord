package lib;

import java.util.Random;
import java.util.TimerTask;

public class Tasks extends TimerTask {

    public static String[] commands;
    public static String p;

    public Tasks(String[] cmds, String prefix) {
        commands = cmds;
        p = prefix;
    }

    @Override
    public void run() {
        int i = new Random().nextInt(30) + 1000;
        try {
            Thread.sleep(i);
        } catch (InterruptedException ignored) {}
        Browser.Client.sendMessage(p + commands[0]);
        try {
            Thread.sleep(2103);
        } catch (InterruptedException ignored) {}
        Browser.Client.sendMessage(p + commands[1]);
        try {
            Thread.sleep(1937);
        } catch (InterruptedException ignored) {}
        Browser.Client.sendMessage(p + commands[2]);
    }
}
