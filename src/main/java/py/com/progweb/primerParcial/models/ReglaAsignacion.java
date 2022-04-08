package py.com.progweb.primerParcial.models;

import javax.persistence.*;

@Entity
@Table(name = "REGLA_ASIGNACION_PUNTOS")
public class ReglaAsignacion {

    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "reglaAsignacionSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "reglaAsignacionSeq", sequenceName = "regla_asignacion_puntos_seq", allocationSize = 0)
    private Integer id;

    @Column(name = "limite_inferior")
    @Basic(optional = false)
    private Integer limiteInferior;

    @Column(name = "limite_superior")
    @Basic(optional = false)
    private Integer limiteSuperior;

    @Basic(optional = false)
    private Integer equivalencia;

    public Integer getId() {
        return id;
    }

    public ReglaAsignacion setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getLimiteInferior() {
        return limiteInferior;
    }

    public ReglaAsignacion setLimiteInferior(Integer limiteInferior) {
        this.limiteInferior = limiteInferior;
        return this;
    }

    public Integer getLimiteSuperior() {
        return limiteSuperior;
    }

    public ReglaAsignacion setLimiteSuperior(Integer limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
        return this;
    }

    public Integer getEquivalencia() {
        return equivalencia;
    }

    public ReglaAsignacion setEquivalencia(Integer equivalencia) {
        this.equivalencia = equivalencia;
        return this;
    }
}
