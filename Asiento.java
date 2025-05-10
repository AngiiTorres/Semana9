/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg9;


public class Asiento {

    String identificador;
    boolean ocupado;

    public Asiento(String identificador) {
        this.identificador = identificador;
        this.ocupado = false;
    }

    public String getIdentificador() {
        return identificador;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar() {
        this.ocupado = true;
    }

    public String toString() {
        return identificador + (ocupado ? " (Ocupado)" : " (Libre)");
    }
} 
