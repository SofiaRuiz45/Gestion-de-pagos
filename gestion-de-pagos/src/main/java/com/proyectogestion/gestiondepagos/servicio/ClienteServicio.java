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

}
