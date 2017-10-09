/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Data.findAll", query = "SELECT d FROM Data d")
    , @NamedQuery(name = "Data.findByDataId", query = "SELECT d FROM Data d WHERE d.dataPK.dataId = :dataId")
    , @NamedQuery(name = "Data.findByTeamid", query = "SELECT d FROM Data d WHERE d.dataPK.teamid = :teamid")
    , @NamedQuery(name = "Data.findBySystemid", query = "SELECT d FROM Data d WHERE d.dataPK.systemid = :systemid")
    , @NamedQuery(name = "Data.findByAttributeid", query = "SELECT d FROM Data d WHERE d.dataPK.attributeid = :attributeid")
    , @NamedQuery(name = "Data.findByParameterid", query = "SELECT d FROM Data d WHERE d.dataPK.parameterid = :parameterid")
    , @NamedQuery(name = "Data.findByValue", query = "SELECT d FROM Data d WHERE d.value = :value")
    , @NamedQuery(name = "Data.findByStatus", query = "SELECT d FROM Data d WHERE d.status = :status")
    , @NamedQuery(name = "Data.findByDatemodified", query = "SELECT d FROM Data d WHERE d.datemodified = :datemodified")
    , @NamedQuery(name = "Data.findByComment", query = "SELECT d FROM Data d WHERE d.comment = :comment")})
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DataPK dataPK;
    @Column(name = "Value")
    private String value;
    @Column(name = "Status")
    private String status;
    @Column(name = "Date_modified")
    @Temporal(TemporalType.DATE)
    private Date datemodified;
    @Column(name = "Comment")
    private String comment;
    @JoinColumn(name = "Attribute_id", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Attribute attribute;
    @JoinColumn(name = "Parameter_id", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Parameter parameter;
    @JoinColumn(name = "System_id", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private System system;
    @JoinColumn(name = "Team_id", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Team team;

    public Data() {
    }

    public Data(DataPK dataPK) {
        this.dataPK = dataPK;
    }

    public Data(int dataId, int teamid, int systemid, int attributeid, int parameterid) {
        this.dataPK = new DataPK(dataId, teamid, systemid, attributeid, parameterid);
    }

    public DataPK getDataPK() {
        return dataPK;
    }

    public void setDataPK(DataPK dataPK) {
        this.dataPK = dataPK;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDatemodified() {
        return datemodified;
    }

    public void setDatemodified(Date datemodified) {
        this.datemodified = datemodified;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataPK != null ? dataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Data)) {
            return false;
        }
        Data other = (Data) object;
        if ((this.dataPK == null && other.dataPK != null) || (this.dataPK != null && !this.dataPK.equals(other.dataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "heps.db.param_list.entity.Data[ dataPK=" + dataPK + " ]";
    }
    
}
