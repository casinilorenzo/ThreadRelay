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
        this.id       = id;
        this.monitor  = monitor;
        this.contatori = contatori;
        this.velocita  = velocita;
    }

}

