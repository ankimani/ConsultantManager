package com.albert.consultantManager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.albert.consultantManager.model.Consultant;
import com.albert.consultantManager.service.consultantService;

@Controller
public class consultantController {
	@Autowired
	private consultantService consultantservice;

	@GetMapping("/")
	public String HomePage(Model model) {
		model.addAttribute("consultantList", consultantservice.getAllConsultants());
		return "index";
	}

	@GetMapping("/ShowNewConsultantForm")
	public String ShowNewConsultantForm(Model model) {
		Consultant consultant = new Consultant();
		model.addAttribute("consultant", consultant);

		return "new_consultant";
	}

	@PostMapping("/saveConsultant")
	public String saveConsultant(@Valid @RequestBody @ModelAttribute("consultant") Consultant consultant) {
		consultantservice.saveConsultant(consultant);
		return "redirect:/";
	}

	@GetMapping("/deleteConsultant/{id}")
	public String deleteConsultant(@PathVariable(value = "id") long id) {
		this.consultantservice.deleteConsultantById(id);
		return "redirect:/";
	}

	@GetMapping("/showFormforUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Consultant consultant = consultantservice.getConsultantById(id);
		model.addAttribute("consultant", consultant);
		return "update_consultant";
	}
}
