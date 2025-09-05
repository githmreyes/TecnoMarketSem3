package com.tecnomarket.oop.exceptions;

public class SinStockException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public SinStockException(String producto) { super("No hay stock suficiente para: " + producto); }
}
