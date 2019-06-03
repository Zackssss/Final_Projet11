package entity;
/**
import java.util.Observable;

public class HudInfo extends Observable {

    private int score;
    private int remainingsDiamonds;
    private int timer;
    static Thread thread = new Thread();

    public HudInfo(int remainingsDiamonds) {
        this.score = 0;
        this.remainingsDiamonds = remainingsDiamonds;
        this.timer = 0;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRemainingsDiamonds() {
        return remainingsDiamonds;
    }

    public void setRemainingsDiamonds(int remainingDiamonds) {
        this.remainingsDiamonds = remainingDiamonds;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void incrementScore() {
        this.score += 15;
        this.myNotify();
    }

    public void decrementTimer() throws InterruptedException {
        for(int i = 60; i>0; i--){
            thread.sleep(1000);
            this.myNotify();
        }
    }

    private void myNotify() {
        this.notifyObservers();
        this.setChanged();
    }
    public void decrementRemainingsDiamonds() {
        if(remainingsDiamonds > 0){
            this.remainingsDiamonds -= 1;
            this.myNotify();
        }
    }

    public void resetInformations() {
        this.score = 0;
        this.remainingsDiamonds = remainingsDiamonds;
        this.timer = 0;
    }

}*/
