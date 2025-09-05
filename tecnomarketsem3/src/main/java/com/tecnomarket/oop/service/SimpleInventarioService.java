package com.tecnomarket.oop.service;

import com.tecnomarket.oop.model.Producto;

public class SimpleInventarioService implements InventarioService {
    @Override
    public boolean hayStockSuficiente(Producto p, int cantidad) { return p.getStock() >= cantidad; }

    @Override
    public void descontarStock(Producto p, int cantidad) {
        if (!hayStockSuficiente(p, cantidad)) throw new IllegalArgumentException("Stock insuficiente");
        p.setStock(p.getStock() - cantidad);
    }

    @Override
    public void ajustarStock(Producto p, int delta) {
        int nuevo = p.getStock() + delta;
        if (nuevo < 0) throw new IllegalArgumentException("Resultado de stock negativo");
        p.setStock(nuevo);
    }
}
