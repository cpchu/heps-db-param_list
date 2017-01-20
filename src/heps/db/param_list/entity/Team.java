/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author C.M.P
 */
@Entity
@Table(name = "team")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
    @NamedQuery(name = "Team.findById", query = "SELECT t FROM Team t WHERE t.id = :id"),
    @NamedQuery(name = "Team.findByName", query = "SELECT t FROM Team t WHERE t.name = :name")})
public class Team implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private Collection<Data> dataCollection;
    @JoinColumn(name = "Manager_id", referencedColumnName = "Id")
    @ManyToOne
    private Manager managerid;
    @OneToMany(mappedBy = "parentid")
    private Collection<Team> teamCollection;
    @JoinColumn(name = "Parent_id", referencedColumnName = "Id")
    @ManyToOne
    private Team parentid;

    public Team() {
    }

    public Team(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Data> getDataCollection() {
        return dataCollection;
    }

    public void setDataCollection(Collection<Data> dataCollection) {
        this.dataCollection = dataCollection;
    }

    public Manager getManagerid() {
        return managerid;
    }

    public void setManagerid(Manager managerid) {
        this.managerid = managerid;
    }

    @XmlTransient
    public Collection<Team> getTeamCollection() {
        return teamCollection;
    }

    public void setTeamCollection(Collection<Team> teamCollection) {
        this.teamCollection = teamCollection;
    }

    public Team getParentid() {
        return parentid;
    }

    public void setParentid(Team parentid) {
        this.parentid = parentid;
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
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "heps.db.param_list.entity.Team[ id=" + id + " ]";
    }
    
}
