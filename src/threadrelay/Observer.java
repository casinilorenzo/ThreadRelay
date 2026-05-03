/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 * Interfaccia Observer.
 * Ogni classe che vuole ricevere notifiche deve implementarla.
 */
public interface Observer {
    /**
     * Chiamato dal Subject quando il suo stato cambia.
     * @param contatori il nuovo valore dello stato
     */
    void update(int[] contatori);
}