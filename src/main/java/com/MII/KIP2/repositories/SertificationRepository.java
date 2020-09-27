/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.KIP2.repositories;


import com.MII.KIP2.entities.Sertification;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yosef
 */
@Repository
public interface SertificationRepository extends JpaRepository<Sertification, String>{
    
    @Modifying
    @Query(value = "SELECT * FROM sertifications INNER JOIN schedule ON sertifications.id=schedule.sertification  WHERE schedule.employee = ?1", nativeQuery = true)
    List<Sertification> findByIdEmp(int id);
    
    
    @Query(value = "SELECT * FROM sertifications WHERE quota>0", nativeQuery = true)
    public List<Sertification> showToEmp();
    
//    @Modifying
//    @Query(value = "DELETE FROM schedule WHERE schedule.sertification=:id AND schedule.employee=:id", nativeQuery = true )
//    void deleteKip(@Param("id") String serti, @Param("id") int emp);
//    
//    @Modifying
//    @Query(value = "DELETE FROM schedule WHERE schedule.sertification =:id", nativeQuery = true)
//    void deleteKipByKode(@Param("id") String id);
//    
//    @Modifying
//    @Query(value = "INSERT INTO schedule VALUES (?1,?2)", nativeQuery=true)
//    void savetokip(int emp, String sertif);
    
    
    @Query(value = "SELECT COUNT(*) FROM schedule WHERE employee = ?1", nativeQuery=true)
    int sertiNow(int id);
    
    
}
