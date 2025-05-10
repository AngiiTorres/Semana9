/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg9;


public class Cliente {

    String nombre;
    int edad;
    String tipoCliente; // niño, mujer, estudiante, tercera edad, general

    public Cliente(String nombre, int edad, String tipoCliente) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoCliente = tipoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }
}

