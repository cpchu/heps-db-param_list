/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author C.M.P
 */
@Embeddable
public class DataPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Team_id")
    private int teamid;
    @Basic(optional = false)
    @Column(name = "System_id")
    private int systemid;
    @Basic(optional = false)
    @Column(name = "Attribute_id")
    private int attributeid;
    @Basic(optional = false)
    @Column(name = "Parameter_id")
    private int parameterid;

    public DataPK() {
    }

    public DataPK(int teamid, int systemid, int attributeid, int parameterid) {
        this.teamid = teamid;
        this.systemid = systemid;
        this.attributeid = attributeid;
        this.parameterid = parameterid;
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }

    public int getSystemid() {
        return systemid;
    }

    public void setSystemid(int systemid) {
        this.systemid = systemid;
    }

    public int getAttributeid() {
        return attributeid;
    }

    public void setAttributeid(int attributeid) {
        this.attributeid = attributeid;
    }

    public int getParameterid() {
        return parameterid;
    }

    public void setParameterid(int parameterid) {
        this.parameterid = parameterid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) teamid;
        hash += (int) systemid;
        hash += (int) attributeid;
        hash += (int) parameterid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataPK)) {
            return false;
        }
        DataPK other = (DataPK) object;
        if (this.teamid != other.teamid) {
            return false;
        }
        if (this.systemid != other.systemid) {
            return false;
        }
        if (this.attributeid != other.attributeid) {
            return false;
        }
        if (this.parameterid != other.parameterid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "heps.db.param_list.entity.DataPK[ teamid=" + teamid + ", systemid=" + systemid + ", attributeid=" + attributeid + ", parameterid=" + parameterid + " ]";
    }
    
}
