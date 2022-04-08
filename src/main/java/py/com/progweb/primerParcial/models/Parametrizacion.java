package py.com.progweb.primerParcial.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "parametrizacion_puntos")
public class Parametrizacion {
    @Id
    @Column(name="id")
    @Basic(optional = false)
    @GeneratedValue(generator = "parametrizacionSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "parametrizacionSec", sequenceName = "parametrizacion_sec", allocationSize = 0)
    private Integer id;

    @Column(name="fecha_inicio")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Asuncion")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Asuncion")
    private Date fechaFin;

    @Column(name="duracion")
    @Basic(optional = false)
    private Integer duracion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fecha_inicio) {
        this.fechaInicio = fecha_inicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fecha_fin) {
        this.fechaFin = fecha_fin;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
}
