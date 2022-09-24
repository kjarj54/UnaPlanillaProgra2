/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.unaplanilla.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author UNA-Audivisuales
 */
@Entity
@Table(name = "PLAM_PLANILLAS",schema = "UNA")
@NamedQueries({
    @NamedQuery(name = "TipoPlanilla.findAll", query = "SELECT t FROM TipoPlanilla t"),
    @NamedQuery(name = "TipoPlanilla.findById", query = "SELECT t FROM TipoPlanilla t WHERE t.id = :id"),
    @NamedQuery(name = "TipoPlanilla.findByCodigoDescripcionPlanillasPorMes", query = "SELECT t FROM TipoPlanilla t WHERE UPPER(t.codigo) like :codigo and UPPER(t.descripcion) like :descripcion and UPPER(t.plaxmes) like :plaxmes", hints = @QueryHint(name= "eclipselink.refresh",value = "true")),
    @NamedQuery(name = "TipoPlanilla.findByCedulaIDEmp", query = "SELECT t FROM TipoPlanilla t Join t.empleadoList e WHERE e.cedula like :cedula and e.id like :id"),
    /*@NamedQuery(name = "TipoPlanilla.findByTplaPlaxmes", query = "SELECT t FROM TipoPlanilla t WHERE t.plaxmes = :plaxmes"),
    @NamedQuery(name = "TipoPlanilla.findByTplaAnoultpla", query = "SELECT t FROM TipoPlanilla t WHERE t.anoultpla = :anoultpla"),
    @NamedQuery(name = "TipoPlanilla.findByTplaMesultpla", query = "SELECT t FROM TipoPlanilla t WHERE t.mesultpla = :mesultpla"),
    @NamedQuery(name = "TipoPlanilla.findByTplaNumultpla", query = "SELECT t FROM TipoPlanilla t WHERE t.numultpla = :numultpla"),
    @NamedQuery(name = "TipoPlanilla.findByTplaEstado", query = "SELECT t FROM TipoPlanilla t WHERE t.estado = :estado"),
    @NamedQuery(name = "TipoPlanilla.findByTplaVersion", query = "SELECT t FROM TipoPlanilla t WHERE t.version = :version")*/})
public class TipoPlanilla implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "PLAM_PLANILLAS_TPLA_ID_GENERATOR", sequenceName = "una.PLAM_PLANILLAS_SEQ01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAM_PLANILLAS_TPLA_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "TPLA_ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "TPLA_CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "TPLA_DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "TPLA_PLAXMES")
    private Integer plaxmes;
    @Column(name = "TPLA_ANOULTPLA")
    private Integer anoultpla;
    @Column(name = "TPLA_MESULTPLA")
    private Integer mesultpla;
    @Column(name = "TPLA_NUMULTPLA")
    private Integer numultpla;
    @Basic(optional = false)
    @Column(name = "TPLA_ESTADO")
    private String estado;
    @Version
    @Column(name = "TPLA_VERSION")
    private Long version;
    @JoinTable(name = "PLAM_EMPLADOSPLANILLA", joinColumns = {
        @JoinColumn(name = "EXP_IDTPLA", referencedColumnName = "TPLA_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "EXP_IDEMP", referencedColumnName = "EMP_ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;
    

    public TipoPlanilla() {
        
    }

    public TipoPlanilla(Long tplaId) {
        this.id = tplaId;
    }

    public TipoPlanilla(Long tplaId, String tplaCodigo, String tplaDescripcion, Integer tplaPlaxmes, String tplaEstado, Long tplaVersion) {
        this.id = tplaId;
        this.codigo = tplaCodigo;
        this.descripcion = tplaDescripcion;
        this.plaxmes = tplaPlaxmes;
        this.estado = tplaEstado;
        this.version = tplaVersion;
    }
    
    public TipoPlanilla(TipoPlanillaDto tipoPlanillaDto) {
        this.id = tipoPlanillaDto.getId();
        actualizarTipoPlanilla(tipoPlanillaDto);
    }  
    
    public void actualizarTipoPlanilla(TipoPlanillaDto tipoPlanillaDto){
        this.codigo = tipoPlanillaDto.getCodigo();
        this.descripcion = tipoPlanillaDto.getDescripcion();
        this.plaxmes = tipoPlanillaDto.getPlanillasPorMes();
        this.anoultpla = tipoPlanillaDto.getAnoUltimaPlanilla();
        this.mesultpla = tipoPlanillaDto.getMesUltimaPlanilla();
        this.numultpla = tipoPlanillaDto.getNumeroUltimaPlanilla();
        this.estado = tipoPlanillaDto.getEstado();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPlaxmes() {
        return plaxmes;
    }

    public void setPlaxmes(Integer plaxmes) {
        this.plaxmes = plaxmes;
    }

    public Integer getAnoultpla() {
        return anoultpla;
    }

    public void setAnoultpla(Integer anoultpla) {
        this.anoultpla = anoultpla;
    }

    public Integer getMesultpla() {
        return mesultpla;
    }

    public void setMesultpla(Integer mesultpla) {
        this.mesultpla = mesultpla;
    }

    public Integer getNumultpla() {
        return numultpla;
    }

    public void setNumultpla(Integer numultpla) {
        this.numultpla = numultpla;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPlanilla)) {
            return false;
        }
        TipoPlanilla other = (TipoPlanilla) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.unaplanilla.model.TipoPlanilla[ tplaId=" + id + " ]";
    }
    
}
