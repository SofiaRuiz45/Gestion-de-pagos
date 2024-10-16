package com.proyectogestion.gestiondepagos.controlador;


import com.proyectogestion.gestiondepagos.excepcion.RecursoNoEncontradoEx;
import com.proyectogestion.gestiondepagos.modelo.Cliente;
import com.proyectogestion.gestiondepagos.modelo.Factura;
import com.proyectogestion.gestiondepagos.servicio.FacturaServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-de-pagos")
@CrossOrigin(value = "http://localhost:3000")
public class FacturaControlador {
    private static final Logger logger = LoggerFactory.getLogger(FacturaControlador.class);

    @Autowired
    private FacturaServicio facturaServicio;
    //obtener las facturas en este caso todas, sin distinción de clientes
    @GetMapping("/facturas")
    public List<Factura> obtenerFacturas(){
        var facturas = facturaServicio.listarFacturas();
        facturas.forEach((factura -> logger.info(factura.toString())));
        return facturas;
    }
    //generar/cargar una factura
    @PostMapping("/facturas")
    public Factura agregarFactura(@RequestBody Factura factura){
        logger.info("Factura a agregar: "+factura);
        return facturaServicio.registrarFactura(factura);
    }
    //buscar la factura por el id
    @GetMapping("/factura/{id}")
    public ResponseEntity<Factura> obtenerFactPorId(@PathVariable Integer id){
        Factura factura = facturaServicio.buscarFacturaPorID(id);
        if(factura == null){
            throw new RecursoNoEncontradoEx("No se encontro la factura con id: "+ id);
        }
        return  ResponseEntity.ok(factura);
    }

    // Nuevo método para buscar facturas por cliente
    @GetMapping("/facturas/cliente/{idCliente}")
    public ResponseEntity<List<Factura>> obtenerFacturasPorCliente(@PathVariable Integer idCliente) {
        Cliente cliente = new Cliente();
        cliente.setId_cliente(idCliente);  // Crear cliente con el id especificado
        List<Factura> facturas = facturaServicio.buscarFacturasPorCliente(cliente);

        if (facturas.isEmpty()) {
            throw new RecursoNoEncontradoEx("No se encontraron facturas para el cliente con id: " + idCliente);
        }

        // Mostrar el número del cliente en cada factura
        facturas.forEach(factura -> {
            System.out.println("Número del Cliente: " + factura.getNumeroCliente());
        });

        return ResponseEntity.ok(facturas);
    }


}
