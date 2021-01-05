package core;

import lib.Browser;
import lib.Tasks;

import java.util.Date;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Browser.Login.withDiscord();
        Browser.Client.waitForChannel("400324240278159360", "613356875764858880");

        Tasks tasks = new Tasks(new String[]{"loot", "fish", "roll"}, "-");
        Timer timer = new Timer();
        timer.schedule(tasks, new Date(System.currentTimeMillis()), 200000);
    }
}
