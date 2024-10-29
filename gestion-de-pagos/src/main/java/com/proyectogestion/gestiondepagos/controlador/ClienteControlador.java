package com.proyectogestion.gestiondepagos.controlador;

import com.proyectogestion.gestiondepagos.excepcion.RecursoNoEncontradoEx;
import com.proyectogestion.gestiondepagos.modelo.Cliente;
import com.proyectogestion.gestiondepagos.servicio.ClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return clienteServicio.registrarClientes(clientes);
    }
    //buscar cliente
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
        //actualizar entidad
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente>
    editarclientes(@PathVariable Integer id, @RequestBody Cliente clienteRecibido){
        Cliente cliente = clienteServicio.buscarClientePorId(id);
        if(cliente == null)
            throw new RecursoNoEncontradoEx("Id no encontrado: " + id);
        cliente.setNombreCliente(clienteRecibido.getNombreCliente());
        cliente.setRubro(clienteRecibido.getRubro());
        cliente.setCuit_cliente(clienteRecibido.getCuit_cliente());
        cliente.setDireccion_cliente(clienteRecibido.getDireccion_cliente());
        cliente.setTelefono_cliente(clienteRecibido.getTelefono_cliente());
        cliente.setRazon_social_cliente(clienteRecibido.getRazon_social_cliente());
        cliente.setCorreo_electronico_cliente(clienteRecibido.getCorreo_electronico_cliente());

        clienteServicio.registrarClientes(cliente);
        return  ResponseEntity.ok(cliente);
    }
    //eliminar cliente
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCliente(@PathVariable Integer id){
        Cliente cliente = clienteServicio.buscarClientePorId(id);
        if (cliente == null)
            throw new RecursoNoEncontradoEx("Id de cliente no encontrado");
        clienteServicio.eliminarCliente(cliente);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Cliente eliminado", Boolean.TRUE);
        return  ResponseEntity.ok(respuesta);
    }
}
