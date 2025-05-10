/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Seccion {

    String nombre;
    double precioBase;
    Map<String, Asiento> asientos;

    public Seccion(String nombre, double precioBase, List<String> identificadoresAsientos) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.asientos = new HashMap<>();
        for (String id : identificadoresAsientos) {
            this.asientos.put(id, new Asiento(id));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void mostrarAsientosDisponibles() {
        System.out.println("Asientos disponibles en " + nombre + ":");
        for (Asiento asiento : asientos.values()) {
            if (!asiento.isOcupado()) {
                System.out.print(asiento + "  ");
            }
        }
        System.out.println();
    }

    public Asiento seleccionarAsiento(String identificador) {
        return asientos.get(identificador);
    }

    public boolean asignarAsiento(String identificador) {
        Asiento asiento = asientos.get(identificador);
        if (asiento != null && !asiento.isOcupado()) {
            asiento.ocupar();
            return true;
        }
        return false;
    }

    public boolean isAsientoValido(String identificador) {
        return asientos.containsKey(identificador);
    }
}
