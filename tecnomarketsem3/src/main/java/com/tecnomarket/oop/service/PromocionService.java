package com.tecnomarket.oop.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.tecnomarket.oop.model.Promocion;
import com.tecnomarket.oop.model.Producto;

public interface PromocionService {
    Promocion crearPromocion(Producto p, double porcentaje, LocalDate finVigencia);
    BigDecimal aplicarPromocion(Producto p, Promocion promocion);
}
