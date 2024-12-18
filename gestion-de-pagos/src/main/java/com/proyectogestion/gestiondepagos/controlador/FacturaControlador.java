package com.proyectogestion.gestiondepagos.controlador;


import com.proyectogestion.gestiondepagos.excepcion.RecursoNoEncontradoEx;
import com.proyectogestion.gestiondepagos.modelo.Cliente;
import com.proyectogestion.gestiondepagos.modelo.Entidad;
import com.proyectogestion.gestiondepagos.modelo.Factura;
import com.proyectogestion.gestiondepagos.modelo.FacturaDTO;
import com.proyectogestion.gestiondepagos.servicio.ClienteServicio;
import com.proyectogestion.gestiondepagos.servicio.EntidadServicio;
import com.proyectogestion.gestiondepagos.servicio.FacturaServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private EntidadServicio entidadServicio;

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
    @PostMapping("/generarFactura")
    public ResponseEntity<?> registrarFactura(@RequestBody FacturaDTO facturaDTO) {
        try {
            Factura facturaGuardada = facturaServicio.registrarFacturaMet(facturaDTO);
            return ResponseEntity.ok(facturaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno: " + e.getMessage());
        }
    }
    //buscar la factura por el id
    @GetMapping("/facturas/{id}")
    public ResponseEntity<Factura> obtenerFactPorId(@PathVariable Integer id){
        Factura factura = facturaServicio.buscarFacturaPorID(id);
        if(factura == null){
            throw new RecursoNoEncontradoEx("No se encontro la factura con id: "+ id);
        }
        return  ResponseEntity.ok(factura);
    }
    // buscar facturas por el id del cliente
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
    //buscar factura por el número de la factura
    @GetMapping("/factura/numero/{numeroFactura}")
    public ResponseEntity<Factura> obtenerFacturaPorNum(@PathVariable Integer numeroFactura) {
        Factura factura = facturaServicio.buscarFacturaPorNum(numeroFactura);
        if (factura == null) {
            throw  new RecursoNoEncontradoEx("factura inexistente");
        }
        return ResponseEntity.ok(factura);
    }
    //buscar facturas por entidad
    @GetMapping("/facturas/entidad/{idEntidad}")
    public ResponseEntity<List<Factura>>obtenerFacturasPorEntidad(@PathVariable Integer idEntidad){
        Entidad entidad = new Entidad();
        entidad.setId_entidad((idEntidad));
        List<Factura> facturas = facturaServicio.buscarFacturasPorEntidad(entidad);
        if(facturas.isEmpty()){
            throw new RecursoNoEncontradoEx("La Entidad"+ idEntidad+" no existe");
        }
        facturas.forEach(factura -> {
            System.out.println("Numero de la entidad: "+factura.getNumeroFactura());
        });
        return ResponseEntity.ok(facturas);
    }
    //buscar por nombre de cliente en factura
    @GetMapping("/facturas/cliente_nombre/{nombreCliente}")
    public List<Factura> obtenerPagosPorNombreCliente(@RequestParam("nombreCliente") String nombreCliente){
        return facturaServicio.buscarPagosPorCliente(nombreCliente) ;
    }
    @GetMapping("/facturas/cantidad")
    public long contarFacturas(){
        return facturaServicio.contarFacturas();
    }
}
