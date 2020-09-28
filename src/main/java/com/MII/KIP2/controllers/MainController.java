/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MII.KIP2.controllers;

import com.MII.KIP2.entities.Accounts;
import com.MII.KIP2.entities.Sertification;
import com.MII.KIP2.sevices.AccountService;
import com.MII.KIP2.sevices.EmployeeService;
import com.MII.KIP2.sevices.SertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @Autowired
    SertificationService sertificationService;

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

    @RequestMapping("/kip/{id}")
    public ModelAndView kip(Model model, @PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("kip");
        int Id = Integer.parseInt(id);
        mav.addObject("serti", new Sertification());
        mav.addObject("total", sertificationService.sertiNow(Id));
        //mav.addObject("sertiff", sertificationService.getbyIdEmp(Id));
        mav.addObject("pegawai", employeeService.getById(Id));
        //model.addAttribute("sertifikat", sertificationService.showToEmp());
        return mav;
    }
    
    @GetMapping("/jadwal/{id}")
    public String jadwal(@PathVariable(name = "id") String id, Model model){
        int Id = Integer.parseInt(id);
        model.addAttribute("sertiff", sertificationService.getbyIdEmp(Id));
        model.addAttribute("pegawai", employeeService.getById(Id));
        model.addAttribute("sertifikat", sertificationService.showToEmp());
        return "jadwal";
}

    //mengecek isi dari form login, apakah udah sesuai dengan database
    @RequestMapping("/check")
    public String checkLogin(@ModelAttribute(name = "account") Accounts accounts, Model model) {

        int username = accounts.getUsername();
        String uname = Integer.toString(username);
        String password = accounts.getPassword();
        if (accountService.checkusername(username)) {
            if (password.equalsIgnoreCase(accountService.getpass(username))) {
                String role = accountService.getrole(username);
                if (role.equalsIgnoreCase("employee")) {
                    return "redirect:/kip/" + username;
                } else {
                    return "redirect:/adminpage";
                }
            } else {
                model.addAttribute("loginError", true);
                return "index";
            }
        } else {
            model.addAttribute("loginError", true);
            return "index";
        }
    }

//    CONTROLLER UNTUK ADMIN
    
    @GetMapping("/adminpage")
    public String coba() {
        //model.addAttribute("account", new Accounts());
        return "adminpage";
    }
}
