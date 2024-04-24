
package com.gestiondepagos.gestionPagos;

public class Pago {
    
    private int id_pago;
    private long nro_pago;
    private String fecha_pago;
    private String tipo_pago;
    private double monto;

    public Pago() {
    }

    
    
    public Pago(int id_pago, long nro_pago, String fecha_pago, String tipo_pago, double monto) {
        this.id_pago = id_pago;
        this.nro_pago = nro_pago;
        this.fecha_pago = fecha_pago;
        this.tipo_pago = tipo_pago;
        this.monto = monto;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public long getNro_pago() {
        return nro_pago;
    }

    public void setNro_pago(long nro_pago) {
        this.nro_pago = nro_pago;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Pago{" + "id_pago=" + id_pago + ", nro_pago=" + nro_pago + ", fecha_pago=" + fecha_pago + ", tipo_pago=" + tipo_pago + ", monto=" + monto + '}';
    }
    
    
    
}
