package gm.zona_fit.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Significa que la base de datos es responsable de generar un nuevo valor único para el ID de cada nuevo registro que se inserte en la tabla. Esto típicamente se hace con un campo auto-incremento.
    private Integer id; //Se trabaja con integer porque si id no tuviera nada, seria null en lugar de cero (Si se trabajara con int)
    private String nombre;
    private String apellido;
    private Integer membresia;


}
