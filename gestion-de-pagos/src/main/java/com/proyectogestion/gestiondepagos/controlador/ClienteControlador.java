package com.proyectogestion.gestiondepagos.controlador;

import com.proyectogestion.gestiondepagos.excepcion.RecursoNoEncontradoEx;
import com.proyectogestion.gestiondepagos.modelo.Cliente;
import com.proyectogestion.gestiondepagos.servicio.ClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-de-pagos")
@CrossOrigin(value= "http://localhost:3000")
public class ClienteControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(ClienteControlador.class);
    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/clientes")
    public List<Cliente> obtenerProveedor(){
        var clientes = clienteServicio.listarClientes();

        clientes.forEach(cliente -> logger.info(clientes.toString()));
        return clientes;
    }
    @PostMapping("/clientes")
    public Cliente agregarProveedor(@RequestBody Cliente clientes){
        logger.info("Cliente a agregar: "+ clientes);
        return clienteServicio.registrarCliente(clientes);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente>
        obtenerProveedorPorID(@PathVariable Integer id) {
        Cliente clientes= clienteServicio.buscarClientePorId(id);
        if (clientes == null) {
            //no funciona, o no se donde se muestra el mensaje
            throw new RecursoNoEncontradoEx
                    ("No se encontró el id: " + id);
        }
        return ResponseEntity.ok(clientes);
        }
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente>
    editarclientes(@PathVariable Integer id,
                    @RequestBody Cliente clientesRecibido){
        Cliente clientes = clienteServicio.buscarClientePorId(id);
        if(clientes == null)
            throw new RecursoNoEncontradoEx("Id no encontrado: " + id);
        return null;
    }
}
