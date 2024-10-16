package com.proyectogestion.gestiondepagos.servicio;
import com.proyectogestion.gestiondepagos.modelo.Cliente;
import java.util.List;

public interface IClienteServicio {
    public List<Cliente> listarClientes();

    public Cliente registrarClientes(Cliente cliente);

    public void eliminarCliente(Cliente cliente);

    public Cliente buscarClientePorId(Integer id_cliente);
}
