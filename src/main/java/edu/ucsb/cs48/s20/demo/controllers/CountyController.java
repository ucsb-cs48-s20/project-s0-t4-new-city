package edu.ucsb.cs48.s20.demo.controllers;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ucsb.cs48.s20.demo.repositories.CountyRepository;


@Controller
@RequestMapping("/counties/")
public class CountyController {
	 
	private final CountyRepository countyRepository;

	@Autowired
	public CountyController(CountyRepository countyRepository) {
	       this.countyRepository = countyRepository;
	}

	 @GetMapping("list")
	 public String showUpdateForm(Model model) {
	        model.addAttribute("counties", countyRepository.findAll());
	        return "index";
	 }


}
