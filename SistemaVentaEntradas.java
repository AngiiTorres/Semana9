/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SistemaVentaEntradas {

    private Teatro teatro;
    private Scanner scanner;
    private List<VentaEntrada> historialVentas;

    public SistemaVentaEntradas(String nombreTeatro) {
        this.teatro = new Teatro(nombreTeatro);
        this.scanner = new Scanner(System.in);
        this.historialVentas = new ArrayList<>();
    }

    public double calcularDescuento(Cliente cliente) {
        if (cliente.getEdad() < 12) {
            return 0.10; // Niño
        } else if (cliente.getTipoCliente().equalsIgnoreCase("mujer")) {
            return 0.20; // Mujer
        } else if (cliente.getTipoCliente().equalsIgnoreCase("estudiante")) {
            return 0.15; // Estudiante
        } else if (cliente.getEdad() >= 65) {
            return 0.25; // Tercera Edad
        } else {
            return 0.0; // General
        }
    }

    public void venderEntrada() {
        System.out.println("\n--- Nueva Venta de Entrada ---");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        int edad = -1;
        while (edad < 0) {
            System.out.print("Ingrese su edad: ");
            if (scanner.hasNextInt()) {
                edad = scanner.nextInt();
                scanner.nextLine(); 
                if (edad < 0) {
                    System.out.println("La edad no puede ser negativa.");
                }
            } else {
                System.out.println("Entrada no válida. Ingrese un número para la edad.");
                scanner.nextLine(); // entrada no válida
            }
        }

        System.out.print("Ingrese su tipo de cliente (niño, mujer, estudiante, tercera edad, general): ");
        String tipoCliente = scanner.nextLine().toLowerCase();

        Cliente cliente = new Cliente(nombre, edad, tipoCliente);
        double descuento = calcularDescuento(cliente);

        teatro.mostrarSecciones();
        System.out.print("Seleccione la sección deseada: ");
        String seccionNombre = scanner.nextLine().toLowerCase();
        Seccion seccion = teatro.obtenerSeccion(seccionNombre);

        if (seccion == null) {
            System.out.println("Sección no válida. Venta cancelada.");
            return;
        }

        seccion.mostrarAsientosDisponibles();
        System.out.print("Seleccione un asiento: ");
        String asientoId = scanner.nextLine().toUpperCase();

        if (!seccion.isAsientoValido(asientoId)) {
            System.out.println("Asiento no válido en esta sección. Venta cancelada.");
            return;
        }

        Asiento asiento = seccion.seleccionarAsiento(asientoId);
        if (asiento != null && !asiento.isOcupado()) {
            seccion.asignarAsiento(asientoId);
            VentaEntrada venta = new VentaEntrada(cliente, asiento, seccion, seccion.getPrecioBase(), descuento);
            venta.imprimirBoleta();
            historialVentas.add(venta);
            System.out.println("Venta realizada con éxito.");
        } else if (asiento == null) {
            System.out.println("Asiento no encontrado. Venta cancelada.");
        } else {
            System.out.println("El asiento seleccionado no está disponible. Venta cancelada.");
        }
    }

    public void mostrarHistorialVentas() {
        System.out.println("\n--- Historial de Ventas ---");
        if (historialVentas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            for (VentaEntrada venta : historialVentas) {
                venta.imprimirBoleta();
            }
        }
        System.out.println("---------------------------\n");
    }

    public static void main(String[] args) {
        SistemaVentaEntradas sistema = new SistemaVentaEntradas("Teatro Moro");
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- Sistema de Venta de Entradas ---");
            System.out.println("1. Vender Entrada");
            System.out.println("2. Mostrar Historial de Ventas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        sistema.venderEntrada();
                        break;
                    case 2:
                        sistema.mostrarHistorialVentas();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema. ¡Gracias!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } else {
                System.out.println("Entrada no válida. Ingrese un número para la opción.");
                scanner.nextLine(); 
                opcion = -1; // Para que el bucle continúe
            }
        }
        scanner.close();
    }
}