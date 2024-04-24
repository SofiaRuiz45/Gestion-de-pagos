
package com.gestiondepagos.gestionPagos;

public class Entidad {
    
    private int id_identidad;
    private String nombre_entidad;
    private long cuit_entidad;
    private String razon_social_entidad;
    private String direccion_entidad;

    public Entidad() {
    }

    public Entidad(int id_identidad, String nombre_entidad, long cuit_entidad, String razon_social_entidad, String direccion_entidad) {
        this.id_identidad = id_identidad;
        this.nombre_entidad = nombre_entidad;
        this.cuit_entidad = cuit_entidad;
        this.razon_social_entidad = razon_social_entidad;
        this.direccion_entidad = direccion_entidad;
    }

    public int getId_identidad() {
        return id_identidad;
    }

    public void setId_identidad(int id_identidad) {
        this.id_identidad = id_identidad;
    }

    public String getNombre_entidad() {
        return nombre_entidad;
    }

    public void setNombre_entidad(String nombre_entidad) {
        this.nombre_entidad = nombre_entidad;
    }

    public long getCuit_entidad() {
        return cuit_entidad;
    }

    public void setCuit_entidad(long cuit_entidad) {
        this.cuit_entidad = cuit_entidad;
    }

    public String getRazon_social_entidad() {
        return razon_social_entidad;
    }

    public void setRazon_social_entidad(String razon_social_entidad) {
        this.razon_social_entidad = razon_social_entidad;
    }

    public String getDireccion_entidad() {
        return direccion_entidad;
    }

    public void setDireccion_entidad(String direccion_entidad) {
        this.direccion_entidad = direccion_entidad;
    }

    @Override
    public String toString() {
        return "Entidad{" + "id_identidad=" + id_identidad + ", nombre_entidad=" + nombre_entidad + ", cuit_entidad=" + cuit_entidad + ", razon_social_entidad=" + razon_social_entidad + ", direccion_entidad=" + direccion_entidad + '}';
    }
    
    
    
}
