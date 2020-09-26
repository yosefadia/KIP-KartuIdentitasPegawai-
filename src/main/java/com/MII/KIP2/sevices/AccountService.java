/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.KIP2.sevices;


import com.MII.KIP2.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yosef
 */
@Service
public class AccountService {
    
    @Autowired
    AccountRepository account;
    
    public String getpass(int username){
        return account.findById(username).get().getPassword();
    }
    
    public String getrole(int username){
        return account.findById(username).get().getRole();
    }
    
    public boolean checkusername(int username){
        return account.existsById(username);
    }
}
