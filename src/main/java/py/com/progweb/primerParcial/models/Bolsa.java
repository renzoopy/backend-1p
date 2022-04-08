package py.com.progweb.primerParcial.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bolsa")
public class Bolsa {
    @Id
    @Column(name = "id_bolsa")
    @Basic(optional = false)
    @GeneratedValue(generator = "bolsaSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "bolsaSec", sequenceName = "bolsa_sec", allocationSize = 0)
    private Integer id;

    @Column(name = "fecha_asignacion")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Asuncion")
    private Date fechaAsignacion;

    @Column(name = "fecha_caducidad")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Asuncion")
    private Date fechaCaducidad;

    @Column(name = "puntaje_asignado")
    @Basic(optional = false)
    private Integer puntajeAsignado;

    @Column(name = "puntaje_utilizado")
    @Basic(optional = false)
    private Integer puntajeUtilizado;

    @Column(name = "saldo")
    @Basic(optional = false)
    private Integer saldo;

    @Column(name = "monto")
    @Basic(optional = false)
    private Integer monto;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public Bolsa setId(Integer idBolsa) {
        this.id = idBolsa;
        return this;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public Bolsa setFechaAsignacion(Date fecha_asignacion) {
        this.fechaAsignacion = fecha_asignacion;
        return this;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public Bolsa setFechaCaducidad(Date fecha_caducidad) {
        this.fechaCaducidad = fecha_caducidad;
        return this;
    }

    public Integer getPuntajeAsignado() {
        return puntajeAsignado;
    }

    public Bolsa setPuntajeAsignado(Integer puntaje_asignado) {
        this.puntajeAsignado = puntaje_asignado;
        return this;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public Bolsa setPuntajeUtilizado(Integer puntaje_utilizado) {
        this.puntajeUtilizado = puntaje_utilizado;
        return this;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public Bolsa setSaldo(Integer saldo) {
        this.saldo = saldo;
        return this;
    }

    public Integer getMonto() {
        return monto;
    }

    public Bolsa setMonto(Integer monto) {
        this.monto = monto;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Bolsa setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }
}
