package com.proyectogestion.gestiondepagos.servicio;
import com.proyectogestion.gestiondepagos.modelo.Proveedor;
import java.util.List;

public interface IProveedorServicio {
    public List<Proveedor> listarProveedor();

    public Proveedor registrarProveedor(Proveedor proveedor);

    public void eliminarProveedor(Proveedor proveedor);

    public Proveedor buscarProveedorPorId(Integer id_proveedor);
}
