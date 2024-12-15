package gm.zona_fit.servicio;

import gm.zona_fit.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {
    public List<Cliente> listarClientes();
    public Cliente buscarClientePorId(Integer idCliente);
    public void guardarCliente(Cliente cliente); //Este nos permite guardar y actualizar a la vez
    public  void eliminarCliente(Cliente cliente);
}
