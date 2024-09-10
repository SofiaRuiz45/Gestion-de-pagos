package com.proyectogestion.gestiondepagos.controlador;

import com.proyectogestion.gestiondepagos.excepcion.RecursoNoEncontradoEx;
import com.proyectogestion.gestiondepagos.modelo.Proveedor;
import com.proyectogestion.gestiondepagos.servicio.ProveedorServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-de-pagos")
@CrossOrigin(value= "http://localhost:3000")
public class ProveedorControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(ProveedorControlador.class);
    @Autowired
    private ProveedorServicio proveedorServicio;

    @GetMapping("/proveedor")
    public List<Proveedor> obtenerProveedor(){
        var proveedores = proveedorServicio.listarProveedor();

        proveedores.forEach(proveedor -> logger.info(proveedor.toString()));
        return proveedores;
    }
    @PostMapping("/proveedor")
    public Proveedor agregarProveedor(@RequestBody Proveedor proveedor){
        logger.info("Provedor a agregar: "+ proveedor);
        return proveedorServicio.registrarProveedor(proveedor);
    }

    @GetMapping("/proveedor/{id}")
    public ResponseEntity<Proveedor>
        obtenerProveedorPorID(@PathVariable Integer id) {
        Proveedor proveedor= proveedorServicio.buscarProveedorPorId(id);
        if (proveedor == null) {
            //no funciona, o no se donde se muestra el mensaje
            throw new RecursoNoEncontradoEx
                    ("No se encontró el id: " + id);
        }
        return ResponseEntity.ok(proveedor);
        }
    @PutMapping("/proveedor/{id}")
    public ResponseEntity<Proveedor>
    editarProveedor(@PathVariable Integer id,
                    @RequestBody Proveedor proveedorRecibido){
        Proveedor proveedor = proveedorServicio.buscarProveedorPorId(id);
        if(proveedor == null)
            throw new RecursoNoEncontradoEx("Id no encontrado: " + id);
        return null;
    }
}
