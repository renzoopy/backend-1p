package py.com.progweb.primerParcial.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USUARIOS")
public class Usuario {
    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "personaSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "personaSeq", sequenceName = "USUARIO_ID_SEQ",allocationSize = 0)
    private Integer id;

    @Column(name = "nombre", length = 50)
    @Basic(optional = false)
    private String nombre;

    @Column(name = "apellido", length = 50)
    @Basic(optional = false)
    private String apellido;

    @Column(name = "numero_documento", length = 50)
    @Basic(optional = false)
    private String numeroDocumento;

    @Column(name = "tipo_documento", length = 50)
    @Basic(optional = false)
    private String tipoDocumento;

    @Column(name = "nacionalidad", length = 50)
    @Basic(optional = false)
    private String nacionalidad;

    @Column(name = "email", length = 50)
    @Basic(optional = false)
    private String email;

    @Column(name = "telefono", length = 50)
    @Basic(optional = false)
    private String telefono;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Asuncion")
    private Date fechaNacimiento;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonManagedReference
    private List<Bolsa> listaBolsas;

    public Integer getId() {
        return id;
    }

    public Usuario setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Usuario setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public Usuario setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
        return this;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public Usuario setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        return this;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Usuario setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefono() {
        return telefono;
    }

    public Usuario setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Usuario setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public List<Bolsa> getListaBolsas() {
        return listaBolsas;
    }

    public void setListaBolsas(List<Bolsa> l) {
        this.listaBolsas = l;
    }
}
