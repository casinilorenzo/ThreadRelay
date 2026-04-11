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

    public synchronized void waitForTurn(int myId) throws InterruptedException {
        while (Id > currentRunner || paused || stopped) {
            if (stopped) {
                throw new InterruptedException("Fermato");
            }
            wait();
        }
    }
    
}
