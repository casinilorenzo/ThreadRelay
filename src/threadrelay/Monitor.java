/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author loren
 */
public class Monitor implements Subject {

    private int currentRunner = 1;
    private boolean paused = false;
    private boolean stopped = false;
    private final List<Observer> observers = new ArrayList<>();
    private int[] ultimiContatori = new int[4];

    public synchronized void waitForTurn(int Id) throws InterruptedException {
        while (Id != currentRunner || paused || stopped) {
            if (stopped) {
                throw new InterruptedException("Fermato");
            }
            wait();
        }
    }

    public synchronized void checkPaused() throws InterruptedException {
        while (paused) {
            if (stopped) {
                throw new InterruptedException("Fermato");
            }
            wait();
        }
        if (stopped) {
            throw new InterruptedException("Fermato");
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

    @Override
    public synchronized void addObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public synchronized void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public synchronized void notifyObservers() {
        int[] copia = ultimiContatori.clone();
        List<Observer> copiaObs = new ArrayList<>(observers);
        for (Observer o : copiaObs) {
            o.update(copia);
        }
    }

    public synchronized void aggiornaContatori(int id, int valore) {
        ultimiContatori[id - 1] = valore;
        notifyObservers();
    }

}
