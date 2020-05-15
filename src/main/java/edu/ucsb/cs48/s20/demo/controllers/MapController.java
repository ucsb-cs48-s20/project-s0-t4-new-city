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
public class MapController {
	 
	private final CountyRepository countyRepository;

	@Autowired
	public MapController(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
 }

    @GetMapping("/map")
    public String showSurveyForm(Model model) {
        return "map/index";
    }
}



