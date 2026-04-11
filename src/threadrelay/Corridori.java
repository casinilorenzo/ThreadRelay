/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author loren
 */
public class Corridori implements Runnable {

    private final int id;
    private final Monitor monitor;
    private final int[] contatori;
    private int velocita;
    private boolean finito = false;

    public Corridori(int id, Monitor monitor, int[] contatori, int velocita) {
        this.id = id;
        this.monitor = monitor;
        this.contatori = contatori;
        this.velocita = velocita;
    }

    public int getVelocita() {
        return velocita;
    }

    public void setVelocita(int velocita) {
        this.velocita = velocita;
    }

    public boolean isFinito() {
        return finito;
    }

    public void setFinito(boolean finito) {
        this.finito = finito;
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public void run() {
        try {
            monitor.waitForTurn(id);
            for (int i = 0; i <= 99; i++) {
                monitor.waitForTurn(id);
                contatori[id - 1] = i;
                if (i == 90 && id < 4) {
                    monitor.passaTestimone(id + 1);
                }

                Thread.sleep(velocita);
            }
            finito = true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
