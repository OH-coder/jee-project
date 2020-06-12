package com.iit.jee.Conventions.web;

import com.iit.jee.Conventions.Services.ConventionService;
import com.iit.jee.Conventions.entities.Convention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class ConventionController {
    @Autowired
    private ConventionService service;
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Convention> listConventions = service.listAll();
        model.addAttribute("listConventions", listConventions);
        return "index";
    }
    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Convention convention = new Convention();
        model.addAttribute("convention",convention );

        return "Nouveau_Convention";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@RequestParam("debut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date debut  ,@RequestParam("signaturee") @DateTimeFormat(pattern = "yyyy-MM-dd") Date signaturee, @RequestParam("expiration") @DateTimeFormat(pattern = "yyyy-MM-dd") Date expiration ,@RequestParam("edition") @DateTimeFormat(pattern = "yyyy-MM-dd") Date edition , @ModelAttribute("convention") Convention convention) {
convention.setDeclenche(debut);
convention.setDateEdition(edition);
convention.setDateExpiration(expiration);
convention.setSignature(signaturee);

        service.save(convention);

        return "redirect:/";
    }

}
