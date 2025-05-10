/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg9;

/**
 *
 * @author Torre
 */
public class VentaEntrada {

    Cliente cliente;
    Asiento asiento;
    Seccion seccion;
    double precioBase;
    double descuento;
    double precioFinal;

    public VentaEntrada(Cliente cliente, Asiento asiento, Seccion seccion, double precioBase, double descuento) {
        this.cliente = cliente;
        this.asiento = asiento;
        this.seccion = seccion;
        this.precioBase = precioBase;
        this.descuento = descuento;
        this.precioFinal = precioBase * (1 - descuento);
    }

    public void imprimirBoleta() {
        System.out.println("\n--- Boleta de Entrada ---");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Edad: " + cliente.getEdad());
        System.out.println("Tipo de Cliente: " + cliente.getTipoCliente());
        System.out.println("Sección: " + seccion.getNombre());
        System.out.println("Asiento: " + asiento.getIdentificador());
        System.out.println("Precio Base: $" + String.format("%.2f", precioBase));
        System.out.println("Descuento: " + String.format("%.2f", descuento * 100) + "%");
        System.out.println("Precio Final: $" + String.format("%.2f", precioFinal));
        System.out.println("¡Disfrute la función!");
        System.out.println("-------------------------\n");
    }
}