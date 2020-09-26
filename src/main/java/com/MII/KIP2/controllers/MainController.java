/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.KIP2.controllers;

import com.MII.KIP2.entities.Accounts;
import com.MII.KIP2.entities.Employee;
import com.MII.KIP2.sevices.AccountService;
import com.MII.KIP2.sevices.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author yosef
 */
@Controller
public class MainController {
        
    @Autowired
    AccountService accountService;
    
    @Autowired
    EmployeeService employeeService;
    
    @GetMapping("")
    public String awal(Model model) {
        model.addAttribute("account", new Accounts());
        return "index";
    }
    
    @GetMapping("/index")
    public String login(Model model) {
        model.addAttribute("account", new Accounts());
        return "index";
    }
    
    @GetMapping("/adminpage")
    public String coba() {
        //model.addAttribute("account", new Accounts());
        return "adminpage";
    }
    
    @GetMapping("/kip/{id}")
    public String coba1(Model model, @PathVariable(name="id")String id) {
        model.addAttribute("employee", new Employee());
        return "kip";
    }
    
    //mengecek isi dari form login, apakah udah sesuai dengan database
    @RequestMapping("/check")
    public String checkLogin(@ModelAttribute(name = "account") Accounts accounts, Model model){
        
        //int Username = Integer.parseInt(username);
        
        System.out.println("aa");
        int username = accounts.getUsername();
        System.out.println("bb");
        String uname = Integer.toString(username);
        String password = accounts.getPassword();
        System.out.println("cc");
        if(accountService.checkusername(username)){
            System.out.println("dd");
            if(password.equalsIgnoreCase(accountService.getpass(username))){
               String role = accountService.getrole(username);
                System.out.println("ee");
               if (role.equalsIgnoreCase("employee")){
                   return "redirect:/kip/" + username;
               }else {
                   return "redirect:/adminpage";
               }
            }else {
                System.out.println("ff");
                    model.addAttribute("loginEror", true);
                    return "index";
            }
        }else {
            System.out.println("gg");
            model.addAttribute("loginError", true);
            return "index";
        }    
    }
}
