
package com.gestiondepagos.gestionPagos;

public class Proveedor {
    
    private int id_proveedor;
    private String nombre_proveedor;
    private Long cuit_proveedor;
    private String direccion_proveedor;
    private Long telefono_proveedor;
    private String razon_social_proveedor;
    private String correo_electronico_proveedor;

    public Proveedor() {
    }

    public Proveedor(int id_proveedor, String nombre_proveedor, Long cuit_proveedor, String direccion_proveedor, Long telefono_proveedor, String razon_social_proveedor, String correo_electronico_proveedor) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.cuit_proveedor = cuit_proveedor;
        this.direccion_proveedor = direccion_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.razon_social_proveedor = razon_social_proveedor;
        this.correo_electronico_proveedor = correo_electronico_proveedor;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public Long getCuit_proveedor() {
        return cuit_proveedor;
    }

    public void setCuit_proveedor(Long cuit_proveedor) {
        this.cuit_proveedor = cuit_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public Long getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(Long telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public String getRazon_social_proveedor() {
        return razon_social_proveedor;
    }

    public void setRazon_social_proveedor(String razon_social_proveedor) {
        this.razon_social_proveedor = razon_social_proveedor;
    }

    public String getCorreo_electronico_proveedor() {
        return correo_electronico_proveedor;
    }

    public void setCorreo_electronico_proveedor(String correo_electronico_proveedor) {
        this.correo_electronico_proveedor = correo_electronico_proveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_proveedor=" + id_proveedor + ", nombre_proveedor=" + nombre_proveedor + ", cuit_proveedor=" + cuit_proveedor + ", direccion_proveedor=" + direccion_proveedor + ", telefono_proveedor=" + telefono_proveedor + ", razon_social_proveedor=" + razon_social_proveedor + ", correo_electronico_proveedor=" + correo_electronico_proveedor + '}';
    }
    
     
   
}
