package com.iit.jee.springboot.springsecurity.web;


import com.iit.jee.springboot.springsecurity.model.Convention;
import com.iit.jee.springboot.springsecurity.service.ConventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ConventionController {
	@Autowired
	private ConventionService service;


	@RequestMapping("/")
	public String viewHomePage(Model model,
							   @RequestParam(name = "page", defaultValue = "0") int page,
							   @RequestParam(name = "size", defaultValue = "5") int size,
							   @RequestParam(name = "keyword", defaultValue = "") String mc) throws ParseException {
		if (mc.equals("")) {
			Page<Convention> listConventions = service.listAll(page, size);
			model.addAttribute("listConventions", listConventions.getContent());
			model.addAttribute("pages", new int[listConventions.getTotalPages()]);
			model.addAttribute("currentPage", page);
			return "index";
		} else if (mc.contains("-")) {
			DateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date frmDate = date.parse(mc);
			Page<Convention> listConventions = service.chercher(frmDate, page, size);
			model.addAttribute("listConventions", listConventions.getContent());
			model.addAttribute("pages", new int[listConventions.getTotalPages()]);
			model.addAttribute("currentPage", page);
			return "index";

		} else {

			Page<Convention> listConventions = service.listAll2(mc, page, size);
			model.addAttribute("listConventions", listConventions.getContent());
			model.addAttribute("pages", new int[listConventions.getTotalPages()]);
			model.addAttribute("currentPage", page);
			return "index";
		}
	}



	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Convention convention = new Convention();
		model.addAttribute("convention", convention);

		return "Nouveau_Convention";
	}

	@GetMapping("/edit/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get convention from the service
		Convention convention = service.get(id);
		// set convention as a model attribute to pre-populate the form
		model.addAttribute("convention", convention);
		return "edit_convention";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.service.delete(id);
		return "redirect:/";
	}


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@RequestParam("debut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date debut,
			@RequestParam("signaturee") @DateTimeFormat(pattern = "yyyy-MM-dd") Date signaturee,
			@RequestParam("expiration") @DateTimeFormat(pattern = "yyyy-MM-dd") Date expiration,
			@RequestParam("edition") @DateTimeFormat(pattern = "yyyy-MM-dd") Date edition,
			@ModelAttribute("convention") Convention convention) {
		convention.setDeclenche(debut);
		convention.setDateEdition(edition);
		convention.setDateExpiration(expiration);
		convention.setSignature(signaturee);

		service.save(convention);

		return "redirect:/";
	}

	

	



}
