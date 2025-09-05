package com.tecnomarket.oop.model;

public class ProductoFisico extends Producto {
    private double pesoKg;
    private double altoCm;
    private double anchoCm;
    private double largoCm;

    public ProductoFisico(String id, String nombre, String descripcion, java.math.BigDecimal precio, int stock,
                          double pesoKg, double altoCm, double anchoCm, double largoCm) {
        super(id, nombre, descripcion, precio, stock);
        setPesoKg(pesoKg);
        setAltoCm(altoCm);
        setAnchoCm(anchoCm);
        setLargoCm(largoCm);
    }
    @Override
    public boolean requiereEnvio() { return true; }

    public double getPesoKg() { return pesoKg; }
    public void setPesoKg(double pesoKg) {
        if (pesoKg < 0) throw new IllegalArgumentException("pesoKg inválido");
        this.pesoKg = pesoKg;
    }
    public double getAltoCm() { return altoCm; }
    public void setAltoCm(double altoCm) { if (altoCm <= 0) throw new IllegalArgumentException("alto inválido"); this.altoCm = altoCm; }
    public double getAnchoCm() { return anchoCm; }
    public void setAnchoCm(double anchoCm) { if (anchoCm <= 0) throw new IllegalArgumentException("ancho inválido"); this.anchoCm = anchoCm; }
    public double getLargoCm() { return largoCm; }
    public void setLargoCm(double largoCm) { if (largoCm <= 0) throw new IllegalArgumentException("largo inválido"); this.largoCm = largoCm; }

    public double calcularCostoEnvio(double tarifaBase, double costoPorKg, double costoVolumetrico) {
        double volumenDm3 = (altoCm * anchoCm * largoCm) / 1000.0;
        return tarifaBase + (costoPorKg * pesoKg) + (costoVolumetrico * volumenDm3);
    }
}
