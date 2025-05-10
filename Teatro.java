/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Teatro {

    String nombre;
    Map<String, Seccion> secciones;

    public Teatro(String nombre) {
        this.nombre = nombre;
        this.secciones = new HashMap<>();
        // Inicialización de secciones y asientos (ejemplo)
        List<String> asientosVip = List.of("VIP-A1", "VIP-A2", "VIP-B1", "VIP-B2");
        secciones.put("vip", new Seccion("VIP", 50.0, asientosVip));
        List<String> asientosPalco = List.of("PAL-1", "PAL-2", "PAL-3", "PAL-4");
        secciones.put("palco", new Seccion("Palco", 40.0, asientosPalco));
        List<String> asientosPlateaBaja = List.of("PB-1", "PB-2", "PB-3", "PB-4", "PB-5", "PB-6");
        secciones.put("platea baja", new Seccion("Platea Baja", 30.0, asientosPlateaBaja));
        List<String> asientosPlateaAlta = List.of("PA-1", "PA-2", "PA-3", "PA-4", "PA-5", "PA-6");
        secciones.put("platea alta", new Seccion("Platea Alta", 25.0, asientosPlateaAlta));
        List<String> asientosGaleria = List.of("GAL-1", "GAL-2", "GAL-3", "GAL-4", "GAL-5", "GAL-6", "GAL-7", "GAL-8");
        secciones.put("galeria", new Seccion("Galería", 20.0, asientosGaleria));
    }

    public void mostrarSecciones() {
        System.out.println("Secciones disponibles:");
        for (String nombreSeccion : secciones.keySet()) {
            System.out.println("- " + nombreSeccion);
        }
    }

    public Seccion obtenerSeccion(String nombreSeccion) {
        return secciones.get(nombreSeccion.toLowerCase());
    }

    public void mostrarAsientosDisponibles(String nombreSeccion) {
        Seccion seccion = obtenerSeccion(nombreSeccion.toLowerCase());
        if (seccion != null) {
            seccion.mostrarAsientosDisponibles();
        } else {
            System.out.println("Sección no válida.");
        }
    }
}
