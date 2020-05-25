package edu.ucsb.cs48.s20.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import edu.ucsb.cs48.s20.demo.formbeans.CountyFilter;
import edu.ucsb.cs48.s20.demo.repositories.CountyRepository;


@Controller
public class FilterController {

    private CountyRepository countyRepository = null;

    @Autowired
    public void ApplicationController(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    @GetMapping("/county/search")

    public String getCountiesFilter(CountyFilter countyFilter) {
        return "counties/filter";
    }

    @GetMapping("/county/results")

    public String getCountiesResults(Model model, CountyFilter countyFilter) {
        model.addAttribute("countyFilter", countyFilter);

        model.addAttribute("counties",
                           countyRepository.findByAverageIncomeBetweenAndHousePriceBetween(countyFilter.getMinincome(),
                                   countyFilter.getMaxincome(), countyFilter.getMinhousecost(), countyFilter.getMaxhousecost() ));

        return "counties/results";
    }

}
