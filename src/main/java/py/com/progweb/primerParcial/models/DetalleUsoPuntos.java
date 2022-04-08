package py.com.progweb.primerParcial.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "detalle_uso_puntos")
public class DetalleUsoPuntos {
    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "detalleUsoPuntosSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "detalleUsoPuntosSeq", sequenceName = "detalle_puntos_sec", allocationSize = 0)
    private Integer id;

    @JoinColumn(name = "uso_puntos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonBackReference
    private UsoPuntos usoPuntos;

    @Column(name = "puntaje_utilizado")
    @Basic(optional = false)
    private Integer puntajeUtilizado;

    @JoinColumn(name = "bolsa_id", referencedColumnName = "id_bolsa")
    @ManyToOne(optional = false)
    private Bolsa bolsa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsoPuntos getUsoPuntos() {
        return usoPuntos;
    }

    public DetalleUsoPuntos setUsoPuntos(UsoPuntos usoPuntos) {
        this.usoPuntos = usoPuntos;
        return this;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public DetalleUsoPuntos setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
        return this;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public DetalleUsoPuntos setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
        return this;
    }
}
