package gm.zona_fit;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

    @Autowired //Inyectamos dependencias
    private IClienteServicio clienteServicio;

    private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

	String nl = System.lineSeparator(); //Obtiene el salto de linea de forma generica (Linux,Mac,Windows)

    public static void main(String[] args) {
        logger.info("Iniciando la aplicacion");
        //Levantar la fabrica de Spring
        SpringApplication.run(ZonaFitApplication.class, args);


        logger.info("Aplicacion Finalizada");
    }

    @Override
    public void run(String... args) throws Exception { //Este metodo solo se ejecuta si esta en funcionamiento la fabrica de Spring
        zonaFitApp();
		//Ya no se trabaja sobre la main


    }

	private void zonaFitApp(){
		logger.info(nl + "*** Aplicacion Zona Fit (GYM) ***" + nl);
		var salir = false;
		Scanner consola = new Scanner(System.in);
		while (!salir) {
				var opcion = mostrarMenu(consola);
				salir = ejecutarOpciones(consola, opcion);
				logger.info(nl);
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info(nl +"""
                1. Listar clientes
                2. Buscar cliente
                3. Agregar cliente
                4. Modificar cliente
                5. Eliminar cliente
                6. Salir
                Elige una opcion:\s""" + nl);
		return  Integer.parseInt(consola.nextLine());
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion) {
		var salir = false;
		switch (opcion) {
			case 1 -> { // 1. Listar Clientes
				logger.info(nl + "--- Listado de clientes ---" + nl);
				List<Cliente> clientes = clienteServicio.listarClientes();
				clientes.forEach(cliente -> logger.info(cliente.toString() + nl));
			}

			case 2 -> { // 2. Buscar cliente por id
					logger.info(nl + "--- Buscar Cliente por Id ---"+ nl);
					var idCliente = Integer.parseInt(consola.nextLine());
					Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
					if (cliente != null)
						logger.info("Cliente encontrado: " + cliente + nl);
					else
						logger.info("Cliente NO encontrado: " + cliente + nl);
				}

			case 3 -> { // 3. Agregar cliente
				logger.info(nl + "--- Agregar Cliente ---" + nl);
				logger.info("Nombre: " + nl);
				var nombre = consola.nextLine();
				logger.info("Apellido: "+ nl);
				var apellido = consola.nextLine();
				logger.info("Membresia: "+ nl);
				var membresia = Integer.parseInt(consola.nextLine());
				var cliente = new Cliente();
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setMembresia(membresia);
				clienteServicio.guardarCliente(cliente);
				logger.info("Cliente agregado: "+cliente + nl);
			}

			case 4 -> {
				logger.info("--- Modificar Cliente ---" + nl);
				logger.info("Id Cliente: ");
				var idCliente = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if(cliente != null){
					logger.info("Nombre: " );
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Membresia: ");
					var membresia = Integer.parseInt(consola.nextLine());
					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setMembresia(membresia);
					clienteServicio.guardarCliente(cliente);
					logger.info("Cliente modificado: " + cliente + nl);
				}
			}

			case 5 -> {
				logger.info("--- Eliminar Cliente ---" + nl);
				logger.info("Id Cliente: ");
				var idCliente = Integer.parseInt(consola.nextLine());
				var cliente = clienteServicio.buscarClientePorId(idCliente);
				if(cliente != null){
					clienteServicio.eliminarCliente(cliente);
					logger.info("Cliente eliminado: " + cliente + nl);
				}
				else
					logger.info("Cliente No encontrado: " + cliente + nl);
			}

			case 6 -> {// 6. Salir
				logger.info("Hasta pronto" + nl);
				salir=true;
			}
			default -> logger.info("Opcion no reconocida: "+ opcion + nl);

			}


			return salir;
		}
	}




