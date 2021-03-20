package tecnica.com.prueba.modelo;

import javax.persistence.*;

@Entity
@Table(name="profeosr")
public class Profesor{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String nombreProfesor;
    private String apellidoProfesor;
    private String area;
    private String correo;

    public Profesor(){}
}