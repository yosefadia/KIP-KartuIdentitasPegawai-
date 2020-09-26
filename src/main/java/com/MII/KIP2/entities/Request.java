/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.KIP2.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yosef
 */
@Entity
@Table(name = "request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r")
    , @NamedQuery(name = "Request.findById", query = "SELECT r FROM Request r WHERE r.id = :id")
    , @NamedQuery(name = "Request.findByKodereq", query = "SELECT r FROM Request r WHERE r.kodereq = :kodereq")
    , @NamedQuery(name = "Request.findByKetemp", query = "SELECT r FROM Request r WHERE r.ketemp = :ketemp")
    , @NamedQuery(name = "Request.findByKetadmin", query = "SELECT r FROM Request r WHERE r.ketadmin = :ketadmin")})
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "kodereq")
    private String kodereq;
    @Basic(optional = false)
    @Column(name = "ketemp")
    private String ketemp;
    @Basic(optional = false)
    @Column(name = "ketadmin")
    private String ketadmin;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status status;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public Request() {
    }

    public Request(Integer id) {
        this.id = id;
    }

    public Request(Integer id, String kodereq, String ketemp, String ketadmin) {
        this.id = id;
        this.kodereq = kodereq;
        this.ketemp = ketemp;
        this.ketadmin = ketadmin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKodereq() {
        return kodereq;
    }

    public void setKodereq(String kodereq) {
        this.kodereq = kodereq;
    }

    public String getKetemp() {
        return ketemp;
    }

    public void setKetemp(String ketemp) {
        this.ketemp = ketemp;
    }

    public String getKetadmin() {
        return ketadmin;
    }

    public void setKetadmin(String ketadmin) {
        this.ketadmin = ketadmin;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.MII.KIP2.entities.Request[ id=" + id + " ]";
    }
    
}
