package com.tecnomarket.oop.service;

import com.tecnomarket.oop.model.Producto;

public interface InventarioService {
    boolean hayStockSuficiente(Producto p, int cantidad);
    void descontarStock(Producto p, int cantidad);
    void ajustarStock(Producto p, int delta);
}
