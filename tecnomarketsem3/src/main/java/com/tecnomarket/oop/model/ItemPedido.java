package com.tecnomarket.oop.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemPedido {
    private final Producto producto;
    private final int cantidad;
    private final BigDecimal precioUnitario;

    public ItemPedido(Producto producto, int cantidad, BigDecimal precioUnitario) {
        this.producto = Objects.requireNonNull(producto);
        if (cantidad <= 0) throw new IllegalArgumentException("cantidad inválida");
        this.cantidad = cantidad;
        this.precioUnitario = Objects.requireNonNull(precioUnitario);
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public BigDecimal getSubtotal() { return precioUnitario.multiply(BigDecimal.valueOf(cantidad)); }
}
