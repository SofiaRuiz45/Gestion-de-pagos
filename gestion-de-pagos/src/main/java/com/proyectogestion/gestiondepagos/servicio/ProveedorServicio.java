package com.proyectogestion.gestiondepagos.servicio;
import com.proyectogestion.gestiondepagos.modelo.Proveedor;
import com.proyectogestion.gestiondepagos.repositorio.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServicio implements IProveedorServicio{
    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    @Override
    public List<Proveedor> listarProveedor() {
        return proveedorRepositorio.findAll();
    }

    @Override
    public Proveedor registrarProveedor(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    @Override
    public void eliminarProveedor(Proveedor proveedor) {
    }

    @Override
    public Proveedor buscarProveedorPorId(Integer id_proveedor) {
        return null;
    }
}
