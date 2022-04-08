package py.com.progweb.primerParcial.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "uso_puntos")
public class UsoPuntos {
    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "usoPuntosSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "usoPuntosSeq", sequenceName = "uso_puntos_sec", allocationSize = 0)
    private Integer id;

    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuario;

    @Column(name = "puntaje_utilizado")
    @Basic(optional = false)
    private Integer puntajeUtilizado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Asuncion")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @JoinColumn(name = "concepto_uso_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConceptoUsoPuntos conceptoUso;

    @OneToMany(mappedBy = "usoPuntos", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonManagedReference
    private List<DetalleUsoPuntos> detalle;

    public Integer getId() {
        return id;
    }

    public UsoPuntos setId(Integer id) {
        this.id = id;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public UsoPuntos setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public UsoPuntos setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
        return this;
    }

    public Date getFecha() {
        return fecha;
    }

    public UsoPuntos setFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public ConceptoUsoPuntos getConceptoUso() {
        return conceptoUso;
    }

    public UsoPuntos setConceptoUso(ConceptoUsoPuntos conceptoUso) {
        this.conceptoUso = conceptoUso;
        return this;
    }

    public List<DetalleUsoPuntos> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleUsoPuntos> detalle) {
        this.detalle = detalle;
    }
}
