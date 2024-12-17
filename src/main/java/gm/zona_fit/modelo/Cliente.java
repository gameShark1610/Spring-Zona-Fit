package gm.zona_fit.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Data //Con esto generamos los metodos Get y Set de cada atributo de nuestra entidad/Clase
@NoArgsConstructor //Crea un constructor vacio en nuestra clase
@AllArgsConstructor //Crea un constructor con todos los argumentos
@ToString //Agrega el metodo ToString a nuestra clase
@EqualsAndHashCode //Agrega los metodos Equals y Hashcode
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Significa que la base de datos es responsable de generar un nuevo valor único para el ID de cada nuevo registro que se inserte en la tabla. Esto típicamente se hace con un campo auto-incremento.
    private Integer id; //Se trabaja con integer porque si id no tuviera nada, seria null en lugar de cero (Si se trabajara con int)
    private String nombre;
    private String apellido;
    private Integer membresia;
}
