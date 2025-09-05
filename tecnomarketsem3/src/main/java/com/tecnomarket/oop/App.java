package com.tecnomarket.oop;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.tecnomarket.oop.model.*;
import com.tecnomarket.oop.service.*;

public class App {
    public static void main(String[] args) {
        InventarioService inventario = new SimpleInventarioService();
        PromocionService promoSrv = new SimplePromocionService();

        ProductoFisico monitor = new ProductoFisico(
                "P-1001", "Monitor 27\u2033", "IPS 144Hz", new BigDecimal("199.99"), 10,
                4.8, 45, 65, 18);
        ProductoDigital curso = new ProductoDigital(
                "D-2001", "Curso Java Avanzado", "POO, Streams, Concurrencia", new BigDecimal("49.90"), 1000,
                "MP4", 3200, "https://tecnomarket.example.com/descargas/curso-java", "EDU-2025");

        Cliente ana = new Cliente("C-01", "Ana Torres", "ana@example.com", "Secreta#1");
        Administrador admin = new Administrador("A-01", "Admin", "admin@example.com", "ClaveFuerte!");

        Promocion promo = admin.crearPromocion(curso, 20.0, LocalDate.now().plusDays(7), promoSrv);
        var precioPromo = admin.aplicarPromocion(curso, promo, promoSrv);
        System.out.println("Precio con promo para '" + curso.getNombre() + "': " + precioPromo);

        Carrito carrito = new Carrito();
        carrito.agregarProducto(monitor, 2, inventario);
        carrito.agregarProducto(curso, 1, inventario);
        System.out.println("Total carrito: " + carrito.total());

        Pedido pedido = carrito.checkout(ana, inventario);
        pedido.confirmar();
        System.out.println("Pedido creado: " + pedido.getId() + " - total: " + pedido.getTotal());
        System.out.println("Historial de " + ana.getNombre() + ": " + ana.getHistorialCompras().size() + " pedido(s)");

        double costoEnvio = monitor.calcularCostoEnvio(5.0, 1.2, 0.05);
        System.out.println("Costo envío monitor: " + costoEnvio);

        System.out.println("Link de descarga para Ana: " + curso.generarLinkDescarga(ana.getEmail()));
    }
}
