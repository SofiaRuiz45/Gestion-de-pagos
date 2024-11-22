package com.proyectogestion.gestiondepagos.servicio;
import com.proyectogestion.gestiondepagos.modelo.Cliente;
import com.proyectogestion.gestiondepagos.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio {


    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente registrarClientes(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepositorio.delete(cliente);
    }

    @Override
    public Cliente buscarClientePorId(Integer id_cliente) {
        Cliente cliente = clienteRepositorio.findById(id_cliente).orElse(null);
        return cliente;
    }

    @Override
    public long contarClientes() {
        return clienteRepositorio.count();
    }

    @Override
    public Cliente obtenerClienteConNombre(String nombreCliente) {
        Cliente cliente = clienteRepositorio.findByNombreCliente(nombreCliente);
        return cliente;
    }

    @Override
    public String obtenerNombrePorCuitCliente(Long cuitCliente) {
        Cliente cliente = clienteRepositorio.findByCuitCliente(cuitCliente);
        return (cliente != null) ? cliente.getNombreCliente() : null;
    }

}
