package main;

public abstract class ActionThread extends Thread{
    protected boolean isRunning = true;

    public void stopAction(){
        isRunning = false;
    }
}
