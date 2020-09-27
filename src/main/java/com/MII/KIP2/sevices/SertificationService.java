/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.KIP2.sevices;

import com.MII.KIP2.entities.Sertification;
import com.MII.KIP2.repositories.SertificationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yosef
 */
@Service
public class SertificationService {

    @Autowired
    SertificationRepository sertification;

    public List<Sertification> getAll() {
        return sertification.findAll();
    }

    public List<Sertification> showToEmp() {
        return sertification.showToEmp();
    }

    public List<Sertification> getbyIdEmp(int id) {
        return sertification.findByIdEmp(id);
    }
//
//    public void deleteKip(String serti, int emp) {
//        sertification.deleteKip(serti, emp);
//    }

    public int sertiNow(int id){
        return sertification.sertiNow(id);
    }
    public void saveSerti(Sertification s) {
        sertification.save(s);
    }

}
