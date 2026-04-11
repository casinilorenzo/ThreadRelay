/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author loren
 */
public class Monitor {

    private int currentRunner = 1;
    private boolean paused = false;
    private boolean stopped = false;

    public synchronized void waitForTurn(int Id) throws InterruptedException {
        while (Id > currentRunner || paused || stopped) {
            if (stopped) {
                throw new InterruptedException("Fermato");
            }
            wait();
        }
    }
    
    public synchronized void sospendi() {
        paused = true;
    }

    public synchronized void riprendi() {
        paused = false;
        notifyAll();
    }

    public synchronized void ferma() {
        stopped = true;
        notifyAll();  
    }

    public synchronized boolean isStopped() {
        return stopped;
    }
    
    public synchronized void passaTestimone(int nextId) {
        currentRunner = nextId;
        notifyAll();
    }

}
