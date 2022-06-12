package fr.endoskull.EndoSkullSpring.utils;

import fr.endoskull.EndoSkullSpring.EndoSkullSpringApplication;

import java.util.Timer;
import java.util.TimerTask;

public class TokenClearTask {
    Timer timer;

    public TokenClearTask(int minutes) {
        timer = new Timer();
        timer.schedule(new RemindTask(), (long) minutes*60*1000, (long) minutes*60*1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            for (String s : EndoSkullSpringApplication.getTokens().keySet()) {
                EndoSkullSpringApplication.getTokens().put(s, 0);
            }
        }
    }
}