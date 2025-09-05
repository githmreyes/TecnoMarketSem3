package com.tecnomarket.oop.model;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Producto {
    private final String id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;

    protected Producto(String id, String nombre, String descripcion, BigDecimal precio, int stock) {
        this.id = Objects.requireNonNull(id, "id no puede ser nulo");
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setStock(stock);
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre inválido");
        this.nombre = nombre;
    }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = (descripcion == null) ? "" : descripcion; }
    public java.math.BigDecimal getPrecio() { return precio; }
    public void setPrecio(java.math.BigDecimal precio) {
        if (precio == null || precio.signum() < 0) throw new IllegalArgumentException("precio inválido");
        this.precio = precio;
    }
    public int getStock() { return stock; }
    public void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("stock no puede ser negativo");
        this.stock = stock;
    }

    public java.math.BigDecimal precioConDescuento(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) throw new IllegalArgumentException("porcentaje inválido");
        java.math.BigDecimal factor = java.math.BigDecimal.valueOf(1.0 - (porcentaje / 100.0));
        return precio.multiply(factor);
    }

    public abstract boolean requiereEnvio();

    @Override
    public String toString() {
        return "%s{id='%s', nombre='%s', precio=%s, stock=%d}".formatted(
            getClass().getSimpleName(), id, nombre, precio, stock);
    }
}
