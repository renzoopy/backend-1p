package py.com.progweb.primerParcial.models;

import javax.persistence.*;

@Entity
@Table(name="concepto_uso_puntos")
public class ConceptoUsoPuntos{
    @Id
    @Column(name="id")
    @Basic(optional = false)
    @GeneratedValue(generator = "puntosSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "puntosSec", sequenceName = "concepto_uso_puntos_sec", allocationSize = 0)
    private Integer id;
    @Column(name="descripcion", length = 150)
    @Basic(optional = false)
    private String descripcion;
    @Column(name="puntos_requeridos")
    @Basic(optional = false)
    private Integer puntosRequeridos;

    public Integer getId() {
        return id;
    }

    public ConceptoUsoPuntos setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ConceptoUsoPuntos setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Integer getPuntosRequeridos() {
        return puntosRequeridos;
    }

    public ConceptoUsoPuntos setPuntosRequeridos(Integer puntos_requeridos) {
        this.puntosRequeridos = puntos_requeridos;
        return this;
    }
}
