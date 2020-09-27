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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yosef
 */
@Entity
@Table(name = "sertifications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sertification.findAll", query = "SELECT s FROM Sertification s")
    , @NamedQuery(name = "Sertification.findById", query = "SELECT s FROM Sertification s WHERE s.id = :id")
    , @NamedQuery(name = "Sertification.findByName", query = "SELECT s FROM Sertification s WHERE s.name = :name")
    , @NamedQuery(name = "Sertification.findByRoom", query = "SELECT s FROM Sertification s WHERE s.room = :room")
    , @NamedQuery(name = "Sertification.findByDay", query = "SELECT s FROM Sertification s WHERE s.day = :day")
    , @NamedQuery(name = "Sertification.findByTime", query = "SELECT s FROM Sertification s WHERE s.time = :time")
    , @NamedQuery(name = "Sertification.findByTeacher", query = "SELECT s FROM Sertification s WHERE s.teacher = :teacher")
    , @NamedQuery(name = "Sertification.findByQuota", query = "SELECT s FROM Sertification s WHERE s.quota = :quota")})
public class Sertification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "room")
    private String room;
    @Basic(optional = false)
    @Column(name = "day")
    private String day;
    @Basic(optional = false)
    @Column(name = "time")
    private String time;
    @Basic(optional = false)
    @Column(name = "teacher")
    private String teacher;
    @Basic(optional = false)
    @Column(name = "quota")
    private int quota;

    public Sertification() {
    }

    public Sertification(String id) {
        this.id = id;
    }

    public Sertification(String id, String name, String room, String day, String time, String teacher, int quota) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.day = day;
        this.time = time;
        this.teacher = teacher;
        this.quota = quota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
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
        if (!(object instanceof Sertification)) {
            return false;
        }
        Sertification other = (Sertification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.MII.KIP2.entities.Sertification[ id=" + id + " ]";
    }
    
}
