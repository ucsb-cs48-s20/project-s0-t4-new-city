package edu.ucsb.cs48.s20.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import edu.ucsb.cs48.s20.demo.formbeans.CompareCounty;
import edu.ucsb.cs48.s20.demo.repositories.CountyRepository;


@Controller
public class CompareController {

    private CountyRepository countyRepository = null;

    @Autowired
	public void ApplicationController(CountyRepository countyRepository) {
	       this.countyRepository = countyRepository;
	}

    @GetMapping("/county/compare-select")

    public String getCountiesComparison(Model model, CompareCounty compareCounty) {  
	model.addAttribute("counties",countyRepository.findAll());
	return "counties/compare-select";
    }

    @GetMapping("/county/compare-results")

    public String getComparisonResults(Model model, CompareCounty compareCounty) {
        model.addAttribute("compareCounty", compareCounty);

        return "counties/compare-results";
    }

}
