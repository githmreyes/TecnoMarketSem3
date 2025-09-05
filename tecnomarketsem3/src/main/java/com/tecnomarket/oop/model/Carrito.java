package com.tecnomarket.oop.model;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.tecnomarket.oop.exceptions.SinStockException;
import com.tecnomarket.oop.service.InventarioService;

public class Carrito {
    private final Map<Producto, Integer> items = new LinkedHashMap<>();

    public void agregarProducto(Producto p, int cantidad, InventarioService inventario) {
        Objects.requireNonNull(p);
        if (cantidad <= 0) throw new IllegalArgumentException("cantidad inválida");
        if (!inventario.hayStockSuficiente(p, cantidad)) throw new SinStockException(p.getNombre());
        items.merge(p, cantidad, Integer::sum);
    }
    public void eliminarProducto(Producto p) { items.remove(p); }
    public Map<Producto, Integer> getItems() { return Map.copyOf(items); }

    public BigDecimal total() {
        BigDecimal total = BigDecimal.ZERO;
        for (var e : items.entrySet()) {
            total = total.add(e.getKey().getPrecio().multiply(BigDecimal.valueOf(e.getValue())));
        }
        return total;
    }

    public Pedido checkout(Cliente cliente, InventarioService inventario) {
        Objects.requireNonNull(cliente);
        if (items.isEmpty()) throw new IllegalStateException("carrito vacío");
        for (var e : items.entrySet()) inventario.descontarStock(e.getKey(), e.getValue());
        Pedido pedido = Pedido.crearDesdeCarrito(cliente, items, total());
        cliente.registrarCompra(pedido);
        items.clear();
        return pedido;
    }
}
